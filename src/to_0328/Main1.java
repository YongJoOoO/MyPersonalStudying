package to_0328;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 8-11. 미로의 최단거리 통로 (BFS) RE 풀이
 * */
class Point{
	int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main1 {
	static int[][] board, dis;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	//BFS
	public void BFS(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		board[x][y] = 1; 
		
		while(!Q.isEmpty()) {
			Point tmp = Q.poll();
			for(int i=0; i<4; i++) { 
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				//경계 조건 서렁
				if(nx >=1 && nx <=7 && ny >=1 && ny<=7 && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					Q.offer(new Point(nx, ny));
					//거리 측정
					dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		
		board = new int[8][8];
		dis = new int[8][8];
		//입력 받기 
		for(int i=1; i<8; i++) {
			for(int j=1; j<8; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		//호출
		T.BFS(1,1);
		
		//출력
		if(dis[7][7] == 0) System.out.println(-1);
		System.out.println(dis[7][7]);
	}
}