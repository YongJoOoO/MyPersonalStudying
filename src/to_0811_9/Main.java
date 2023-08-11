package to_0811_9;

import java.util.Scanner;

/*2468번. 안전 영역 */
public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	//4방향 변수 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//DFS
	static void DFS(int x, int y, int height) {//기준 height 변수 
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = x + dy[i];
			if(nx <0 || ny <0 || nx >N-1 || ny > N-1) continue;
			if(!visited[nx][ny] && map[nx][ny] > height) {
				DFS(nx, ny, height);//해당 height에 대하여 더 깊이 탐색 
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		
		map = new int[N][N];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = kb.nextInt();//값 담기 
				max = Math.max(max, map[i][j]);
			}
		}
		
		int answer = 0;
		//DFS 호출할 건데 가장 영역이 큰 경우로 answer 세팅할 거고,
		//그러려면 가능한 모든 높이에서 다 탐색해봐야 함 
		for(int h = 0; h<= max; h++) {
			visited=  new boolean[N][N];
			
			int tmp = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//현재의 h이상값이라서 안전영역이면서 방문 전인 경우 탐색 
					if(map[i][j] > h && !visited[i][j]) {
						DFS(i, j, h);//기준값으로 보내고 
						tmp++;
					}
				}
			}
			//System.out.println(tmp);
			//여기서 각 h별로 구해진 tmp의 최대값을 answer 
			answer = Math.max(answer, tmp);
		}
		
		System.out.println(answer);
	}

}
