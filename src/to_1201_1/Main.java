package to_1201_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 15971번. 두 로봇 - 다익스트라 
 * @author MYLG
 *
 */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e = e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int N, A, B;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Edge>> graph;
	static PriorityQueue<Edge> pQ = new PriorityQueue<>();

	//dijkstra
	static int dijkstra(int s, int e) {
		int max = 0;
		
		distance = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		List<Integer> list = new ArrayList<>();
		distance[s] = 0;
		pQ.offer(new Edge(s, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) {
				if(!visited[nx.e] && distance[nx.e] > distance[cur.e] + nx.val) {
					max = Math.max(max, nx.val);
					
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));

					if(nx.e == e) break;//여기서 걸어줘야 함
					
				}
			}
		}
		
		return distance[e] - max;
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		A = kb.nextInt();
		B = kb.nextInt();
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력 
		for(int i=1; i<=N-1; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			//양방향 
			graph.get(a).add(new Edge(b, val));
			graph.get(b).add(new Edge(a, val));
		}
		
		int minDt = dijkstra(A, B);
		
		System.out.println(minDt);
	}
}