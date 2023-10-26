package to_1026_1;

import java.util.*;
import java.util.Scanner;

/**
 * 2606번. 바이러스 - DFS, BFS 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	static int answer = 0;
	//DFS
	static void DFS(int st) {
		if(visited[st]) { //이미 방문한 곳이면 
			return;//백
		}
		visited[st]= true;
		
		for(int nx : graph.get(st)) {
			if(!visited[nx]) {
				answer++;
				DFS(nx);
			}
		}
	}
	
	
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		visited= new boolean[N+1];
		
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//간선 입력받기
		for(int i=0; i<M; i++) {
			int a= kb.nextInt();
			int b = kb.nextInt();
			//양방향 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		DFS(1);
		
		System.out.println(answer);
		
	}
}