package to_1102_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*23801번. 두 단계 최단 경로 2 - 다익스트라 문풀 */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val) {
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
	static int N, M;
	static int X, Z;//시작, 끝
	static int P;
	static int[] mid;//경유지
	static ArrayList<ArrayList<Edge>> graph;
	static int[] distance;//배열 
	//다익스트라 
	static int dijkstra(int s, int e) {
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		//1) 시작점 처리 
		distance[s] = 0;
		pQ.offer(new Edge(s, 0));
		
		//2) 더 작은 정점 발견 시 세팅 
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(cur.e == e) break;//탈출 
		
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
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			int val = kb.nextInt();
			graph.get(s).add(new Edge(e, val));
			graph.get(e).add(new Edge(s, val));
		}
		
		X = kb.nextInt();
		Z = kb.nextInt();
		
		P = kb.nextInt();
		mid = new int[P];
		for(int i=0; i<P; i++) mid[i]= kb.nextInt();
		
		//1) s->mid 차례로 돌고 그 중 가장 최소값 갖는ㅇ ㅐㄱ ㅣ준으로 e점 가면 될듯 
		
		int sum = Integer.MAX_VALUE;
		
		for(int i=0; i<P; i++) {
			int len1 = dijkstra(X, mid[i]);
			int len2 = dijkstra(mid[i], Z);
			
			sum = Math.min(sum, len1+len2); //가장 짧은 최단 경로가 나올 거임 
		}		
		System.out.println(sum);	
	}
}