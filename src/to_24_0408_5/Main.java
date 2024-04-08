package to_24_0408_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 13460번. 구슬 탈출 2 - BFS 문풀
 * @author MYLG
 *
 */
public class Main {
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int N, M;
	static char[][] board;
	static boolean[][] visited;

	//BFS
	static int BFS(int[] R, int[] B) {
		int count = 0;
		Queue<int[]> Q= new LinkedList<>();
		Q.offer(R);
		Q.offer(B);
		
		while(!Q.isEmpty()) {
			//출발점
			int[] curR = Q.poll();
			int[] curB = Q.poll();
			count++;
			for(int k= 0; k<4; k++) { //매번 4방향으로 갈 거임 
				//매번 현 위치에서 한 방향으로 쭉 감 - 가다가 만나면 됨 
				int nxR = curR[0];
				int nyR = curR[1];
				
				int nxB = curB[0];
				int nyB = curB[1];
				
				//R도 현재 방향으로 쭉 가기 
				while(nxR >=0 && nxB >= 0 && nyR < N && nyB < M) {//쭉 한 방향으로 갈거임 
					nxR += dx[k];
					nyR += dy[k];
					if(board[nxR][nxB] == '#') break;
				}
				//탈출 시점에서 하나씩 직전으로 돌아감
				nxR -= dx[k];
				nyR -= dy[k];
				
				//B도 현재 방향으로 쭉 가기 
				while(nxR >=0 && nxB >= 0 && nyR < N && nyB < M) {//쭉 한 방향으로 갈거임 
					nxB += dx[k];
					nyB += dy[k];
					if(board[nxB][nyB] == '#') break;
				}
				
				nxB -= dx[k];
				nyB -= dy[k];
				
				
				System.out.println("R : "+nxR + ",  "+ nyR);
				System.out.println("B : "+ nxB + ", "+nyB);
				
			}
		}
		return count;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		board = new char[N][M];
		int[] R = new int[2];
		int[] B = new int[2];
		
		//입력 받음 
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				board[i][j] = tmp.charAt(j);
				if(board[i][j] == 'R') {
					R[0] = i;
					R[1] = j;
				}
				if(board[i][j] == 'B') {
					B[0] = i;
					B[1] = j;
				}
			}
		}
		visited = new boolean[N][M];
		
		BFS(R, B);
	}
}