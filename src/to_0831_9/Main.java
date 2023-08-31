package to_0831_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//다시 풀기
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
	static int V, E, P;
	static ArrayList<ArrayList<Edge>> graph;
	//다익스트라 
	static int dijkstra(int s, int e) {
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE); //최댓값 세팅 
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Edge> pQ =new PriorityQueue<>();
		
		//시작점 처리
		dist[s] = 0;
		pQ.offer(new Edge(s, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;
			visited[cur.e ] =true;
			
			for(Edge nx : graph.get(cur.e)) {
				if(!visited[nx.e] && dist[nx.e] > dist[cur.e] + nx.val) {
					dist[nx.e] = dist[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, dist[nx.e]));
				}
			}
		}
		return dist[e];//목적지까지의 최단거리 리턴
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		V = kb.nextInt();
		E = kb.nextInt();
		P = kb.nextInt();
		
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) graph.add(new ArrayList<>());
		
		//데이터 입력 받기 
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			//양방향 
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}
		//1) 1-> V 직진 하기 
		int len1 = dijkstra(1, V);
		
		//2) 1-> P -> V 거쳐가기 
		int len2 = dijkstra(1, P) + dijkstra(P, V);
		//최종 답 출력 
		if(len1 == len2) {
			System.out.println("SAVE HIM");
		}else {
			System.out.println("GOOD BYE");
		}
	}
}