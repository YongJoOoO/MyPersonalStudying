package to_0905_D;

import java.util.*;

/*1743번. 음식물 피하기 - DFS &BFS*/
public class Main {	
	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;

	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	//BFS
	static int BFS(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		int cnt = 0; //시작할 때 1로 세팅해서 
		visited[x][y] = true;
		Q.offer(new int[] {x, y});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			cnt++;
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx <0 || ny <0 || nx >=N || ny>=M ) continue;
				
				if(!visited[nx][ny] && map[nx][ny] == 1) {//1이 나타나면 
					Q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		return cnt;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		K = kb.nextInt();
		
		map = new int[N][M];
		visited= new boolean[N][M];
		
		for(int i=0; i<K; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			map[a-1][b-1] =1;
		}
	
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					max = Math.max(max, BFS(i, j));
				}
			}
		}
		System.out.println(max);
	}
}