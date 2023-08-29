package to_0829_5;

import java.util.*;
import java.util.Queue;

/*7576번 토마토- BFS - RE 다시 풀어야 할 문제  */
public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dp;
	static Queue<int[]> mainQ;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//BFS
	static void BFS() {
		while(!mainQ.isEmpty()) {
			int[] tmt = mainQ.poll();
			
			int x = tmt[0];
			int y = tmt[1];

			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx <0 || ny<0 || nx >=N || ny >= M) continue;
				
				if(map[nx][ny] == 0) {
		
				}
			}
			
		}
	}
	
	//main 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		M = kb.nextInt();
		N = kb.nextInt();
		map = new int[N][M];	
		mainQ = new LinkedList<>();
		
		//데이터 입력받기 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = kb.nextInt();
				
				if(map[i][j] == 1) { //익은 토마토의 경우 출발점이 되어야 하므로 
					mainQ.offer(new int[] {i, j});
				}
			}
		}
		
		BFS();
	}
	

}
