package back_0327;
/*2178번. 미로탐색 다시 Re ㅠㅠ*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	public int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
//실행 메인 
public class Main {
	//변수
	static int n, m;
	static int[][] board, dis;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static boolean[][] chk;
	//BFS
	public void BFS(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		chk[x][y] = true;
		
		while(!Q.isEmpty()) {
			Point cur = Q.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx >=1 && nx <=n && ny >=1 && ny<=m && board[nx][ny]==1 && chk[nx][ny]==false) {
					chk[nx][ny]=true;
					dis[nx][ny] = dis[cur.x][cur.y]+1;
					Q.offer(new Point(nx, ny));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb= new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		
		board = new int[n+1][m+1];
		dis = new int[n+1][m+1];
		chk = new boolean[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			String tmp = kb.nextLine();
			char[] c = tmp.toCharArray();
			
			for(int j =1; j<=m; j++) {
				board[i+1][j] = c[i] + '0';
			}
		}
		
		T.BFS(1, 1);
		
		System.out.println(dis[n][m]);
	}

}
