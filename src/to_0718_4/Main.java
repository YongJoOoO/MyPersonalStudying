package to_0718_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*1260번. DFS, BFS */
public class Main {
	static int N, M, st;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	//dfs
	static void dfs(int v) {
		if(!visited[v]) {
			System.out.print(v + " ");//
		}
		visited[v] = true;
		for(int nx : graph.get(v)) {
			if(!visited[nx]) { //방문 안한 인접 정점에 대하여 
				dfs(nx);//더 깊이 탐색할 건데 
			}
		}
	}
	//bfs
	static void bfs(int v) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(v);
		visited[v] = true;
	
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			System.out.print(cur + " "); //여기서 출력시킴 
			for(int nx : graph.get(cur)) {
				if(!visited[nx]) {
					Q.add(nx);
					visited[nx] = true;//방문 처리 
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
		st = kb.nextInt();
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			int a =kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		//번호 작은 거 우선으로 방문하기 위해 각각 정점에 대한 정렬 
		for(int i=0; i<=N; i++) {
			Collections.sort(graph.get(i)); //각 정점 i에 연결된 정점들 오름차순 정렬 
		}
		
		visited = new boolean[N+1];
		dfs(st);
		System.out.println();
		//visited 갱신 
		visited = new boolean[N+1];
		bfs(st);
	}
}