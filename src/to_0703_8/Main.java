package to_0703_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*1504번. 특정한 최단 경로 */
class Edge implements Comparable<Edge>{
	int v; 
	int val;
	Edge(int v, int val){
		this.v = v;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int N, M;
	static final int INF = 200000000;
	static int distance[];
	static boolean visited[];
	static ArrayList<ArrayList<Edge>> graph;
	
	//다익스트라 함수 
	static int dijkstra(int st, int ed) {
		
		Arrays.fill(distance, INF);
		Arrays.fill(visited, false);//방문여부 초기화 시켜줘야 한다.
		
		PriorityQueue<Edge> pQ= new PriorityQueue<>();
		//시작점 초기화
		distance[st] = 0;
		pQ.add(new Edge(st, 0));
		
		while(!pQ.isEmpty()) {
			//현재
			Edge cur = pQ.poll();
			int c_v = cur.v;
			int c_val = cur.val;
			if(!visited[c_v]) {
				visited[c_v] = true;
				for(Edge nx : graph.get(c_v)) {
					int nx_v = nx.v;
					int nx_val= nx.val;
					if(!visited[nx_v] && distance[nx_v] > distance[c_v]+ nx_val) {
						distance[nx_v]=distance[c_v]+nx_val;
						pQ.add(new Edge(nx_v, distance[nx_v]));
					}
				}
			}
		}
		
		return distance[ed];//끝지점의 최단 경로 리턴 
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb=  new Scanner(System.in);
		
		N =kb.nextInt();
		M = kb.nextInt();
		distance  = new int[N+1];
		visited= new boolean[N+1];
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Edge>());
		}
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int w = kb.nextInt();
			//방향 없으므로 양방향  주기 
			graph.get(a).add(new Edge(b,w));
			graph.get(b).add(new Edge(a, w));
		}
		
		int v1 = kb.nextInt();//꼭 지나칠 1
		int v2 = kb.nextInt();//꼭 지나칠 2 
	
		int route1  = 0;
		route1 += dijkstra(1, v1);
		route1 += dijkstra(v1, v2);
		route1 += dijkstra(v2, N);
		
		int route2 = 0;
		route2 += dijkstra(1, v2);
		route2 += dijkstra(v2, v1);
		route2 += dijkstra(v1, N);
		
		int answer = 0;
		if(route1 > INF && route2 > INF ) answer = -1;
		else {
			answer = Math.min(route1, route2);
		}
		
		System.out.println(answer);
		
	}
}