package to_24_0409_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 13460번 구슬 탈출 2- 
 * @author MYLG
 *
 */
class Node{
	int rx, ry;
	int bx, by;
	int cnt;//이동 횟수
	Node(int rx, int ry, int bx, int by, int cnt){
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}
public class Main {
	static int N, M;
	static char board[][];
	static boolean[][][][] visited;
	//4방향
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1}; //0, 1, 2, 3 (상, 우, 하, 좌) - 시계 방향
	
	//BFS
	static int BFS(Node st) {
		Queue<Node> Q = new LinkedList<>();
		visited[st.rx][st.ry][st.bx][st.by] = true;
		Q.offer(st);
		
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			int rx = cur.rx;
			int ry = cur.ry;
			int bx = cur.bx;
			int by = cur.by;
			int count = cur.cnt;//현재 
			
			if(count > 10) return -1;
			
			//현재 정점에서 4방향으로 매번 뻗을 거임 쭉 
			for(int k=0; k<4; k++) {
				int nRx = rx;
				int nRy = ry;
				int nBx = bx;
				int nBy = by;
				
				boolean isRed = false;
				boolean isBlue = false;
				
				//빨간 구슬 벽 만날 때까지 이동 
				while(board[nRx + dx[k]][nRy+dy[k]] != '#') {
					nRx += dx[k];
					nRy += dy[k];
					if(board[nRx][nRy] == 'O') {
						isRed = true;
						break;
					}
				}
				
				//파란 구슬 벽 만날 때까지 이동
				while(board[nBx + dx[k]][nBy + dy[k]] != '#') {
					nBx += dx[k];
					nBy += dy[k];
					if(board[nBx][nBy] == 'O') {
						isBlue = true;
						break;
					}
				}
					
				if(isBlue) continue;
				
				if(isRed && !isBlue) {
					return count;
				}
				
				//둘다 구멍에 빠지지는 않았는데 이동 위치가 같은 경우 [위치 조정 필요]
				if(nRx == nBx && nRy == nBy) {
					if(k==0) { //위쪽 
						//더 큰 x값 갖는 애가 뒤로 감
						if(rx > bx) nRx -= dx[k];
						else nBx -= dx[k];
					}
					if(k==1) { //오른쪽
						if(ry < by) nRy -= dy[k];
						else nBy -= dy[k];
					}
					if(k==2) { //아래쪽
						if(rx < bx) nRx -= dx[k];
						else nBx -= dx[k];
					}
					if(k==3) {//왼쪽
						if(ry > by) nRy -= dy[k];
						else nBy -= dy[k];
					}
				}
				
				//두 구슬 이동 위치 처음 이동하는 곳이면 
				if(!visited[nRx][nRy][nBx][nBy]) {
					visited[nRx][nRy][nBx][nBy] = true;
					Q.offer(new Node(nRx, nRy, nBx, nBy, count+1));
				}
			}
		}
		return -1;
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		board = new char[N][M];
		
		int[] arr = new int[4];
		
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				board[i][j] = tmp.charAt(j);
				if(board[i][j] == 'R') {
					arr[0] = i;
					arr[1] = j;
				}
				if(board[i][j] == 'B') {
					arr[2] = i;
					arr[3] = j;
				}
			}
		}
		
		visited = new boolean[N][M][N][M];
		
		Node st = new Node(arr[0], arr[1], arr[2], arr[3], 1);
		
		System.out.println(BFS(st));
	}

}
