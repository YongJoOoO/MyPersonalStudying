package to_0328;
/* 8-12. 토마토 (BFS) 좀 어렵다.*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point1 {
	public int x,y;
	Point1 (int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main2 {
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] board, dis;
	static int n, m;
	//메인에서도 접근 가능하도록 여기서 선언시킴
	static Queue<Point> Q= new LinkedList<>();
	
	//BFS
	public void BFS() {
		while(!Q.isEmpty()) {
			Point tmp = Q.poll();
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx >=1 && nx <=n && ny >=1 && ny <= m && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					Q.offer(new Point(nx, ny));
					dis[nx][ny] = dis[tmp.x][tmp.y]+1;
				}
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		
		board = new int[n][m];
		dis = new int[n][m];
		//입력받기 
		for(int i=0; i<n; i++) {
			for(int j =0; j<m; j++) {
				board[i][j] = kb.nextInt();
				//최초로 1인 익은 토마토가 시작점이고 걔네를 큐에 삽입시켜야 -> 인접 정점들 주위로 퍼져나가니까.
				if(board[i][j] == 1) Q.offer(new Point(i, j));
			}
		}
		//호출
		T.BFS();
		
		boolean flag = true;
		int answer = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				//BFS 끝나고 왔는데도 0이 있다고 하면. 
				//즉, 아직 안익은 게 있다면 flag에 false값 주기 
				if(board[i][j] ==0 ) flag = false;
			}
		}
		//flag 가 true가 됐따면 모두 익은 거기 때문에 
		if(flag) {
			for(int i = 0; i<n; i++) {
				for(int j =0; j<m; j++) {
					//기존 answer와 dis의 값 비교하여 최대값 담고
					answer = Math.max(answer, dis[i][j]);
				}
			}
			System.out.println(answer); //답 출력 
		}
		//만약 토마토가 모두 익지는 않은 상황인거라면 -1 출력
		System.out.println(-1);
	}
}