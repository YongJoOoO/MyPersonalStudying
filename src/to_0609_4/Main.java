package to_0609_4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*미로탐색 다시 풀기 */
//좌표 객체 
class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	//static
	static boolean[][] visited;//방문 체크 배열 
	static int n, m;//가로 세로
	static int[][] A;//원본 배열 
	//상하좌우 좌표 
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	//BFS
	static void BFS(int x, int y) {
		Queue<Point> Q= new LinkedList<>();
		//방문 처리 
		Q.offer(new Point(x, y));
		visited[x][y] = true;
		
		while(!Q.isEmpty()) {
			Point cur = Q.poll();//현재 정점뽑고
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				//좌표가 경계선 벗어나면 패스 
				if(nx<0 || ny<0 || nx >=n ||ny>=m) continue;
				//좌표의 값이 벽이 0 아니고, 방문 전이어야 함 그 외는 패스
				if(A[nx][ny] == 0 || visited[nx][ny] == true) continue;
				
				//그 외는 정상 
				Q.offer(new Point(nx, ny));
				visited[nx][ny] = true;
				A[nx][ny] = A[cur.x][cur.y]+1;//직전 거리의 +1값으로 갱신 
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		A = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				A[i][j]= kb.nextInt();
			}
		}
		
		BFS(0,0);//호출하면 A갱신되니까
		System.out.println(A[n-1][m-1]);//n,m 좌표 출력 
	}

}
