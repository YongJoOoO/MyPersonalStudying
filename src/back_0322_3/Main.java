package back_0322_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 24444번. 너비 우선 탐색 1
 * */
public class Main {
	static int n, m, r;
	static ArrayList<ArrayList<Integer>> graph;
	static int ch[];//체크용 배열 
	static int order[];//순서용 배열 
	static int count = 1; //카운팅용
	
	//BFS()
	public void BFS(int v) {
		Queue<Integer> Q = new LinkedList<>();
		ch[v] = 1;
		Q.offer(v);//큐에 담기
		//카운팅
		order[v] = count++; //여기서 세팅
		
		while(!Q.isEmpty()) {
			int cv = Q.poll();
			
			for(int nv : graph.get(cv)) {
				if(ch[nv] == 0) {
					ch[nv] = 1;
					Q.offer(nv);
					order[nv] = count++;  //여기서도 다시 세팅
				}
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
		ch = new int[n+1];
		order = new int[n+1];
		//공간 객체 생성 
		for(int i =0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		//입력받기
		for(int i=0; i<m ; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		//오름차순 정렬
		for(int i=0; i<=n; i++) {
			Collections.sort(graph.get(i));
		}
		//BFS호출
		T.BFS(r);
		
		//출력
		for(int i=1; i<=n; i++) {
			System.out.println(order[i]);
		}
	}
}