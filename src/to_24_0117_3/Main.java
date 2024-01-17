package to_24_0117_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1916번. 최소비용 구하기 - 다익스트라 문풀 
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
		return this.val - o.val;
	}
}
public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int[] distance;
	static ArrayList<ArrayList<Edge>> graph;
	//다익스트라 
	static void dijkstra(int s, int e) {
		Arrays.fill(distance, INF);
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		//시작점 초기화
		distance[s] = 0;
		pQ.offer(new Edge(s, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(distance[cur.e] < cur.val) continue;
			for(Edge nx : graph.get(cur.e)) {
				if(distance[nx.e] > distance[cur.e] + nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}

	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		distance = new int[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			graph.get(a).add(new Edge(b, val));
		}
		int S = kb.nextInt();
		int E = kb.nextInt();
		
		dijkstra(S, E);
		System.out.println(distance[E]);
	}
}