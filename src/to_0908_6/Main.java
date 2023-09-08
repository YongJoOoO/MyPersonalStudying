package to_0908_6;

import java.util.*;
import java.util.Queue;
import java.util.Scanner;
/*적록색약 - BFS 로 풀이 */
public class Main {
	static int N;
	static int[][] map;//지도
	static boolean[][] visited;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//BFS
	static void BFS(int x, int y) {
		Queue<int[]> Q= new LinkedList<>();
		/*이 안에서 인접한 애가 직전값이랑 같을 때만 더 뻗어나아가는데 */
		visited[x][y] = true;
		Q.offer(new int[] {x, y});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx <0 || ny<0 || nx >= N || ny>= N) continue;
				//직전값과 다음 인접 정점이 같은 값이면서 방문 전인 경우에만 계속 인접 탐색 
				if(!visited[nx][ny] && map[nx][ny] == map[cur[0]][cur[1]]) {
					visited[nx][ny] = true;
					Q.offer(new int[] {nx, ny});//다시 담기 
					
				}
			}
		}
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N =kb.nextInt();
		
		map = new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<N; j++) {
				if(tmp.charAt(j) == 'R') {
					map[i][j] = 1;
				}else if(tmp.charAt(j)=='G') {
					map[i][j] = 2;
				}else if(tmp.charAt(j)=='B') {
					map[i][j] = 3;
				}
			}
		}
		
		//정상인이 볼 때
		int ans1 = 0;
		visited= new boolean [N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					BFS(i, j);
					//같은 시작값에 대하여 쭉 인접 탐색 하다가 돌아온 거니까. 그 횟수가 덩어리 개수임 
					ans1++;
				}
			}
		}
		//적녹색약이 볼 때
		
		int ans2 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 2) map[i][j] = 1;//얘도 통합시키고 
			}
		}
		
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					BFS(i, j);
					ans2++;
				}
			}
		}

		System.out.println(ans1 + " "+ ans2);
	}
}