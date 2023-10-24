package to_1024_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1260번. DFS와 BFS 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int N, M, V;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	//DFS
	static void DFS(int st) {
		System.out.print(st+" ");
		
		visited[st] = true;
		
		for(int nx: graph.get(st)) {
			if(!visited[nx]) {
				DFS(nx);
			}
		}
		
	}
	//BFS
	static void BFS(int st) {
		Queue<Integer> Q=  new LinkedList<>();
		Q.offer(st);
		visited[st] = true;
		
		while(!Q.isEmpty()){
			int cur = Q.poll();
			System.out.print(cur+" ");
			for(int nx : graph.get(cur)) {
				if(!visited[nx]) {
					Q.offer(nx);
					visited[nx]=true;
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
		V = kb.nextInt();
		visited = new boolean[N+1];
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		//작은 정점 우선 방문해야 하므로 
		for(int i=1; i<=N; i++) Collections.sort(graph.get(i));
		
		DFS(V);
		visited = new boolean[N+1];
		
		System.out.println();
		
		BFS(V);
	}
}