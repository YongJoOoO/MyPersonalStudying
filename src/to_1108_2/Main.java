package to_1108_2;

import java.util.Scanner;

/**
 * RE 재풀이 - 16929번. 
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0 };
	//출발점 처리 
	static int firstX, firstY;
	
	//DFS
	static boolean DFS(int x, int y, int cnt) {
		visited[x][y] =true;
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx < 0 || nx >= N || ny <0 || ny>=M) continue;
			if(map[nx][ny] == map[x][y]) {
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					if(DFS(nx, ny , cnt+1)) return true;
				}else {
					if(cnt >= 4 && firstX == nx && firstY == ny) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		map = new char[N][M];
		visited= new boolean[N][M];
		
		//초기화
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		//호출
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited = new boolean[N][M];
				firstX = i;
				firstY = j;
				
				if(DFS(i, j, 1)) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
	}

}
