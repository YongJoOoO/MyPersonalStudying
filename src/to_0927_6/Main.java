package to_0927_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
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
	static int T;
	static int n, m, t;//정점, 간선, 목적지 개수 t개
	static int s, g, h;//시작점, 경유지 g-h 
	
	static int[] distance;//거리 배열 
	static ArrayList<ArrayList<Edge>> graph;
	static boolean[] visited;
	
	//다익스트라 
	static boolean dijkstra(int ed) {
		boolean flag = false;//가는 경로 중 g, h거쳤는지 확인용 
		visited = new boolean[n+1];
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		distance=  new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[s] = 0;
		pQ.offer(new Edge(s, 0));
		
		//목적지에 따라 
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			//목적지 발견 시 탈출
			if(cur.e == ed) break;//여기서 탈출 
			
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) {
				if(distance[nx.e] > distance[cur.e] + nx.val) {
					
					//경유지에서 g-h 도로를 거쳐간 경우 
					if(cur.e == h && nx.e == g || cur.e == g && nx.e == h) {
						flag = true;
					}
					distance[nx.e] = distance[cur.e] + nx.val;
				}
			}
		}
		return true;
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		T = kb.nextInt();//테스트 케이스 별
	
		
		for(int a=0; a<T; a++) {
			n = kb.nextInt();
			m = kb.nextInt();
			t = kb.nextInt();//목적지 개수 
			
			s = kb.nextInt();//시작점
			g = kb.nextInt();//경유지 g-h
			h = kb.nextInt();
			
			graph = new ArrayList<>();
			for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
			
			//데이터 입력받기 
			for(int i=0; i<m; i++) {
				int x = kb.nextInt();
				int y = kb.nextInt();
				int val = kb.nextInt();
				//양방향 간선 
				graph.get(x).add(new Edge(y, val));
				graph.get(y).add(new Edge(x, val));
			}
			
			
			//목적지 t개 입력받기 
			int[] tmp = new int[t];
			boolean[] v = new boolean[t];
			for(int i=0; i<t; i++) {
				tmp[i]= kb.nextInt();
				v[i] = dijkstra(tmp[i]);//각각의 목적지 별로 true 인지 false인지 값 담기 
			}
			
			for(int i=1; i<=n; i++) {
				System.out.print(distance[i]+" ");
			}
		

			
		}

	}

}
