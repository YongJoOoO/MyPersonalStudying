package back_0322;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 1260번. DFS와 BFS 
 * */
public class Main {
	static int n, m;
	static ArrayList<ArrayList<Integer>> graph;
	static int ch[];
	//DFS()
	public void DFS(int v) {
		//현재 방문 정점 v에 대한 처리 
		ch[v] = 1;
		System.out.print(v+" ");
		//현재의 v에 연결된 정점들 순회하며 방문
		for(int nv: graph.get(v)) {
			if(ch[nv] == 0) {
				ch[nv]=1;
				DFS(nv); //재귀 호출하여 깊이 탐색
			}
		}
	}
	//BFS()
	public void BFS(int v) {
		Queue<Integer> Q = new LinkedList<>();
		//큐에 담고, 방문처리
		
		Q.offer(v);
		ch[v]=1;
		//순회하며 
		while(!Q.isEmpty()) {
			int value = Q.poll();
			System.out.print(value+ " ");
			
			for(int nv: graph.get(value)) {
				if(ch[nv] == 0) {
					ch[nv] = 1;
					Q.offer(nv);//큐에 담기
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
	
		n = kb.nextInt();
		m = kb.nextInt();
		int r = kb.nextInt(); //시작 정점
		graph = new ArrayList<ArrayList<Integer>>();
		
		//각 정점에 대한 연결정점 담을 객체 생성
		for(int i=0; i<=n;i++) {
			graph.add(new ArrayList<Integer>());
		}
		//체크용 배열 생성
		ch = new int[n+1];
		//입력받기
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향 담기
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		//단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
		for(int i=0; i<=n; i++) {
			Collections.sort(graph.get(i));
		}
		T.DFS(r);
		System.out.println();
		//ch배열 다시 초기화
		ch = new int[n+1];
		
		T.BFS(r);
	}
}