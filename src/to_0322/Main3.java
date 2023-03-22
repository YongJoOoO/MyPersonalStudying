package to_0322;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 7-14. 그래프 최단 거리 (BFS) */
class Main3 {
	static int n, m, answer =0 ;
	static ArrayList<ArrayList<Integer>> graph; 
	static int[] ch, dis;//방문 체크용, 거리측정용
	//BFS() 함수
	public void BFS(int v) {
		//큐 필요
		Queue<Integer> queue = new LinkedList<>();
		ch[v] = 1; //들어온 v에 대한 방문 체크
		dis[v]= 0; //등로은 v에 대한 거리 일단 0 세팅
		queue.offer(v);//큐에 담음
		
		while(!queue.isEmpty()) {
			//일단 큐 하나 뽑음 
			int cv = queue.poll();
			//이 cv에 연결된 정점 탐색
			for(int nv : graph.get(cv)) {
				if(ch[nv] == 0){
					ch[nv] =1;
					queue.offer(nv);
					dis[nv] = dis[cv]+1;//직전 cv의 거리+1
				}
			}
		}
	}	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		//그래프 내부에 각 정점에 대한 정보 담을 ArrayList 객체 생성
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		ch = new int[n+1];
		dis = new int[n+1];
		//각 정점a 대한 연결 b 정보 담음 
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
		}
		//호출 2~n까지 최단거리 출력
		T.BFS(1);
		for(int i=2; i<=n; i++) {
			System.out.println(i+" : "+dis[i]);
		}
	}	
}