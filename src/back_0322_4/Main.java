package back_0322_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 24445번. 너비 우선 탐색2 */
public class Main {
	static int n, m, r;
	static ArrayList<ArrayList<Integer>> graph;
	static int ch[];//방문 배열에 카운팅 함께 해주자
	//BFS
	public void BFS(int v) {
		Queue<Integer> Q = new LinkedList<>();
		int cnt = 1;
		ch[v] = cnt++;
		Q.offer(v);
		
		while(!Q.isEmpty()) {
			int cv = Q.poll();
			for(int nv : graph.get(cv)) {
				if(ch[nv] == 0) {
					ch[nv] = cnt++;
					Q.offer(nv);
				}
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
		ch = new int[n+1];
		//공간 생성
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		//입력받기
		for(int i=0 ;i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		//내림차순 정렬
		for(int i=0; i<=n; i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		//BFS 호출
		T.BFS(r);	
		//출력
		for(int i=1; i<=n; i++) {
			System.out.println(ch[i]);
		}
	}
}