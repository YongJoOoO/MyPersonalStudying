package to_24_0117_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 5719번. 거의 최단 경로 - 다익스트라 문풀 
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
	static int N, M, S, D;
	static int[] distance;
	static boolean[][] exRoute;
	static List<Integer>[] removeList;
	static ArrayList<ArrayList<Edge>> graph;
	
	//dijkstra
	static int dijkstra(int s, int e) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		//시작점
		distance[s] = 0;
		pQ.offer(new Edge(s, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(cur.val > distance[cur.e]) continue;
			
			for(Edge nx : graph.get(cur.e)) {
				if(exRoute[cur.e][nx.e]) continue;
				
				if(distance[nx.e] > distance[cur.e] + nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					removeList[nx.e] = new ArrayList<>();
					removeList[nx.e].add(cur.e);
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}else if(distance[nx.e] == distance[cur.e] + nx.val) {
					removeList[nx.e].add(cur.e);
				}
			}
		}
		return distance[e];
	}
	
	static void backTrackingDelete(int s, int d) {
		if(s==d) return;
		for(int nxt : removeList[d]) {
			//d에 연결된 값 
			if(!exRoute[nxt][d]) {
				exRoute[nxt][d] = true;
				backTrackingDelete(s, nxt);
			}
		}
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		while(true) {
			N = kb.nextInt();
			M = kb.nextInt();
			if(N == 0 && M == 0 ) break;
			
			S = kb.nextInt();
			D = kb.nextInt();
			
			removeList = new ArrayList[N]; //직전 정점 담기 
			for(int i=0; i<N; i++) {
				removeList[i] = new ArrayList<>();
			}
			distance = new int[N];
			graph = new ArrayList<>();
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<>());
			}
			
			//데이터 입력 
			for(int i=0; i<M; i++) {
				int a  =kb.nextInt();
				int b = kb.nextInt();
				//방향 그래프
				int val = kb.nextInt();
				graph.get(a).add(new Edge(b, val));
			}			
			exRoute = new boolean[N][N];
			//다익스트라 
			dijkstra(S, D);
			//백트래킹 - delete 
			backTrackingDelete(S, D);
			dijkstra(S, D);
			
			if(distance[D] == Integer.MAX_VALUE) {
				System.out.println("-1");
			}else System.out.println(distance[D]);
			
		}	
	}
}