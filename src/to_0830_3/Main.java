package to_0830_3;
/*백준 토마토 문제 RE 풀이 */
import java.util.*;
import java.util.Scanner;

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
		
		Scanner kb=new Scanner(System.in);
		
		M = kb.nextInt();
		N = kb.nextInt();
		board= new int[N][M];
		cnt=0;
		
		mainQ=  new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j] = kb.nextInt();
				if(board[i][j] == 0)cnt++;
				else if(board[i][j] == 1) mainQ.offer(new int[] {i, j});
			}
		}
		
		//BFS
		int lv =0;
		while(!mainQ.isEmpty() && cnt > 0){
			//lv탐색이므로 
			int len = mainQ.size();
			for(int i=0; i<len; i++) {
				int[] cur = mainQ.poll();
				
				for(int k=0; k<4; k++) {
					int nx = cur[0] + dx[k];
					int ny= cur[1] + dy[k];
					
					if(nx <0 || ny <0 || nx >= N || ny>=M || board[nx][ny] != 0) continue;
					//체킹용
					board[nx][ny] =1;
					cnt--;//하나씩 처리한 값 -- 
					mainQ.offer(new int[] {nx, ny});
				}
			}
			lv++;
		}		
		//정답 처리 
		if(cnt == 0) System.out.println(lv);
		else System.out.println(-1);
	}
}