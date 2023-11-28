package to_1128_1;

import java.util.Scanner;

/**
 * DFS-BFS 기초 - 재귀함수 
 * @author MYLG
 *
 */
public class Main {
	static int N;
	static boolean[] visited;
	
	static void DFS(int N) {
		if(N == 0) return;
		else {
			DFS(N-1);
			System.out.print(N + " ");
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
	
		visited=  new boolean[N+1];
		
		DFS(N);
	}	

}
