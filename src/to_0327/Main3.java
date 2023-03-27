package to_0327;

import java.util.Scanner;

/* 8-10. 미로탐색 (DFS) */
public class Main3 {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] board;
	static int answer = 0;
	//DFS
	public void DFS(int x, int y) {
		if(x == 7 && y ==7) {
			answer++;
		}
		else {
			//4방향으로 돌면서
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];//다음 x 방향 
				int ny = y + dy[i];//다음 y 방향 
				//보드 경계 벗어나지 않도록 제한 걸어두기  (범위 내이면서 + 방문 전 0 인 대상만)
				if(nx>=1 && nx<=7 && ny >=1 && ny <=7 && board[nx][ny] == 0) {
					board[nx][ny] = 1; //방문 체크
					DFS(nx, ny);
					//다시 복귀
					board[nx][ny] = 0;
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		board = new int[8][8];
		for(int i=1; i<=7; i++) {
			for(int j =1; j<=7; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		//출발점 세팅 
		board[1][1]=1;
		T.DFS(1, 1);
		System.out.println(answer);
	}
}