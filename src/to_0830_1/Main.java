package to_0830_1;

import java.util.*;

/*7576번. 토마토 문풀 - RE */
public class Main {
	static int N, M;
	static int[][] board;//값 담는 용 -> 갱신할 거임
	static int cnt;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//전체 큐
	static Queue<int[]> mainQ;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		M = kb.nextInt();
		N = kb.nextInt();
		board = new int[N][M];

		cnt = 0;
		
		//데이터 입력 받을 건데 
		mainQ = new LinkedList<>();
		boolean flag = false;//만약 처음부터 0인 지점이 아예없어서 -> false가 나오면 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j] = kb.nextInt();
				//시작점으로 담아두고 
				if(board[i][j]==1) mainQ.offer( new int[]{i, j}); //시작점 담아놨따가 
				else if(board[i][j] == 0) cnt++;//안익은 토마토 개수 
			}
		}
		int days = 0;//레벨 탐색하면서 레벨 담는 == 
		//BFS 시작 
		while(cnt > 0 && !mainQ.isEmpty()) {
			//lv탐색
			int len= mainQ.size();
			for(int i=0; i<len ;i++) {//레벨 탐색함
				int[] cur = mainQ.poll();
				
				for(int k=0; k<4; k++) {
					int nx = cur[0] + dx[k];
					int ny = cur[1] + dy[k];
					if(nx <0 || ny<0 || nx >=N || ny>=M || board[nx][ny] != 0) continue;
					//0인 경우에만 
					cnt--;
					board[nx][ny] = 1;//처리했다 이거지 
					mainQ.offer(new int[] {nx, ny});//큐에 담고 
				}
			}
			days++; //레벨 ++처리
		}
		//정답 출력 
		if(cnt ==0) System.out.println(days);
		else System.out.println(-1);
	}
}