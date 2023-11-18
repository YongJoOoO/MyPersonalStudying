package to_1118_A;

import java.util.*;
import java.util.Scanner;

/**
 * 11724번. 연결 요소의 개수 - DFS 문뤂 - 무방향 그래프
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	//DFS
	static void DFS(int cur) {
	
		for(int nx : graph.get(cur)) {
			if(!visited[nx]) {
				visited[nx] = true;
				DFS(nx);
			}
		}
	}
	
	//실행메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			//양방향 그래프이므로 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		//호출하기 
		int answer = 0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(i);
				answer++;
			}
		}
		System.out.println(answer);
	}
}