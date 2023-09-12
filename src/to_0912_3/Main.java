package to_0912_3;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*21938번. 영상 처리 - DFS & BFS 풀이 */
public class Main {
	static int N, M;
	static int T;
	static int[][] map;
	static boolean[][] visited;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//DFS
	static void DFS(int x, int y ) {
		visited[x][y] = true;
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx <0 || ny <0 || nx >= N || ny>= M) continue;
			if(!visited[nx][ny] && map[nx][ny]== 255) {
				//이때에민 더 깊이 방문한다.
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
		visited= new boolean[N][M];
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				int r = kb.nextInt();
				int g = kb.nextInt();
				int b = kb.nextInt();
				map[i][j] = (r+g+b) /3;//세가지 값 평균 
			}
		}
		
		T = kb.nextInt();//기준 경계값 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] >= T) map[i][j] = 255;
				else if(map[i][j] < T) map[i][j]= 0;
			}
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j] == 255) {
					DFS(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}