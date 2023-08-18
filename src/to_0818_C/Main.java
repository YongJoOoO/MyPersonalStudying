package to_0818_C;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2573번. 빙산 풀이 
public class Main {
	static int N, M;
	static int[][] board;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static boolean [][] visited;
	//덩어리 분리 유무 확인 
	static int isTwo() {
		int cnt= 0;
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && board[i][j] != 0) {
					DFS(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	//매번 멜팅처릴 
	static void Melting() { //BFS로 인접한 얼음 카운팅하여 값 -- 
		Queue<int[] > Q = new LinkedList<>();
		boolean[][] chk = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j] !=0 ) {//0아닌 빙산으로 
					Q.add(new int[] {i, j});
					chk[i][j] = true;
				}
			}
		}
		
		while(!Q.isEmpty()){
			int[] cur = Q.poll();
			int num=0;//인근 상하좌우 바다 넘
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx<0 || ny< 0 || nx >=N || ny>=M)continue;
				
				if(!chk[nx][ny] && board[nx][ny] == 0) {
					num++;//바다개수 카운팅
				}
			}
			
			//현재 큐에 대하여 - 처리
			if(board[cur[0]][cur[1]] - num < 0) {//음수가 되어버리면 
				board[cur[0]][cur[1]] = 0;
			}else {
				board[cur[0]][cur[1]] -= num;
			}	
		}
	}
	
	
	//DFS로 풀어보기 
	static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx <0 || ny <0 || nx >= N || ny >= M) continue;
			
			if(!visited[nx][ny] && board[nx][ny] != 0) {
				DFS(nx, ny);//더 깊이 탐색 
			}
		}
		
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		board = new int[N][M];
		//여기서 DFS 호출함
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		
		//DFS 호출하며 가야하는데 
		boolean flag =false;

        int ans = 0;
        int cnt = 0;
 
        // 빙하가 2개 이상 분리될 경우 반복문을 종료.
        // 빙하가 다 녹아버렸을 경우, 0을 출력.
        while ((cnt = isTwo()) < 2) { //계속 한 덩어리인 동안 반복할 거고 
            if (cnt == 0) {// cnt=0이란 것은 다 녹아버린 거 
                ans = 0;
                break;//탈출 
            }
            Melting(); //멜팅 처리한 board에 대하여 
            ans++;
        }
		System.out.println(ans);
	}
	
	
}