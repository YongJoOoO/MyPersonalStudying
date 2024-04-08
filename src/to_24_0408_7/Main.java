package to_24_0408_7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 구슬 탈출 2 
class Marble {
	int rx;
	int ry;
	int bx;
	int by;
	int cnt;
	
	Marble(int rx, int ry, int bx, int by, int cnt) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}
public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//BFS
	static int BFS(int rx, int ry, int bx, int by) {
		Queue<int[]> Q = new LinkedList<>();
		visited[rx][ry] = true;
		visited[bx][by] = true;
		int count = 0;
		Q.offer(new int[] {rx, ry});
		Q.offer(new int[] {bx, by});
		
		while(!Q.isEmpty()) {
			int[] curR = Q.poll();
			int[] curB = Q.poll();
			count++;
			//현재 좌표 기준으로 4방향으로 한번씩 뻗어 갈거임 
			for(int k=0; k<4; k++) {
				//현재 dir = k
				int nRx = curR[0] + dx[k];
				int nRy = curR[1] + dy[k];
				
				int nBx = curB[0] + dx[k];
				int nBy = curB[1] + dy[k];
				
				boolean Bflag = false;
				boolean Rflag = false;
				
				//파랑 먼저 보내봄 
				while(nBx < 0 || nBx >= N || nBy <0 || nBy >=M || map[nBx][nBy] == '#') {
					nBx += dx[k];
					nBy += dy[k];
				}
				
				visited[nBx][nBy] = true;
				
				//쭉 그칸으로 가봄 
				while(nRx < 0 || nRx >= N || nRy <0 || nRy >=M || map[nRx][nRy] == '#') {
					//근데 가다가 구멍 만나면 poll
					nRx += dx[k];
					nRy += dy[k];
					//도중에 만나 버리면 ? 
					if(map[nRx][nRy] == 'O') {
						Rflag = true;
						break;
					}
				}
				
				visited[nRx][nRy] = true;
				
				if(Bflag) continue;
				if(Rflag && Bflag) return count;
				
				
			}
		}
		
		return count;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		map = new char[N][M];
		visited = new boolean[N][M];//간 곳 마킹 
		int[] r = new int[2];
		int[] b = new int[2];
		
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == 'R') {
					r[0] = i;
					r[1] = j;
				}
				if(map[i][j] == 'B') {
					b[0] = i;
					b[1] = j;
				}
			}
		}
		
		int answer = BFS(r[0], r[1], b[0], b[1]);
		
		System.out.println(answer);
		
	}

}
