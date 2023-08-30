package to_0830_7;

import java.util.*;
import java.util.Scanner;
// 백준 파티 문제 풀이 
public class Main {
	static int N, M, X;
	static int[] distance;
	static int[] redistance;
	static ArrayList<ArrayList<int[]>> graph;
	static ArrayList<ArrayList<int[]>> reverse;
	static PriorityQueue<int[]> pQ;
	
	//다익스트라 - 시작점은 항상 X 
	static int[] dijkstra(ArrayList<ArrayList<int[]>> A) {
		boolean[] visited = new boolean[N+1];
	
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		//가중치값 적은 거 우선으로 -최단거리니까 
		pQ = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
		//시작점 처리 
		dist[X] = 0;//자기 자신 		
		pQ.offer(new int[] {X, 0}); ///X로 가는 값은 0 이다.
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			int cur_e = cur[0];
			int cur_val = cur[1];
			
			if(!visited[cur_e]) {
				visited[cur_e] = true;
				for(int[] nx : A.get(cur_e)) {
					int nx_e = nx[0];
					int nx_val = nx[1];
					//직전 정점 경유하는 값과 기존 경로 중 더 작은 값 발견한 거로 세팅 
					if(!visited[nx_e] && dist[nx_e] > dist[cur_e] + cur_val) {
						dist[nx_e] = dist[cur_e] + cur_val;
						visited[nx_e] = true;
						pQ.offer(new int[] {nx_e, dist[nx_e]});//갱신한 길이로 담아주기 
					}
				}
			}
		}
		return dist;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		X = kb.nextInt();//시작점 
		
		distance = new int[N+1];
		redistance = new int[N+1];
		graph = new ArrayList<>();
		reverse = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
			reverse.add(new ArrayList<>());
		}
		
		//데이터 입력받기 
		for(int i=0; i<8; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			//정방향 
			graph.get(a).add(new int[] {b, val});
			//역방향 
			reverse.get(b).add(new int[] {a, val} );
		}
		
		//다익스트라 두 번 호출
		distance = dijkstra(graph);
		redistance = dijkstra(reverse);
		
		for(int i=1; i<=N; i++) {
			System.out.println(distance[i] + " " + redistance[i]);
		}
	}
}