package to_0328_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 8-13. 섬나라 아일랜드 BFS */
class Point{
	int x, y;
	Point(int x, int y ){
		this.x = x;
		this.y = y;
	}
}
	
public class Main4 {
	static int answer =0, n;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1,  -1};
	
	//BFS
	public void BFS(int x, int y, int[][] board) {
		Queue<Point> Q = new LinkedList<>();
		//받은 첫 위치는 큐에 담기
		Q.offer(new Point(x, y));
		while(!Q.isEmpty()) {
			Point pos = Q.poll();
			for(int i =0; i<8; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				if(nx >=0 && nx <n && ny >=0 && ny<n && board[nx][ny] == 1) {
					board[nx][ny] = 0;
					Q.offer(new Point(nx, ny));
				}
			}
		}
	}
	//solution
	public void solution(int[][] board) {
		for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(board[i][j] == 1) {
					answer++;
					//출발점 0 만들고 
					board[i][j] = 0;
					BFS(i, j, board);
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		int[][]arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		T.solution(arr);
		
		System.out.println(answer);		
	}
}