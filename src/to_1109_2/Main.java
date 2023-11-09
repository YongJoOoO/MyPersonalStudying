package to_1109_2;

import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static boolean isPeak;
	//8방향
	static int[] dx = {0, -1, 0 ,1,  -1,  -1,  1,  1};
	static int[] dy = {-1, 0, 1, 0,  -1, 1,  1, -1};
	
	//DFS
	static void DFS(int x, int y) {

		
		for(int k=0; k<8; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
			
			if(map[nx][ny] > map[x][y]) isPeak = false;
			if(visited[nx][ny]) continue;
			if(map[nx][ny] == map[x][y]) {
				visited[nx][ny] = true;
				DFS(nx, ny);
			}
			
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		
		map = new int[N][M];
		visited =new boolean[N][M];
		
		//초기화
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = kb.nextInt();
			}
		}
		
		//호출을 할 건데 
		//호출 횟수 누적해야 산봉우리 개수가 된다.
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j =0; j<M; j++) {
				if(!visited[i][j] && map[i][j] > 0) {
					isPeak = true;
					visited[i][j] = true;
					DFS(i,j);
					if(isPeak) answer++;					
				}
			}
		}
		
		System.out.println(answer);
	}
}