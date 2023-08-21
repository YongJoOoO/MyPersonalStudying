package to_0821_1;
/*1번- 그래프 최단거리 문풀 - 최소 비행료 - 다익스크라 */
import java.util.*;
class Edge implements Comparable<Edge>{
	int v;
	int val;
	Edge(int v, int val){
		this.v = v;
		this.val=val;
	}
	public int compareTo(Edge o) {
		return this.val - o.val;//적은 가중치 우선 
	};
}
class Solution {
	static int distance[];//거리배열
	static boolean visited[];
	static ArrayList<ArrayList<Edge>> graph;
	static PriorityQueue<Edge> pQ = new PriorityQueue<>();
	
	//solution
	public int solution(int n, int[][] flights, int s, int e, int k){
		
		distance = new int[flights.length];//간선 개수만큼 거리배열 만들고
		visited = new boolean[flights.length];
		graph = new ArrayList<>();
		for(int i=0; i<n; i++) { //정점 개수마늠 그래프
			graph.add(new ArrayList<Edge>());
		}
		
		Arrays.fill(distance, Integer.MAX_VALUE);//무한대값으로 초기화 
		
		for(int[] x : flights) {
			int u = x[0];//출발
			int v = x[1];//종료
			int w = x[2];//가중치
			//방향 그래프이므로 이런 식으로 저장시킴
			graph.get(u).add(new Edge(v, w));
		}
		
		//시작점 처리
		pQ.add(new Edge(s, 0));//s->s 자기 자신에 대한 가중치 0 세팅
		distance[s]=0;//거리 0
		 
		//레벨 탐색 
		int lv = 0;
		while(!pQ.isEmpty()) {
			
			for(int i = 0; i<pQ.size(); i++) {
				Edge cur = pQ.poll();
				int cur_v = cur.v;
				int cur_val = cur.val;
				if(visited[cur_v]) continue;
				visited[cur_v] = true;
				
				for(Edge nx : graph.get(cur_v)) {
					int nx_v = nx.v;
					int nx_val = nx.val;
					if(!visited[nx_v] && distance[nx_v] > distance[cur_v] + nx_val) {
						distance[nx_v] = distance[cur_v] + nx_val;
						pQ.add(new Edge(nx_v, distance[nx_v]));
					}
				}
			}
			lv++;//하나의 레벨 
			if(lv > k) { //환승 횟수 넘어가면 
				break;
			}
		}
		
		if(distance[e] != Integer.MAX_VALUE) return distance[e];
		return -1;
	}
	//main
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
		System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
		System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
		System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
	}
}