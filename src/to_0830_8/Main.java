package to_0830_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*백준 - 다익스트라 (파티) 문풀 RE */
class Edge implements Comparable<Edge>{
	int e;
	int val;
	Edge(int e, int val){
		this.e = e;
		this.val =val;
	}
	public int compareTo(Edge o) {
		return this.val - o.val;//가중치 적은 거 우선 
	};
}
public class Main {
	static int N, M, X;
	
	static ArrayList<ArrayList<Edge >> graph;
	static ArrayList<ArrayList<Edge>> reverse;
	//다익스트라
	static int[] dijkstra(ArrayList<ArrayList<Edge>> A) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		int[] dist = new int[N+1];
		 boolean[] visited = new boolean[N + 1];
		//무한대로 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		//시작정점 처리 
		dist[X]= 0;
		pQ.offer(new Edge(X, 0));//담기 
		
		while(!pQ.isEmpty()) {
			//현재 뽑은 애만 방문처리 
			Edge cur = pQ.poll();
			int cur_e = cur.e;
			if(!visited[cur_e]) {
				visited[cur_e] = true;
				
				for(Edge nx : A.get(cur_e)) {
					if(!visited[nx.e] && dist[nx.e] > dist[cur_e] + nx.val) {
						dist[nx.e] = dist[cur_e] + nx.val;
						pQ.offer(new Edge(nx.e, dist[nx.e]));
					}
				}
			}
		}
		return dist;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		X = kb.nextInt();//출발점 고정 
	
		
		graph = new ArrayList<>();
		reverse = new ArrayList<>();
		
		for(int i=0;i <=N; i++) {
			graph.add(new ArrayList<>());
			reverse.add(new ArrayList<>());
		}
		
		//데이터 입력하기 
		for(int i=0; i<8; i++) {
			int a=  kb.nextInt();
			int b= kb.nextInt();
			int c= kb.nextInt();
			//정방향 
			graph.get(a).add(new Edge(b, c));
			//역방향
			reverse.get(b).add(new Edge(a, c));
		}
		
		int[] distance = dijkstra(graph);
		int[] redistance = dijkstra(reverse);
		
		int max = -1;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, distance[i] + redistance[i]);
		}
		System.out.println(max);
	}
}