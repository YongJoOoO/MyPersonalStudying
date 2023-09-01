package to_0901_5;

import java.util.*;
import java.util.Scanner;

/*백준 14284번. 간선 이어가기 2 - 다익스트라 문풀 */
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
	static int N, M, S, T;
	static int[] distance;
	static ArrayList<ArrayList<Edge> > graph;
	static boolean[]visited;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		distance= new int[N+1];
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			//양방향 
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}
		//S , T 입력 
		S = kb.nextInt(); //시작점 
		T = kb.nextInt();// 종료지점 
		
		//다익스트라 시작 
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Edge> pQ= new PriorityQueue<>();
		
		//시작점 처리 
		distance[S] = 0;
		pQ.offer(new Edge(S, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) {
				if(!visited[nx.e] && distance[nx.e] > distance[cur.e] + nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
		System.out.println(distance[T]);
	}
}