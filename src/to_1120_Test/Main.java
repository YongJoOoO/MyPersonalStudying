package to_1120_Test;
/**
 * 4번. 행렬의 영역 - DFS BFS 문풀
 * @author MYLG
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0 };
	
	//BFS
	static int BFS(int x, int y) { 
		Queue<int[]> Q = new LinkedList<>();
		visited[x][y] = true;
		Q.offer(new int[] {x, y});
		
		int sum = 1;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
		
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				
				if(nx < 0|| ny <0 || nx>=N || ny >= N || visited[nx][ny] || map[nx][ny] == 0) continue;
				
				sum++;
				visited[nx][ny] = true;
				Q.offer(new int[] {nx, ny});
				
			}
		}
		return sum;
	}
	
	//실행 메인 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		//데이터 입력 - 공백 기준 
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
		}
		
		int count= 0;//전체 개수 
		List<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					int answer = BFS(i, j);
					arr.add(answer);
					count++;
				}
			}
		}
		
		Collections.sort(arr);
		
		System.out.println(count);
		
		if(count != 0) {
			for(int x : arr) {
				System.out.print(x+ " ");
			}
		}
	}
}