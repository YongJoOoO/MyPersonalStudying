package to_0811_8;

import java.util.*;

//21938번. 영상 처리 
public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int T;
	
	//상하좌우 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//dfs
	static void BFS(int x, int y) {
		
		Queue<int[]> Q= new LinkedList<>();
		Q.add(new int[] {x, y} );
		visited[x][y] = true;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx <0 || ny <0 || nx >=N || ny >= M) continue;
				if(!visited[nx][ny] && map[nx][ny] != 0) {
					Q.add(new int[] {nx, ny});
					visited[nx][ny] = true;//방문처리 
				}
			}
		}
	}
	
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		
		
		map = new int[N][M];
		//입력 받기 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int r = kb.nextInt();
				int g = kb.nextInt();
				int b = kb.nextInt();
				//3번 입력받고
				map[i][j] = (r+g+b) / 3;
			}
		}
		T = kb.nextInt();//경계값이지
		//값을 바꿔주고 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] >= T) map[i][j] = 255;
				else map[i][j] = 0;
			}
		}
		
		
		visited= new boolean[N][M];
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] >= 255 && !visited[i][j]) {
					BFS(i, j);
					answer++;//호출 횟수가 개수
				}
			}
		}
		
		System.out.println(answer);
		
	}
}