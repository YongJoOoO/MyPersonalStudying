package to_1118_B;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  * 11724번. 연결 요소의 개수 - BFS 문뤂 - 무방향 그래프
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	//BFS
	static void BFS(int v) {
		Queue<Integer> Q = new LinkedList<>();
		visited[v] = true;
		Q.offer(v);
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int nx : graph.get(cur)) {
				if(!visited[nx]) {
					visited[nx]= true;
					Q.offer(nx);
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
		
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//무방향
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		//호출
		int answer= 0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				BFS(i);
				answer++;
			}
		}
		System.out.println(answer);
	}

}
