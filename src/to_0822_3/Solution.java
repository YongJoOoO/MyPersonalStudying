package to_0822_3;
import java.util.*;
//RE 다시 풀이 - 비행기 최소비용 
class Solution {
	static int[] distance;
	static ArrayList<ArrayList<int[]>> graph;
	static Queue<int[]> Q;
	
	//solution 함수 
	public int solution(int n, int[][] flights, int s, int e, int k){
		distance = new int[n];//정점개수
		graph = new ArrayList<>();
		Q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<>());//공간ㄱ생성 
		}
		//값 채워넣기 
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		//데이터 세팅 
		for(int[] x : flights) {
			graph.get(x[0]).add(new int[] {x[1], x[2] });
		}
		
		//시작점 세팅 
		distance[s] = 0;
		Q.add(new int[] {s, 0});
		
		int lv = 0;
		while(!Q.isEmpty()) {
			int len= Q.size();
			for(int i=0; i<len; i++) { //하나의 레벨 탐색하는 거임 그 인접 정점들 싹 방문하니까 
				int[] cur = Q.poll();
				int c_v = cur[0];
				int c_val = cur[1];
				for(int[] nx : graph.get(c_v)) {
					int nx_v = nx[0];
					int nx_val = nx[1];
					if(distance[nx_v] > c_val + nx_val) {
						distance[nx_v] = c_val + nx_val;
						Q.add(new int[] {nx_v, distance[nx_v]});
					}
				}
			}
			lv++;
			if(lv > k) break;
		}
		
		//break 걸어놓은 상태에서 e 도착점까지의 거리 출력하면 됨 
		if(distance[e] == Integer.MAX_VALUE) return -1;

		return distance[e];
	}
	//실행 메인 	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
		System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
		System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
		System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
	}
}