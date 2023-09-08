package to_0908_F;
import java.util.*;

class Solution {
 	static ArrayList<ArrayList<Integer>> graph;
    static int[] distance;
    static boolean[] visited;
    
    // 다익스트라로 start로부터 다른 노드까지 최단 거리(dirs) 구하기
    private static void dijkstra(int start) { 
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1]-b[1]); // 우선순위 큐
        pQ.offer(new int[] {start, 0}); // 나와의 거리는 0
        distance[start] = 0; // 나와의 거리는 0
        
        while(!pQ.isEmpty()) {
            int[] cur = pQ.poll(); // 가장 가까운 거리를 가진 노드가 poll된다.
            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            for(int nx : graph.get(cur[0])) {
            	if(!visited[nx] && distance[nx] > distance[cur[0]] + 1) {
            		distance[nx] = distance[cur[0]] + 1;
            		pQ.offer(new int[] {nx, distance[nx]});
            	}
            }
        }
    }

    public int solution(int n, int[][] edge) {
       
    	graph = new ArrayList<>();
    	distance = new int[n+1]; // 1로부터 다른 노드까지의 최단 거리 
        visited = new boolean[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE); // 최댓값으로 초기화
        for(int i=0; i<= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] x : edge) {
        	int a = x[0];
        	int b = x[1];
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