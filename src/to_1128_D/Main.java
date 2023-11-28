package to_1128_D;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1240번. 노드 사이의 거리 - DFS
 * @author MYLG
 *
 */
class Edge{
	int e, val;
	Edge(int e, int val){
		this.e = e;
		this.val =val;
	}
}

public class Main {
	static int N, M;
	static boolean[] visited;
	static int max;
	static ArrayList<ArrayList<Edge>> graph;
	
	//DFS
	static void DFS(int s, int e, int dist) {
		if(s == e) {
			max = dist;
			return;
		}else {
			for(Edge nx : graph.get(s)) {
				if(!visited[nx.e]) {
					visited[nx.e] = true;
					DFS(nx.e, e, dist + nx.val);
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력받기 
		for(int i=0; i<N-1; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int v = kb.nextInt();
			graph.get(a).add(new Edge(b,v));
			graph.get(b).add(new Edge(a, v));
		}
		
		for(int i=0; i<M; i++) {
			visited= new boolean[N+1];
			int s = kb.nextInt();
			int e = kb.nextInt();
			
			max = 0;
			visited[s] = true;
			DFS(s, e, 0);
			
			System.out.println(max);
		}
	}
}