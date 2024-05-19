package to_240509;
import java.util.*;

class Edge implements Comparable<Edge>{
    int e, val;
    Edge(int e, int val){
        this.e =e;
        this.val = val;
    }
    @Override
    public int compareTo(Edge o) {
        return this.val- o.val;//가중치 오름차순
    }
}
public class Main {
    static List<List<Edge>> graph;
    static int N, M;
    static int[] distance;
    //간선 연결 정보를 현재 정점-다음 정점 순으로 담아야 되나 ?

    static int[] routine;
    //dijkstra
    static void dijkstra(int st){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        distance[st] = 0;
        pQ.offer(new Edge(st, 0));

        while(!pQ.isEmpty()) {
            Edge cur = pQ.poll();
            if (cur.val > distance[cur.e])
                continue;
            for (Edge nx : graph.get(cur.e)) {
                if (distance[nx.e] > distance[cur.e] + nx.val) {
                    distance[nx.e] = distance[cur.e] + nx.val;
                    pQ.offer(new Edge(nx.e, distance[nx.e]));
                    routine[cur.e] = nx.e;//경로도 담기
                }
            }
        }
    }

    //실행 메인
    public static void main(String[] args) {
        Scanner kb=  new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        routine = new int[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        //데이터 입력
        for(int i=0; i<M; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int v = kb.nextInt();
            //양바향 간선
            graph.get(a).add(new Edge(b, v));
            graph.get(b).add(new Edge(a, v));
        }

        dijkstra(1);

        for(int x : distance) System.out.println(x);
        System.out.println("HEllo");
    }
}
