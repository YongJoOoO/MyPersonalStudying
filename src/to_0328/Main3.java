package to_0328;

import java.util.Scanner;

/* 8-13. 섬나라 아일랜드  |DFS */
public class  Main3 {
	static int n, answer = 0;
	static int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
	
	//DFS 
	public void DFS(int x, int y, int[][] board) {
		//솔루션에서 호출하면 그 지점 인근(8방향)의 연결된 부분 모두 0으로 바꿔서 하나의 섬으로 인식하게끔한다.
		for(int i=0; i<8; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny <n && board[nx][ny] == 1) {//1일때 뻗어나감
				board[nx][ny] = 0;
				DFS(nx, ny, board); //재귀 호출 
			}
		}
	}
	
	//솔루션 함수 
	public void solution(int[][]board) {
		//이중 for 돌면서 섬 만날 때마다 DFS 호출
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				//섬 발견 시 
				if(board[i][j] == 1) {
					answer++;
					board[i][j] = 0; //여기서 시작점도 0체크
					DFS(i, j, board);// 호출 
				}
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		//솔루션 호출
		T.solution(arr);
		
		System.out.println(answer);
	}
}