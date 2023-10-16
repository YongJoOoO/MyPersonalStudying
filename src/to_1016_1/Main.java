package to_1016_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*1753번. 최단경로 - 다익스트라 문풀 */

class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e =e ;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//가중치 오름찬순 
	}
}
public class Main {
	static int V, E, K;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Edge>> graph;
	//다익스트라 함수 
	static void dijkstra() {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		//시작점 처리 
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		pQ.offer(new Edge(K, 0)); // 자기 자신으로 향하는 정점은 0 거리 
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) {
				//다음 정점에 대하여 
				if(distance[nx.e] > distance[cur.e]+ nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		V = kb.nextInt();
		E = kb.nextInt();
		K = kb.nextInt();//시작wja
		
		distance = new int[V+1];
		visited = new boolean[V+1];
		
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		//데이터 입력받기 - 방향 그래프임
		for(int i=0; i<E; i++) {
			int a =kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			graph.get(a).add(new Edge(b, val));
		}
		//호출
		dijkstra();
		
		for(int i=1; i<=V; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}	
	}
}