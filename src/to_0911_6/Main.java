package to_0911_6;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*2206번. 벽 부수고 이동하기 - DFS BFS 문풀 */
public class Main {
	static int N, M;
	static int[][] map;
	static int[][] cost;//최단거리 저장용 배열 
	static int cnt;//벽은 최대 1개 만 부실 수 있음 
	
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//BFS
	static void BFS(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {x, y});
		int lv = 1;//1로 세팅하기 
		while(!Q.isEmpty()) {
			int len = Q.size();//현제 레벨에서 닿는 범위 돌기 
			for(int i=0; i<len; i++) {
				int[] cur = Q.poll();
				for(int k=0; k<4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(nx <0 || ny<0 || nx >=N || ny>=M) continue;
					
					//다음 정점이 1일 경우 
					if(map[nx][ny]==1 && cnt == 0 && cost[nx][ny] > cost[cur[0]][cur[1]] + 1) {
						cost[nx][ny] = cost[cur[0]][cur[1]]+ 1;
						cnt++;
						Q.offer(new int[] {nx, ny});
					}
					if(map[nx][ny] == 0 && cost[nx][ny] > cost[cur[0]][cur[1]] + 1) {
						cost[nx][ny] = cost[cur[0]][cur[1]] + 1;
						Q.offer(new int[] {nx, ny});
					}
				}
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
		cost = new int[N][M];
		for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = kb.nextInt();
			}
		}
		
		cnt =0;
		cost[0][0] = 1;
		BFS(0, 0 );
		
		if(cost[N-1][M-1] == Integer.MAX_VALUE) {
			//닿지 못했으면 
			System.out.println("-1");
		}else {
			System.out.println(cost[N-1][M-1]);
		}
	
	}
}