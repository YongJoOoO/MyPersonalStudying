package to_0829_4;

import java.util.*;

/*1937번. 욕심쟁이 판다- DP & DFS*/
public class Main {
	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//DFS
	static int DFS(int x, int y) {
		if(dp[x][y] != 0) return dp[x][y];
		
		dp[x][y] = 1;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || ny<0 || nx >=N || ny>= N) continue;
			if(map[x][y] < map[nx][ny]) {
				dp[x][y] = Math.max(dp[x][y], DFS(nx, ny) + 1);
			}
		}
		return dp[x][y];
	}
	
	//실행메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		map = new int[N][N];
		dp = new int[N][N];
		
		//데이터 입력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = kb.nextInt();//차례로 입력받기 
			}
		}
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
			
				max = Math.max(DFS(i, j), max);
			}
		}
		System.out.println(max);
	}

}
