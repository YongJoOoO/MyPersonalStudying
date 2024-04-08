package to_24_0408_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static List<List<Integer>> graph ;
	static boolean[] visited;
	//DFS
	static void DFS(int s) {
		System.out.print(s + " ");
		visited[s] = true;
		for(int nx : graph.get(s)) {
			if(!visited[nx]) {
				visited[nx] = true;
				DFS(nx);
			}
		}
	}
	//BFS
	static void BFS(int s) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(s);
		visited[s] = true;
		System.out.print(s + " ");
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int nx : graph.get(cur)) {
				if(!visited[nx]) {
					visited[nx] = true;
					System.out.print(nx+ " ");
					Q.offer(nx);
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		int S = kb.nextInt();
		
		visited= new boolean[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int i=1; i<=N; i++) Collections.sort(graph.get(i));

		DFS(S);
		
		System.out.println();
		visited=  new boolean[N+1];
		
		BFS(S);
	}
}