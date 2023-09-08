package to_0908_H;

import java.util.*;

/*21736번. 헌내기는 친구가 필요해 - DFS BFS 문풀 */
public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//DFS
	static void DFS(int x, int y) {
		visited[x][y] = true;
		for(int k= 0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y+ dy[k];
			if(nx<0 || ny <0 || nx >= N || ny>=M || map[nx][ny] ==-1 || visited[nx][ny] == true) continue;
			
			if(map[nx][ny] == 1) {//사람 만나면 
				answer++;
			}
			DFS(nx, ny);//더 깊이 탐색 
		}
	}
	
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		map=  new int[N][M];
		visited=  new boolean[N][M];
		int x = 0;
		int y = 0;
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				if(tmp.charAt(j) == 'O') {//빈공간은 0
					map[i][j] = 0;
				}else if(tmp.charAt(j) == 'X') { //벽은 못 감 
					map[i][j] = -1;
				}else if(tmp.charAt(j)=='I') { //도연 위치 
					map[i][j] = 0;
					x= i;
					y = j;
				}else if(tmp.charAt(j)=='P') { //카운팅 할 사람 수 
					map[i][j] = 1;
				}
			}
		}
		answer = 0;
		//이제 호출 
		DFS(x, y);	
		if(answer == 0) {
			//아무도 끝내 만나지 못했을 경우 
			System.out.println("TT");
		}else {
			System.out.println(answer);
		}
	}
}