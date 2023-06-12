package to_0612_5;

import java.util.ArrayList;
import java.util.Scanner;

/*2644번. 촌수 계산하기 - DFS 풀이 */
public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int n;//노드 개수 
	static int e;//간선 개수 
	
	static int st, ed = -1;
	static boolean visited[];
	
	static int answer = -1;
	
	//DFS
	static void DFS(int n, int lv) { //lv == 촌수 
		if(!visited[n] && n == ed) {
			answer = lv;
			return;
		}
		
		visited[n] =true;
		
		for(int x : graph.get(n)) {
			if(!visited[x]) {
				DFS(x, lv+1); //다음 깊이있게 이동
			}
		}	
	}
		
	//실해 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kb= new Scanner(System.in);
		n = kb.nextInt();
		st = kb.nextInt();
		ed = kb.nextInt();
		
		e = kb.nextInt();
		graph = new ArrayList<>();
		visited = new boolean[n+1];
		
		//공간은 노드 개수만큼 생성 
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		//입력 = 간선 개수만큼 받고 
		for(int i=0; i<e; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//촌수 양방향으로 삽입 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		//호출 
		DFS(st, 0);//출발 노드부터 탐새할 거고 
		
		System.out.println(answer);
	}

}