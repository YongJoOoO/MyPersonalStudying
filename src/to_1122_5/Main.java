package to_1122_5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 11724번. 연결 요소의 개수 - DFS
 *
 */
public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	
	//DFS
	static void DFS(int val) {
		visited[val] = true;
		
		for(int x : graph.get(val)) {
			if(!visited[x]) {
				DFS(x);
			}
		}
		
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N  = kb.nextInt();
		M = kb.nextInt();
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++ ) graph.add(new ArrayList<>());
		visited = new boolean[N+1];
		
		//데이터 입력
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				DFS(i);
				answer++;
			}
		}
		System.out.println(answer);
	}

}
