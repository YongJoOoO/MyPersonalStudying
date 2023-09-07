package to_0907_I;

import java.util.ArrayList;
import java.util.Scanner;

/*21937번. 작업 - DFS 문풀 */
public class Main {
	static int N, M, X;
	static int[] indegree;
	static boolean[] visited;
	static int lv;
	static ArrayList<ArrayList<Integer>> graph;
	//DFS
	static int DFS(int st) {
		
		visited[st] = true;
		for(int nx : graph.get(st)) {
			if(!visited[nx]) {
				lv++;
				DFS(nx);
			}
		}
		return lv;
	}

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		indegree = new int[N+1];
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		//데이터 입력 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//a -> b 해야 함 
			graph.get(b).add(a);
		}
		X = kb.nextInt();// 거꾸로 입력받아서 출발점으로 시도 
		visited = new boolean[N+1];
	
		lv = 0;
		System.out.println(DFS(X));
	}
}