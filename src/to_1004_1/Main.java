package to_1004_1;

import java.util.*;

/*13460번. 구슬 탈출 2 - BFS 문풀 */
class Marble{
	//현재의 위치와 cnt를 계속해서 공유해야 하기 때문 
	int rx, ry, bx, by, cnt;
	Marble(int rx, int ry, int bx, int by, int cnt){
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
	static boolean[][][][] visited;//방문체크 
	static int OX, OY;//구멍 위치 
	static Marble blue, red;
	
	//4방향 
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1}; 
	
	
	//BFS
	static int BFS() {
		Queue<Marble> Q = new LinkedList<>();
		//고정된 blue, red 객체에서 하나씩 뽑고 초기화 cnt 1 초기화 
		Q.offer(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
		visited[red.rx][red.ry][blue.bx][blue.by] = true;
		
		while(!Q.isEmpty()) {
			Marble cur = Q.poll();
			
			int curRx = cur.rx;
			int curRy = cur.ry;
			
			int curBx = cur.bx;
			int curBy = cur.by;
			
			int curCnt = cur.cnt;
			
			if(curCnt > 10) break;//10번 넘어갈 경우는 그냥 -1리턴
			
			
			//4방향에 따른 방향처리 
			for(int k=0; k<4; k++) { //각각의 4방향에 대하여 돌건데 
				//현재값에서 
				int nxRx = curRx;
				int nxRy = curRy;
				int nxBx = curBx;
				int nxBy = curBy;
				
				boolean isRedHole = false;
				boolean isBlueHole = false;
				
				//빨간 구슬 이동처리 - 벽 만날 때까지
				while(map[nxRx + dx[k]][nxRy + dy[k]] != '#') {
					//다음 좌표가 '#'아닌 동안 한 방향으로 쭉 감 
					nxRx += dx[k];
					nxRy += dy[k];
					
					//이동 중 구슬 만나면 flag 갱신 
					if(nxRx == OX && nxRy == OY) {
						isRedHole = true;
						break;
					}
				}
				//파란 구슬 이동처리 = 벽 만날 때까지
				while(map[nxBx + dx[k]][nxBy + dy[k]] != '#') {
					nxBx += dx[k];
					nxBy += dy[k];
					
					//구멍 만나면 flag 기록
					if(nxBx == OX && nxBy == OY) {
						isBlueHole = true;
						break;
					}
				}
				
				//근데 파란 구슬이 true이면 무조건 실패임
				if(isBlueHole) continue;
				
				if(isRedHole) return curCnt;
				
				
				//둘 다 구멍 빠지지 않았는데 위치 같을 경우는 - 위치 조정해야 함
				//왜냐면 벽까지 이동하기 때문에 같은 좌표에 도달할 수도 있기 때문
				if(nxRx == nxBx && nxRy == nxBy) {
					if(k==0) { //위쪽 
						//더 큰 x값 갖는 구슬이 뒤로 감 
						if(curRx > curBx) nxRx -= dx[k];//한방향 물러서기 
						else nxBx -= dx[k];
					}else if(k == 1) { //오른쪽 
						if(curRy < curBy) nxRy -= dy[k];
						else nxBy -= dy[k];
					}else if(k == 2) {
						if(curRx < curBx) nxRx -= dx[k];
						else nxBx -= dx[k];
					}else {
						if(curRy > curBy) nxRy -= dy[k];
						else nxBy -= dy[k];
					}
				}
				
				//두 구슬이 이동할 위치가 처음 방문한 곳일 때만 큐에 추가
				if(!visited[nxRx][nxRy][nxBx][nxBy]) {
					visited[nxRx][nxRy][nxBx][nxBy] = true;
					Q.offer(new Marble(nxRx, nxRy, nxBx, nxBy, curCnt+1));
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
		
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j);
				
				if(map[i][j] == 'O') {
					OX = i;
					OY = j;
				}else if(map[i][j] == 'B') {
					//초기화
					blue = new Marble(0, 0, i, j, 0);
				}else if(map[i][j] == 'R') {
					red  = new Marble(i, j, 0, 0, 0);
				}
			}
		}
		
		//R위치와 B위치를 동시에 처리해야 함 # 만날 때까지 
		System.out.println(BFS());
		
	}

}
