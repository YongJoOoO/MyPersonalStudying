package to_24_0113_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1753번. 최단 경로 - 다익스트라 문풀 
 * @author MYLG
 *
 */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e = e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//작은 가중치 우선 정렬 
	}
}
public class Main {
	static int V, E, K;
	static int[] distance;
	static List<ArrayList<Edge>> graph;
	
	//dijkstra
	static void dijkstra(int st) { //얘 기준 다른 all 점에 대한 최단 경로 
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		//시작점 처리 
		distance[st]= 0;
		pQ.offer(new Edge(st, 0));//자기 자신에 대한 거리는 0
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			
			for(Edge nx : graph.get(cur.e)) {
				if(distance[nx.e] > distance[cur.e] + nx.val) { //다음 정점을 현재 cur 경유해서 세팅하는 게 더 최단 경로라면 
					//현재 정점 경유해서 더 작은 값 세팅 가능하다면 
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
		K = kb.nextInt();
		
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//방향 그래프이므로 
			int val = kb.nextInt();
			
			graph.get(a).add(new Edge(b, val));
		}
		dijkstra(K);
		
		for(int i=1; i<=V; i++) {
			if(distance[i] == Integer.MAX_VALUE) { //닿지 못한 경우 
				System.out.println("INF");
				continue;
			}
			System.out.println(distance[i]);
		}
	}
}