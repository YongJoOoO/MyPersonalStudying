package to_0821_2;
//최소비행기 비용 - 다익스트라 
import java.util.*;

class Solution {
	
	static int[] distance;
	static ArrayList<ArrayList<int[]>> graph;
	static Queue<int[]> Q;
	
	public int solution(int n, int[][] flights, int s, int e, int k){
		
		distance = new int[n];//0부터 n-1번까지만 
		Arrays.fill(distance, 1000000000); //최초값은 무한대로 크게 초기화 
		
		graph = new ArrayList<>();
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<>()	);//각 정점에 대한 공간 생성 
		}
		//데이터 삽입
		for(int[] x : flights){
			graph.get(x[0]).add(new int[]{x[1], x[2]});
		}

		Q= new LinkedList<>();		
		//시작점 초기화
		distance[s]=0;//자기 자신에 대한 거리는 0
		Q.add(new int[] {s, 0});
		
		int L = 0;
		
		while(!Q.isEmpty()){
			int len = Q.size();
			for(int i = 0; i < len; i++){
				int[] cur = Q.poll();
				int c_v= cur[0];
				int c_val = cur[1];
				for(int[] x : graph.get(c_v)){
					int nx_v = x[0];
					int nx_val = x[1];
					if(distance[nx_v] > c_val + nx_val) {
						distance[nx_v] = c_val + nx_val;
						Q.add(new int[] {nx_v, distance[nx_v]});
					}
				}
			}
			L++;
			if(L > k) break; 
		}
		
		if(distance[e] == 1000000000) return -1;//아예 갈 방법도 없으면 -1처리 

		return distance[e];
	}
		
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
		System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
		System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
		System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
	}
}