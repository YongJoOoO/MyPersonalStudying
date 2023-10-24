package to_1024_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 11724번. 연결 요소의 개수 
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	//DFS
	static void DFS(int st) {
		if(visited[st]) return;//이미 방문한 정점인 경우 
		visited[st] = true;
		
		for(int nx: graph.get(st)) {
			if(!visited[nx]) {
				DFS(nx);//더 깊이 탐색함
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
		
		//입력받기
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		//DFS 방문
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				DFS(i);
				cnt++;//복귀할 때마다 하나씩 증간
			}
		}
		
		System.out.println(cnt);
		
	}

}
