package to_1122_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1504번. 특정한 최단 경로 -다익스트라 문풀 
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
		return this.val - o.val;//가중치 오름차순 
	}
}
public class Main {
	static int N, E;
	static int A, B;
	static int[] distance;
	static ArrayList<ArrayList<Edge>> graph;
	static PriorityQueue<Edge> pQ;
	//다익스트라
	static int dijkstra(int s, int e) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		pQ = new PriorityQueue<>();
		//시작점 초기화
		distance[s] = 0;
		pQ.offer(new Edge(s, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(cur.val > distance[cur.e]) continue;
			
			for(Edge nx : graph.get(cur.e)) {
				if(distance[nx.e] > distance[cur.e] + nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
		return distance[e];
		
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		E = kb.nextInt();
		
		distance= new int[N+1];
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력
		for(int i =0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			//양방향
			graph.get(a).add(new Edge(b, val));
			graph.get(b).add(new Edge(a, val));
		}
		
		A = kb.nextInt();
		B = kb.nextInt();
		
		//다익스트라 호출 
		long sum1 = 0;
		//1) 1-> A => B => N
		sum1 += dijkstra(1, A);
		sum1 += dijkstra(A, B);
		sum1 += dijkstra(B, N);
		
		long sum2 = 0;
		//2) 1 -> B -> A -> N
		sum2 += dijkstra(1, B);
		sum2 += dijkstra(B, A);
		sum2 += dijkstra(A, N);
		
		long answer = Math.min(sum1, sum2);
		
		if(answer >= Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
}