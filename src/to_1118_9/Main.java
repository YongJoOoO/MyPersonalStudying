package to_1118_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1753번. 최단 경로 - 다익스트라 문풀 
 * @author MYLG
 *
 */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge( int e, int val){
		this.e =e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int V, E, K;
	static int[] distance;
	static ArrayList<ArrayList<Edge>> graph;
	
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		V = kb.nextInt();
		E = kb.nextInt();
		K = kb.nextInt();
		
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력받기 
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int v = kb.nextInt();
			//방향 그래프임
			graph.get(a).add(new Edge(b, v));
		}
		
		//다익스트라 시작 
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		//1) 시작점 처리 
		distance[K] = 0;
		pQ.offer(new Edge(K, 0));
		
		//2) 혅재 정점 poll 시켜서 방문 처리 후 nx 정점 찾아서 최단경로 갱신 
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(cur.val > distance[cur.e]) continue;
			
			for(Edge nx : graph.get(cur.e)) {
				if(distance[nx.e] > distance[cur.e]+ nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
		//3) 정답 출력 
		for(int i=1; i<=V; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}	
	}
}