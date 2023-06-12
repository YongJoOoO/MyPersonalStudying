package to_0612_6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*촌수 계산 BFS 풀이 */
public class Main {
	static int n; //노드
	static int st, ed;
	static int e; //엣지
	//graph
	static ArrayList<ArrayList<Integer>> graph;
	static boolean visited[];
	static int answer=1;
	//BFS
	static void BFS(int n) {

		Queue<Integer> Q = new LinkedList<>();
		//방문 처리 
		visited[n] = true;
		Q.add(n);
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			
			if(cur == ed) {//끝점 발견ㄴ
				return;
			}
			
			for(int nx : graph.get(n)) { //인접 정점들 
				if(!visited[nx]) {	
					Q.add(nx);
					visited[nx] = true;//방문 처리도 해야 함 
				}
			}
			//여기서 촌수 늘려줌 
			answer++;
		}

	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		st = kb.nextInt();
		ed = kb.nextInt();
		e = kb.nextInt();
		
		graph = new ArrayList<>();
		visited = new boolean[n+1];

		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<e; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		BFS(st);
		if(answer == 0) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
	}
}