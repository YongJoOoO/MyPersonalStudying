package to_0831_1;

import java.util.*;
import java.util.PriorityQueue;
import java.util.Scanner;

/*1238번. 파티 - 다익스트라 문풀 */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e =e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int N, M, X;
	static int[] dist1;//가는 길
	static int[] dist2;//돌아오는 길 
	static ArrayList<ArrayList<Edge>> A;//정방향 
	static ArrayList<ArrayList<Edge>> B;//역방향 
	
	//다익스트라 함수 
	static int[] dijkstra(ArrayList<ArrayList<Edge>> graph) {
		int[] dist = new int[N+1];	
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		//다익스트라는 무한대 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		//시작점 초기화
		dist[X] = 0;
		pQ.offer(new Edge(X, 0));//X로 향하는 길이 0
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			int cur_e = cur.e;
			int cur_val= cur.val;
			
			for(Edge nx : graph.get(cur_e)) {
				if(dist[nx.e] > dist[cur_e] + nx.val) {
					dist[nx.e] = dist[cur_e] + nx.val;
					pQ.offer(new Edge(nx.e, dist[nx.e]));
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
		X = kb.nextInt();
		
		A = new ArrayList<>();
		B = new ArrayList<>();
		
		//공간 생성 
		for(int i=0; i<=N; i++) {
			A.add(new ArrayList<>());
			B.add(new ArrayList<>());
		}
		
		//데이터 입력 받기 
		for(int i=0; i<M; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			int val =kb.nextInt();
			//정방 역방 
			A.get(s).add(new Edge(e, val));
			B.get(e).add(new Edge(s, val));
		}
		
		dist1 = dijkstra(A);
		dist2 = dijkstra(B);
		
		int max = -1;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, dist1[i]+dist2[i]);
		}
		
		System.out.println(max);
	}
}