package back_0323;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 백준. 2606번. 바이러스 
 * */
public class Main {
	static int ch[];
	static ArrayList<ArrayList<Integer>> graph;
	static int n, e, answer = 0;
	//DFS()
	public void DFS(int v) {
		ch[v] = 1;
		for(int nv: graph.get(v)) {
			if(ch[nv]==0) {
				answer++; //여기서 ++ 인접 정점들 카운팅해야 바이러스 감염될 애들이니까.
				ch[nv] = 1;
				DFS(nv);
			}
		}
	}
	//BFS()
	public void BFS(int v) {
		Queue <Integer> Q = new LinkedList<>();
		ch[v] = 1;
		Q.offer(v);
		while(!Q.isEmpty()) {
			int cv = Q.poll();
			for(int nv: graph.get(cv)) {
				if(ch[nv] == 0) {
					answer++;
					ch[nv]=1;
					Q.offer(nv);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); //컴퓨터 수
		e = kb.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		ch = new int[n+1];
		
		//그래프 공간 생성
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		//입력받기
		for(int i=0; i<e; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향 그래픈
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		//T.DFS(1);//정점1과의 인접 정점들 카운팅 
		T.BFS(1);
		System.out.println(answer);
	}
}