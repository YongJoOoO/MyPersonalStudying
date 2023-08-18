 package to_0818_7;

import java.util.*;

//2468번 안전 영역 
public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	//4방향
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//1) DFS 풀이 
	static void DFS(int x, int y, int height) {
		visited[x][y] = true;//방문체크 
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i]; 
			int ny = y + dy[i];
			if(nx <0 || ny <0 || nx >= N || ny >= N) continue;
			if(!visited[nx][ny] && map[nx][ny] > height) {//안전영역
				DFS(nx, ny, height);//그대로 h보내고 더 깊이
			}
		}
	}
	
	//2) BFS
	static void BFS(int x, int y, int height) {
		Queue<int[]> Q = new LinkedList<>();
		visited[x][y] = true;
		Q.add(new int[] {x, y});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx <0|| ny <0 || nx > N-1 || ny>N-1) continue;
				if(!visited[nx][ny] && height < map[nx][ny]) {
					Q.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		map = new int[N][N];
		visited= new boolean[N][N];
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j =0; j<N; j++) {
				map[i][j] = kb.nextInt();
				max = Math.max(max, map[i][j]);//최댓값 구해서 
			}
		}
		int answer = 0;
		//하나씩 호출하긴 할 건데 
		for(int h=0; h<=max; h++) { //각각의 기준 높이 h에서 DFS 호출
			visited = new boolean[N][N];//다시 리셋
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && map[i][j] > h) { //시작부터 조건에 맞게 호출해야 함
						//DFS(i, j, h);
						BFS(i, j, h);
						cnt++; //각각 깊이로 간 덩어리의 개수 
					}
				}
			}
			//각 h별로 최대 영역 cnt 나오는 애로 정답 세팅
			answer = Math.max(answer, cnt);//더 큰 카운팅 만나면 걔로 갱신
		}
		System.out.println(answer);
	}
}