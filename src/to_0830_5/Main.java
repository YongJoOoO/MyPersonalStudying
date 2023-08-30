package to_0830_5;

import java.util.Scanner;

/*1520번. 내리막길 - DFS + DP : DP로 체크해가면서 */
public class Main {
	static int M, N;
	static int[][] board;
	static int[][] dp;
	//4방향
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//DFS
	static int DFS(int x, int y) {
		//마지막 지점 닿았으면 
		if(x == M-1 && y == N-1) {
			return 1;//복귀
		}
		
		if(dp[x][y] == -1) {//아직 방문 전일 경우 
			dp[x][y] = 0;//방문처리해두고
			
			for(int i=0; i<4; i++) {//순회하마ㅕㄴ서 
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx <0 || ny<0 || nx >=M || ny >=N) continue;
				
				if(board[nx][ny] < board[x][y]) {//직전 점보다 작은 값에 대해서
					dp[x][y] += DFS(nx, ny);//다시 방문한 경우 누적 철 
				}
			}
		}
		return dp[x][y];//최종 복귀는 자기 자신으로 함 
	}
	
	//main 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
			
		M = kb.nextInt();
		N = kb.nextInt();
		dp = new int[M][N];
		board = new int[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = kb.nextInt();
				dp[i][j] = -1;
			}
		}		
		//출발 0,0 
		System.out.println(DFS(0, 0));
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
}