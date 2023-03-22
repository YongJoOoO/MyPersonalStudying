package back_0322_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 24479번. 깊이 우선 탐색 1
 * */
public class Main {
	static int n, m, r;
	static int answer=1; //방문순서 카운팅
	static ArrayList<ArrayList<Integer>> graph;
	static int ch[]; //방문 배열 
	static int order[]; //방문 순서 배열
	//방문순서 체크 할 DFS
	public void DFS(int v) {
		ch[v] = 1;
		order[v] = answer++; //방문순서 담기 

		for(int nv: graph.get(v)) {
			if(ch[nv] == 0) {
				ch[nv] = 1;
				DFS(nv);
			}
		}
	}
	
	//실행 메인 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		r = kb.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		//각 객체 생성
		for(int i = 0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		//방문여부 체크 배열 
		ch = new int[n+1];
		order = new int[n+1];
		//입력받기
		for(int i= 0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//무방향이므로 양쪽 대칭되게 값 세팅 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		//정렬 시키고
		for(int i=0; i<=n; i++) {
			Collections.sort(graph.get(i));
		}
		//호출
		T.DFS(r);
		
		//출력
		for(int i=1; i<=n; i++) {
			System.out.println(order[i]);
		}
	}

}