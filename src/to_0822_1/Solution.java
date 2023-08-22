package to_0822_1;
import java.util.*;
//최소 비행료 = LV 탐색 ㄴ
class Solution {
	
	static int[] distance;//거리 배열 
	static Queue<int[]> Q;
	static ArrayList<ArrayList<int[]>> graph;
	//solution 함수 
	public int solution(int n, int[][] flights, int s, int e, int k){
		
		distance = new int[n];
		//무한대로 일단 초기화 
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		graph = new ArrayList<>();
		for(int i=0; i<n; i++) {//각 정점에 대한 공간 생성
			graph.add(new ArrayList<>());
		}
		//데이터 그래프에 담기 
		for(int[] x : flights) {
			//x[0] -> x[1] 로 가는 가중치 : x[2] 
			graph.get(x[0]).add(new int[] {x[1], x[2]});
		}
		//여기서 생성해야 여러 케이스 혼선 X
		 Q = new LinkedList<>();
		//출발점 세팅 
		distance[s] = 0;//자기 자신에 대한 거리는 0 으로 세팅 
		Q.add(new int[] {s, 0});//<s->s로 향하는 가중치 0> <0,0>으로 시작합니다.
		
		int lv= 0;//첫레벨 세팅합니다.
		
		while(!Q.isEmpty()) {
			int len = Q.size();//각 레벨별로 존재하는 인접 정점들을 사이즈로 흝고 갈 거임 - 레벨=환승
			for(int i=0; i<len; i++) {
				int[] cur = Q.poll();
				int c_v	 = cur[0];//목적지
				int c_val = cur[1];//가중치 
				
				for(int[] nx : graph.get(c_v)) { //현재 c_v정점의 인접 정점들 순회 
					int nx_v = nx[0];
					int nx_val = nx[1];
					if(distance[nx_v] > c_val + nx_val) {
						//갱신
						distance[nx_v] = c_val + nx_val;
						Q.add(new int[] {nx_v, distance[nx_v]});
					}
				}
			}
			lv++;
			if(lv > k) break;//탈출
		}
		
		if(distance[e] == Integer.MAX_VALUE) return -1;//경로 없다는 거니

		return distance[e];
	}
	//main 함수 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
		System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
		System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
		System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
	}
}