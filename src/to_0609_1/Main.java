package to_0609_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*1260번. DFS. BFS 프로그램 */
public class Main {
	//정적 변수 
	static ArrayList<ArrayList<Integer>> graph;	
	static boolean visited[];
	static int n, m;
	
	//DFS 
	static void DFS(int v) {
		//이미 방문한 정점이면 그냥 리턴 복귀
		if(visited[v]) return;
		
		//아니면 v 방문 처리 
		visited[v] = true;
		System.out.print(v+" ");
		//v에 대한 인접정점 꺼내서 DFS 깊이 탐색 
		for(int x : graph.get(v)) {
			if(!visited[x]) {
				DFS(x);
			}
		}
	}
	//BFS 
	static void BFS(int v ) {
		Queue<Integer> Q = new LinkedList<>();
	
		Q.offer(v);//현재 정점 v를 큐에 담기 
		visited[v] = true; //방문 처리 
		
		//모두 탐색해야 하므로 while()
		while(!Q.isEmpty()) {
			int cur = Q.poll();//현재 정점 뽑고
			System.out.print(cur+ " ");
			for(int nv : graph.get(cur)) {
				if(!visited[nv]) {
					Q.offer(nv);
					visited[nv] = true;
				}
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		n= kb.nextInt();
		m =kb.nextInt();
		
		int s = kb.nextInt();//시작 정점 
		
		//공간 생성 
		graph = new ArrayList<ArrayList<Integer>>();
		//방문 체크
		visited = new boolean[n+1];
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		//간선 개수만큼 정보 입력받음 
		for(int i=0; i<m ; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향 정보 담기 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		//단, 방문 가능한 정점 여러개 인 경우 정렬 
		for(int i=0; i<=n; i++) {
			Collections.sort(graph.get(i));//각각 연결 정점들 정렬
		}
		
		//시작 정점에 대한 호출 
		DFS(s);
		System.out.println();//공백 
		visited =new boolean[n+1];//다시 초기화
		BFS(s);
		
	}

}
