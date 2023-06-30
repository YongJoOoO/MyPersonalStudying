package to_0630_6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean visited[];
	static boolean arrive;
	//dfs
	static void dfs(int v, int lv) {
		if(lv == 5 || arrive) {
			arrive= true;
			return;
		}
		//방문체크
		visited[v] = true;
		
		for(int nx : graph.get(v)) {
			if(!visited[nx]) {
				dfs(nx, lv+1);
			}
		}
		visited[v] = false;//다시 복귀하여 다른 뿌리로 lv 깊이 탐색해야 하므로 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		visited = new boolean[N];
		graph = new ArrayList<>();
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
	
		for(int i=0; i<N; i++) {
			dfs(i, 1);
			
			if(arrive) {
				break;//탈출 
			}
		}
		
		if(arrive) System.out.println(1);
		else System.out.println(0);
		
	}
}