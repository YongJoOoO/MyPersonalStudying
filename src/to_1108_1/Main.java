package to_1108_1;

import java.util.Scanner;

/**
 * 16929번. Two Dots - DFS 문풀 ㄴ
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	//4방향
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int firstX, firstY;
	
	//DFS -사이클 여부를 리턴
	static boolean DFS(int x, int y, int cnt) {		
		visited[x][y] = true;
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			//경계 벗어나면 일단 안감 
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			
			if(map[nx][ny] == map[x][y]) { //직전과 값이 같으면서 
				//방문안했을 경우, 
				if(!visited[nx][ny]) {
					visited[nx][ny] = true; //방문처리 후 
					//DFS탐색할 건데. 얘가 여기서 리턴받는 애가 true이면 true최종 리턴하고 
					if(DFS(nx, ny, cnt+1)) return true;
				}else {
					//이미 방문했던 경우면
					//cnt>= 이면서 firstX, firstY 와 같은 정점일 경우 return true리턴
					if(cnt >= 4 && firstX == nx && firstY == ny) return true;
				}
			}
		}
		return false;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		map = new char[N][M];
		visited = new boolean[N][M];
		//초기화
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
	
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited= new boolean[N][M];
				firstX = i;
				firstY = j;
				if(DFS(i, j, 1)) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
	}

}