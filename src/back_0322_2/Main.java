package back_0322_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 24480번. 깊이 우선 탐색 2
 * */ 
public class Main {
	static int n, m, r;
	static ArrayList<ArrayList<Integer>> graph;
	static int ch[];
	static int order[];
	static int count = 1;
	//BFS()
	public void DFS(int v) {
		ch[v] = 1;
		order[v] = count++;//순서 담기 
		
		for(int nv : graph.get(v)) {
			if(ch[nv]==0) {
				ch[nv] =1;
				DFS(nv);
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb =new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		r = kb.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		//그래프 내부 공간 생성 
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		ch = new int[n+1];
		order = new int[n+1];
		
		//입력받기
		for(int i =0; i<m; i++) {
			int a =kb.nextInt();
			int b = kb.nextInt();
			//무방향이므로 양쪽에 대칭되게 담기
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		//내림차순 정렬할 것 
		for(int i=0; i<=n; i++) {
			//내림차순 정렬
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		
		//DFS 호출
		T.DFS(r);
		
		//출력
		for(int i=1; i<=n; i++) {
			System.out.println(order[i]);
		}
	}
}