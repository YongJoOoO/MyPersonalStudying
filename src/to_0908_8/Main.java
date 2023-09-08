package to_0908_8;

import java.util.Scanner;

/*백준 13565번 침투 - BFS & DFS 풀이 */
public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag = false;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//DFS	
	static void DFS(int x, int y) {
		if(x == N-1) {//깊이 호출하다가 x행이 N-1밑바닥 행이 된다면 
			flag =  true;//여기서 true 리턴하면 되고 
		}
		visited[x][y] = true;
		
		for(int k =0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx <0 || ny <0 || nx >= N || ny>=M) continue;
			if(!visited[nx][ny] && map[nx][ny] == 0) {
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
		
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				map[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
		}
		
		visited= new boolean[N][M];
		
		for(int i=0; i<M; i++) {
			if(map[0][i] == 0) {//즉 바깥 라인에서 전류 흐를 수 있는 흰색일 경우 
				DFS(0, i);//모두 호출해도 
			}
		}
		if(!flag) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
	}
}
