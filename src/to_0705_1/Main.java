package to_0705_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*1504번. 특정한 최단 경로 */
class Node implements Comparable<Node>{
	int v;
	int val;
	Node(int v, int val){
		this.v = v;
		this.val = val;
	}
	public int compareTo(Node o) {
		return this.val - o.val;//가중치 기준 오름차순 정렬
	};
}
public class Main {
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph;
	private static int INF = Integer.MAX_VALUE;

	
	//dijkstra
	static int dijkstra(int st, int ed) {
		Arrays.fill(distance, INF);
		Arrays.fill(visited, false);
		
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		
		//시작점 세팅
		distance[st] = 0;//0
		pQ.add(new Node(st, 0));
		
		while(!pQ.isEmpty()) {
			Node cur = pQ.poll();
			int c_v = cur.v;
			int c_val = cur.val;
			if(!visited[c_v]) {
				visited[c_v] = true;
				for(Node nx : graph.get(c_v)) {
					int nx_v = nx.v;
					int nx_val = nx.val;
					if(!visited[nx_v] && distance[nx_v] > distance[c_v]+ nx_val) {
						visited[nx_v] =true;
						distance[nx_v] = distance[c_v] + nx_val;//거리 업데이트  
						pQ.add(new Node(nx_v, distance[nx_v]));
					}
				}
			}
		}
		return distance[ed];
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int E = kb.nextInt();
		
		//초기화 
		distance = new int[N+1];
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) graph.add(new ArrayList<Node>());
		
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int w = kb.nextInt();
			graph.get(a).add(new Node(b, w));
			graph.get(b).add(new Node(a, w));
		}
		//꼭 지날 경로 두개 
		int v1 = kb.nextInt();
		int v2 = kb.nextInt();
		
		long route1 = 0;
		route1 += dijkstra(1, v1);
		route1 += dijkstra(v1, v2);
		route1 += dijkstra(v2, N);
		
		long route2 = 0;
		route2 += dijkstra(1, v2);
		route2 += dijkstra(v2, v1);
		route2 += dijkstra(v1, N);
		
		if(Math.min(route1, route2) >= INF) {
			System.out.println(-1);
		}else {
			System.out.println(Math.min(route1, route2));
		}	
	}
}