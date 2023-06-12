package to_0612_10;

import java.util.*;

/* 유기농 배추 - BFS로 풀기 */
public class Main {
	static int T, M, N, e;
	
	static int[][] map;
	static boolean[][] visited;
	
	static ArrayList<Integer> arr = new ArrayList<>();
	
	//방향 변수
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//BFS
	static void BFS(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		
		visited[x][y] = true;
		Q.add(new int[] {x, y});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx<0 || ny<0 || nx >=M || ny>=N) continue;
				if(map[nx][ny] == 0 || visited[nx][ny]==true) continue;
				
				visited[nx][ny] = true;
				Q.add(new int[] {nx, ny});
			}
		}
	}	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		T = kb.nextInt();
		
		for(int t=0; t<T; t++) {
			int answer = 0;
			
			M = kb.nextInt();
			N = kb.nextInt();
			e = kb.nextInt();
			
			map = new int[M][N];
			visited = new boolean[M][N];
			
			//입력받기
			for(int i=0; i<e; i++) {
				map[kb.nextInt()][kb.nextInt()] = 1;
			}
			//BFS 덩어리 찾기  
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						answer++;
						BFS(i, j);
					}
				}
			} 
			 
			arr.add(answer); 
		} 
		
		//정답 출력
		for(int x : arr) {
			System.out.println(x);
		}	
	}
}