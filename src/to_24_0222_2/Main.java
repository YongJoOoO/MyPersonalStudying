package to_24_0222_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 13460번. 구슬 탈출 2 - BFS 문풀 
 * @author MYLG
 *
 */
public class Main {
	private static int N, M;
	private static boolean[][][][] visited;
	private static char[][] map;
	//4방향
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	//BFS
	private static int BFS(int rx, int ry, int bx, int by) {
		Queue<int[]> Q = new LinkedList<>();
		
		Q.offer(new int[] {rx, ry, bx, by, 0});
		visited = new boolean[N][M][N][M];
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			if(cur[4] > 10) {
				return -1;
			}
			
			for(int k = 0; k<4; k++) {
				int nRx = cur[0];
				int nRy = cur[1];
				int nBx = cur[2];
				int nBy = cur[3];
				int cur_cnt = cur[4];
				
				boolean red_hole = false;
				boolean blue_hole = false;
				
				while(map[nRx][nRy] != '#') {
					nRx += dx[k];
					nRy += dy[k];
					if(map[nRx][nRy] == 'O') { //가는 길에 홀 만나면 
						red_hole = true;
						break;
					}
				}
				
				while(map[nBx][nBy] != '#') {
					nBx += dx[k];
					nBy += dy[k];
					if(map[nBx][nBy] == 'O') {
						blue_hole = true;
						break;
					}
				}
				
				if(blue_hole) continue;
				
				if(red_hole && !blue_hole) {
					return cur_cnt;
				}
				
				if(nRx == nBx && nRy == nBy) {
					if(k==0) {//위로
						//애초에 컸던 애를 뒤로 보냄 
						if(cur[0] > cur[2]) nRx -= dx[k];
						else nBx -= dy[k];
					}
					if(k==1) {//오른쪽 
						if(cur[1] < cur[3]) nRy -= dy[k];
						else nBy -= dy[k];
					}
					if(k==2) {
						if(cur[0] < cur[2]) nRx -= dx[k];
						else nBx -= dx[k];
					}
					if(k==3) {
						if(cur[1] > cur[3]) nRy -= dy[k];
						else nBy -= dy[k];
					}
				}
				
				//두 구슬이 이동할 위치가 처음 방문하는 곳인 경우에만 이동
				if(!visited[nRx][nRy][nBx][nBy]) {
					visited[nRx][nRy][nBx][nBy]	= true;
					Q.offer(new int[] {nRx, nRy, nBx, nBy, cur_cnt++});
				}
			}
		}
		return -1;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		map = new char[N][M];
		int[] R_st = new int[2];
		int[] B_st = new int[2];
		
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == 'R') {
					R_st[0] = i;
					R_st[1] = j;
				}
				if(map[i][j]== 'B') {
					B_st[0] = i;
					B_st[1]= j;
				}
			}
		}
		
		System.out.println(BFS(R_st[0], R_st[1], B_st[0], B_st[1]));
	}
}