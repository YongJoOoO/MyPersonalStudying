package to_0811_C;

import java.util.Scanner;

/*15650번. N과 M (2) */
public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] answer;

	//DFS
	static void DFS(int lv, int s) { //출발점 
		if(lv == M) {
			for(int x : answer) {
				System.out.print(x+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=s; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				answer[lv] = i+1;
				DFS(lv+1, i); //출발점
				visited[i] = false;
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		answer = new int[M];//값 
		
		visited= new boolean[N];

		
		DFS(0, 0);
	}
}