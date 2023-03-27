package to_0327;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 8-11. 미로의 최단 거리 통로 (BFS) */
class Point{
	public int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main4 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] board, dis;
	//BFS
	public void BFS(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		//들어온 좌표 넣고
		Q.offer(new Point(x, y));
		board[x][y] = 1; //방문 처리
		
		while(!Q.isEmpty()) {
			Point tmp  = Q.poll(); //좌표 하나 뽑고
			
			for(int i = 0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				//경계 확인
				if(nx >=1 && nx <=7 && ny>=1 && ny <=7 && board[nx][ny] == 0) {
					board[nx][ny]=1;//방문 체크
					Q.offer(new Point(nx, ny));
					dis[nx][ny] = dis[tmp.x][tmp.y]+1;//이전 값 +1씩 길이 측정
				}
			}
		}
	}
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb= new Scanner(System.in);
		
		board = new int[8][8];
		dis = new int[8][8];
		
		for(int i=1; i<=7; i++) {
			for(int j =1; j<=7; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		//호출
		T.BFS(1, 1);
		if(dis[7][7] == 0) System.out.println(-1);
		else System.out.println(dis[7][7]);
	}
}