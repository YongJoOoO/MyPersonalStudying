package to_0911_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*14716번 현수막 - DFS & BFS 풀이 */
public class Main {
	//8방향 탐색
	static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
	static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	//DFS
	static void DFS(int x, int y ) {
		visited[x][y] = true;//방문체크
		
		for(int k=0; k<8; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx <0 || ny <0 || nx>=M || ny>=N || map[nx][ny] == 0) continue;
			
			if(!visited[nx][ny] && map[nx][ny]==1) { 
				DFS(nx, ny);//더 깊이 탐색
			}
		}
	}
	//BFS
	static void BFS(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {x, y});//담고
		visited[x][y] = true;
		
		while(!Q.isEmpty()) {
			int len =Q.size();
			for(int i=0; i<len; i++) { //레벨 탐색 
				int[] cur = Q.poll();//하나씩 뽑고 
				for(int k=0; k<8; k++) {
					int nx = cur[0] + dx[k];
					int ny = cur[1] + dy[k];
					if(nx <0 || ny<0 || nx >= M || ny>=N || map[nx][ny] == 0) continue;
					if(!visited[nx][ny] && map[nx][ny]==1) {
						visited[nx][ny] = true;
						Q.offer(new int[] {nx, ny});
					}
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		M = kb.nextInt();//행
		N = kb.nextInt();//열
		map = new int[M][N];
		visited =new boolean[M][N];
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = kb.nextInt();
			}
		}
		
		int cnt = 0;
		//호출 
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					//방문 전이면서 1인 애한테 탐색
					//그 호출 횟수 == 덩어리 개수 
					//DFS(i, j);
					BFS(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}