package to_0816_A;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*백준 1303번 전쟁- 전투 문풀 */
public class Main {
	static int N, M;
	static Character[][] map;
	static boolean[][] visited;
	static int cnt;
	static int our =0, other=0;
	//4방향
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//DFS -이 안에서 B랑 W 구분해서 각각 값 구하기 
	static void DFS(int x, int y) {
		char cur = map[x][y];//현 좌표 
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || ny <0 || nx >= N || ny>=M) continue;
			
			if(!visited[nx][ny] && map[nx][ny] == cur) {
				cnt++;
				DFS(nx, ny);
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		M = kb.nextInt();
		N = kb.nextInt();
		map = new Character[N][M];
		visited = new boolean[N][M];

		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<tmp.length(); j++) {
				char ch = tmp.charAt(j);
				map[i][j] = ch;
			}
		}
		//호출
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) {
					cnt = 1;//여기서 0 초기화
					DFS(i, j);
					if(map[i][j] == 'W') our += (cnt*cnt);
					else if(map[i][j] == 'B') other += (cnt*cnt);
				}
			}
		}
		System.out.println(our + " " + other);
	}
}