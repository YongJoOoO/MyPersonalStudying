package to_0817_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1303번 전투-전쟁 BFS - 왜 안되냐고 !!!!!!!!!!!!!!!!!!
public class Main { 
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int our = 0, other = 0;
	//4방향
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//BFS
	static int BFS(char c, int x, int y) {
		int cnt = 1;
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] {x, y});
		visited[x][y]= true;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny  =y + dy[i];
				if(nx <0 || ny <0 || nx >= N || ny >= M) continue;
				if(!visited[nx][ny] && map[nx][ny] == c) {
					visited[nx][ny] = true;
					Q.add(new int[] {nx, ny});
					cnt++;
				}
			}
		}
		return cnt*cnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		M = kb.nextInt();
		N = kb.nextInt();
		
		map = new char[N][M];
		visited= new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				char ch = tmp.charAt(j);
				map[i][j] = ch;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) {
					int a = BFS(map[i][j], i, j);
					if(map[i][j] == 'W') {
						our += a;
						System.out.print(our+" ");
					}
					else if(map[i][j] == 'B') {
						other +=a;
						System.out.print(other + " ");
					}
				}
			}
		}
		System.out.println(our + " " + other);
	}
}