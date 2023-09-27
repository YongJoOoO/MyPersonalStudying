package to_0927_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*9370번. 미확인 도착지 */

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
	static boolean flag;
	
	//다익스트라 
	static int dijkstra(int st, int ed) {
		
		visited = new boolean[n+1];
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		distance=  new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[st] = 0;
		pQ.offer(new Edge(st, 0));
		
		//목적지에 따라 
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			//목적지 발견 시 탈출
			if(cur.e == ed) break;//여기서 탈출 
			
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) {
				if(distance[nx.e] > distance[cur.e] + nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
		
		return distance[ed];
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
			
			int[] tmp = new int[t];
			for(int i=0; i<t; i++) {
				tmp[i] = kb.nextInt();
			}
			
			//가능한 목적지를 여기에 담아서 자동 정렬 되도록 함 
			PriorityQueue<Integer> pQ = new PriorityQueue<>();
			//각 목적지별로 답을 담을 건데 
			for(int dx : tmp) {
				//1) s->g->h->ed
				int res1  = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, dx);
				//2) s->h->g -> ed
				int res2 = dijkstra(s, h)+dijkstra(h, g) + dijkstra(g, dx);
				
				//3) s -> ed 다이렉트 
				int res3 = dijkstra(s, dx);
				
				if(Math.min(res1, res2) == res3) {
					pQ.offer(dx);
				}
			}
			//정답 출력
			while(!pQ.isEmpty()) {
				System.out.print(pQ.poll()+" ");
			}
			System.out.println();
		}
	}
}