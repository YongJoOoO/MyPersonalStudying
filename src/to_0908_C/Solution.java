package to_0908_C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static int[] distance;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
        
    //다익스트라 
    static void dijkstra(int s){
        Arrays.fill(distance, Integer.MAX_VALUE);
        //시작점 초기화
        distance[s] = 0;
        //최단거리 우선하도록 
        PriorityQueue<int[]> pQ= new PriorityQueue<>((a, b) -> a[1]-b[1]);
        //e로 가는 거리 (가중치)  s, 0 순으로 
        pQ.offer(new int[] {s, 0});
        
        while(!pQ.isEmpty()){
            int[] cur = pQ.poll();
            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            
            for(int nx : graph.get(cur[0])){
                if(!visited[nx] && distance[nx] > distance[cur[0]] + 1 ){
                    distance[nx] = distance[cur[0]] + 1;
                    pQ.offer(new int[] {nx, distance[nx]});
                }
            }
        }
    }
    //solution 
    public int solution(int n, int[][] edge) {
        
        distance = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] x : edge){
            int a = x[0];
            int b = x[1];
            //양방향 간선이므로 
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        dijkstra(1);
        
        
        int answer = 0;
        int maxNum = 0;
        for(int i=2; i<=n; i++) {
            maxNum = Math.max(maxNum, distance[i]); // maxNum: 가장 먼 거리
        }
        
        for(int i=2; i<=n; i++) {
            if(maxNum == distance[i]) answer++; // 가장 먼 거리의 노드 수 세기
        }
        return answer;
    }
    //실행 메인 
    public static void main(String[] args){
		Solution T = new Solution();
		int[][] arr = {{3, 6}, {4,3}, {3,2}, {1, 3}, {1, 2} ,{2, 4} ,{5, 2}};
		
		//solution(6, arr);
		System.out.println(T.solution(6, arr));
    }
}