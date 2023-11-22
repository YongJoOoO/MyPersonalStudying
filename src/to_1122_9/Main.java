package to_1122_9;
import java.util.*;

class Edge implements Comparable<Edge>{
    int start, end, distance;
    
    public Edge(int start, int end, int distance){
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Edge other){
        return this.distance - other.distance;
    }
}

public class Main {
    static int[] parent;
    
    static int find(int node){
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
    
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
    //실행 메인
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int TC = scanner.nextInt();
        for(int t = 1; t <= TC; t++){
            int checkpoints = scanner.nextInt();
            int paths = scanner.nextInt();
            
            List<Edge> edges = new ArrayList<>();
            
            for(int i = 0; i < paths; i++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int distance = scanner.nextInt();
                edges.add(new Edge(start, end, distance));
            }
            
            Collections.sort(edges);
            parent = new int[checkpoints + 1];
            for(int i = 1; i <= checkpoints; i++) parent[i] = i;
            
            int minDistance = 0;
            int edgesTaken = 0;
            
            for(Edge edge : edges){
                if(edgesTaken == checkpoints - 1) break;
                
                if(find(edge.start) != find(edge.end)){
                    union(edge.start, edge.end);
                    minDistance += edge.distance;
                    edgesTaken++;
                }
            }
            
            System.out.println("Case #" + t + ": " + minDistance + " meters");
        }
    }
    
}