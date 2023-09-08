package to_0908_7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*백준 13565번 침투 - BFS & DFS 풀이 */
public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//BFS
	static boolean BFS(int x, int y) {
		Queue<int[]> Q= new LinkedList<>();
		visited[x][y] = true;
		Q.offer(new int[] {x, y});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			//만약 여기서 뽑은 애가 N-1이 된다면 밑마닥까지 닿은 거니까 true 리턴시킴
			if(cur[0] == N-1) return true;
			
			for(int k= 0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx <0 || ny <0 || nx >= N || ny>=M) continue;
				//전류 통하는 0 이 존재한다면 계속 넘비 탐색
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					Q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
			
		}
		
		
		
		return false;
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
		boolean flag = false;
		
		for(int i=0; i<M; i++) {
			if(map[0][i] == 0) {//즉 바깥 라인에서 전류 흐를 수 있는 흰색일 경우 
				if(BFS(0, i)) {
					flag = true;//하나라도 밑바닥까지 전달되는 게 있다면 true
				}
			}
		}
	
		if(!flag) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
	}
}