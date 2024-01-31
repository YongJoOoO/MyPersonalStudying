package to_24_0131_4;

import java.util.Scanner;

/**
 * 3109번. 빵집 - DFS 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int[] dx = {-1, 0, 1};
	static boolean flag;
	//DFS
	static boolean DFS(int x, int y) {
		visited[x][y] = true;
		if(y == C-1) { //y열이 마지막 열 진입 시 리턴 
			count++;
			return true;
		}
		
		for(int k=0; k<3; k++) {//3방향으로 뻗어감
			int nx = x + dx[k];
			int ny = y + 1;
			if(nx <0 || nx == R || ny <0 || ny ==C || map[nx][ny] == 1) continue;
			
			if(map[nx][ny] == 0 && !visited[nx][ny]) {
				if(DFS(nx, ny)) return true;
			}
		}
		return false;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		R = kb.nextInt();
		C = kb.nextInt();
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String tmp = kb.next();
			for(int j=0; j<C; j++) {
				if(tmp.charAt(j) == '.') {
					//빈칸 
					map[i][j] = 0;
				}else if(tmp.charAt(j) == 'x') {
					//건물
					map[i][j] = 1;
				}
			}
		}
		count = 0;
		for(int i=0; i<R; i++) {
			if(map[i][0] == 0 && !visited[i][0] ) {
				DFS(i, 0);
			}
		}
		System.out.println(count);
	}
}