package to_1120_Test_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 3번 문제 풀이
 * @author MYLG
 *
 */
class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//BFS-
	static int[] BFS(int x, int y) {
		Queue<int[]> Q  = new LinkedList<>();
		visited[x][y] = true;
		Q.offer(new int[] {x, y});
		
		int[] answer = new int[2];
		int count = 1;
		int ttang = 0;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx < 0|| ny<0 || nx >= N || ny>=M) continue;
				if(map[nx][ny] == 1) {
					count++;
					visited[nx][ny] = true;
					Q.offer(new int[] {nx, ny});
				}else if(map[nx][ny] == 0) {
					ttang++;
				}
			}
		}
		
		answer[0] = count;
		answer[1] = ttang;
		return answer;
	}
	
	
	
	//실행메인 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
		}
		
		//호출
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					int[] ans = BFS(i, j);
					System.out.println(ans[0] + " "+ ans[1]);
				}
			}
		}
		
	}
}