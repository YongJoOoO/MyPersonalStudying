package to_0817_4;

import java.util.Scanner;

//2468번. 안전영역 
public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//DFS
	static void DFS(int x, int y, int h) {
		
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny <0 || nx >= N || ny>= N) continue;
			
			if(!visited[nx][ny] && h < map[nx][ny]) { //현재 높이보다 큰 애들에 대하여 깊이 탐색 
				DFS(nx, ny, h);
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		map = new int[N][N];
		visited =new boolean[N][N];
		
		max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = kb.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		
		int answer = 0;
		//DFS호출 
		for(int h=0; h<=max; h++) {
			int cnt = 0; 
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && h < map[i][j]) {
						cnt++;
						DFS(i, j, h);
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
	}

}
