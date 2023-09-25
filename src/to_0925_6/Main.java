package to_0925_6;

import java.util.Scanner;

/*1245번 농장 관리 - DFS */
public class Main {
	static int N, M;
	static int[] dx = { 1,1,1,0,0,-1,-1,-1 };
	static int[] dy = {1,0,-1,1,-1,1,0,-1 };
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		int[][] board = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		
		boolean[][] visited = new boolean[N][M];
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j]) continue;
				if(board[i][j] == 0) {
					visited[i][j] = true;
					continue;
				}
			}
		}
		
		
		
	}

}
