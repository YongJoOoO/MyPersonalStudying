package to_0719_B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//
class Node implements Comparable<Node>{
	int v;
	int val;
	Node(int v, int val){
		this.v=v;
		this.val = val;
	}
	@Override
	public int compareTo(Node o) {
		return this.val - o.val;//작은 거 우선으로 우선순위 큐에서 정렬되게 
	}
}
public class Main {
	static int V, E;
	static boolean visited[];
	static int distance[];
	static ArrayList<ArrayList<Node>> graph;
	
	//다익스트라
	static int Dijkstra(int S, int E) {
		//시작점 처리 
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		distance[S] = 0;//시작 정점은 0세팅 
		pQ.add(new Node(S,0));//시작 정점은 0 세팅 
		while(!pQ.isEmpty()) {
			Node cur = pQ.poll();
			int cur_v = cur.v;
			int cur_val = cur.val;
			if(!visited[cur_v]) {
				visited[cur_v] = true;
				for(Node nx : graph.get(cur_v)) {
					int nx_v = nx.v;
					int nx_val = nx.val;
					if(distance[nx_v] > distance[cur_v]+nx_val) {
						distance[nx_v] = distance[cur_v] + nx_val;
						pQ.add(new Node(nx_v, distance[nx_v]));
					}
				}
			}
		}
		return distance[E];
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		V = kb.nextInt();
		E = kb.nextInt();
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		visited = new boolean[V+1];
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력 받기 
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			graph.get(a).add(new Node(b, val));
		}		
		int S = kb.nextInt();
		int E = kb.nextInt();
		System.out.println(Dijkstra(S, E));
	}	
}