package to_0927_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*2151번. 거울 설치 - BFS 로 먼저 풀어 보기 */
public class Main {
	static int N;
	static char[][] map;
	static int[][] cost;
	static boolean[][] visited;
	static ArrayList<int[]> arr;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0 };
	
	//BFS
	static void BFS(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {x, y});
		visited[x][y] =true;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			if(map[cur[0]][cur[1]] == '#') return;
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				//범위 벗어나거나 *을 갖는 경우 안감 
				if(nx <0 || ny <0 || nx >=N || ny>= N || map[nx][ny] == '*') continue;

				Q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
		
	}
	
	//실행 메인 
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		cost = new int[N][N];
		arr = new ArrayList<>();
		visited =new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<N; j++) {
				if(tmp.charAt(j)=='#') arr.add(new int[] {i, j});
				map[i][j] = tmp.charAt(j);
			}
		}
		
		BFS(arr.get(0)[0], arr.get(0)[1]);//호출 시작점
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(cost[i][j] +" ");
			}
			System.out.println();
		}
		
		
	}
}