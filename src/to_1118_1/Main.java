package to_1118_1;

import java.util.*;
import java.util.Queue;
import java.util.Scanner;

/**
 * 2178번. 미로 탐색 - BFS 문풀 
 * @author MYLG
 *
 */
public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	//4방향 탐색 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//BFS
	static void BFS(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		
		Q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || visited[nx][ny] == true) continue;
				visited[nx][ny] = true;
				map[nx][ny] = map[cur[0]][cur[1]] + 1;//직전값 + 1 처리 해주고 
				Q.offer(new int[] {nx, ny});
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
		visited = new boolean[N][M];
		//0,0 -> n-1, m-1 까지 최소 칸으로 가면 됨 
		
		//입력받기 
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				map[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
		}
		
		//출발해서 뻗어감 
		BFS(0,0);
		
		System.out.println(map[N-1][M-1]);
	}
}