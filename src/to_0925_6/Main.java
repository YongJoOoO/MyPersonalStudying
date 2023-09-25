package to_0925_6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*1245번 농장 관리 - DFS */
public class Main {
	static int N, M;
	static int answer; 
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = { 1,1,1,0,0,-1,-1,-1 };
	static int[] dy = {1,0,-1,1,-1,1,0,-1 };
	
	//BFS
	static void BFS(int x, int y) {
		visited = new boolean[N][M];
		visited[x][y] = true;
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {x, y});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			for(int d = 0; d<8; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(nx <0 || ny< 0 || nx>=N || ny>=M || visited[nx][ny] ) continue;
				//다음 정점이 기존 정점보다 값이크다면 
				if(board[nx][ny] > board[cur[0]][cur[1]]) {
					return;
				}else if(board[nx][ny] == board[cur[0]][cur[1]]) {
					Q.offer(new int[] {nx, ny});
				}
				
				visited[nx][ny] = true;
			}
		}
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		board = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j] = kb.nextInt();
			}
		}

		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j] != 0) {
					BFS(i,j);
				}
			}
		}
		
		
		
		
		
	}

}
