package to_0911_7;

import java.util.*;

/*1189번. 컴백홈 - DFS */
public class Main {
	static int R, C, K;
	static boolean[][] visited;
	static int[][] map;
	static int answer;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//DFS
	static void DFS(int x, int y, int lv) {
		if(x==0 && y ==C-1) {
			if(lv==K) {
				answer++;
			}
			return;//복귀
		}
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx <0 || ny <0 || nx >= R || ny>=C || visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			DFS(nx, ny, lv+1);//다음 정점으로 더 깊이 탐색하면서 감 
			visited[nx][ny] = false;
		}
		
	}
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		R = kb.nextInt();
		C = kb.nextInt();
		K = kb.nextInt();
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String tmp = kb.next();
			for(int j=0; j<C; j++) {
				if(tmp.charAt(j)=='T') {
					visited[i][j] = true;//방문체크해놓기
					map[i][j] = 1;
				}else {
					map[i][j] = 0;//0으로 담기
				}
			}
		}
		answer = 0;
		visited[R-1][0] = true;
		DFS(R-1, 0, 1);//시작점 
				
		System.out.println(answer);
	}
}