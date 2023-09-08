package to_0908_5;

import java.util.Scanner;

/*10026번. 적록색약 문풀 */
public class Main {
	static int N;
	static int[][] map;//지도
	static boolean[][] visited;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//DFS
	static void DFS(int x, int y) {
		visited[x][y] = true;
		int tmp = map[x][y];//직전값과 같은 애한테만 갈 것 
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny <0 || nx >= N || ny>=N) continue;
			if(tmp == map[nx][ny] && !visited[nx][ny]) {
				DFS(nx, ny);//같을 때까지 갔다가 
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N =kb.nextInt();
		
		map = new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<N; j++) {
				if(tmp.charAt(j) == 'R') {
					map[i][j] = 1;
				}else if(tmp.charAt(j)=='G') {
					map[i][j] = 2;
				}else if(tmp.charAt(j)=='B') {
					map[i][j] = 3;
				}
			}
		}
		
		//호출 
		int ans1 = 0;
		int ans2 = 0;
		
		visited = new boolean[N][N];
		//정상인 눈으로 봤을 때는 다 구분해서 봄
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					DFS(i, j);
					ans1++;//호출 횟수 같은 구역으로만 뻗었다가 반환하니까.
				}
			}
		}
		
		visited = new boolean[N][N];
		//적녹색약이 본 걸로 다시 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if( map[i][j]==2) {
					map[i][j] = 1;//통일시킴
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0 ;j<N; j++) {
				if(!visited[i][j]) {
					DFS(i, j);
					ans2++;
				}
			}
		}
		
		System.out.println(ans1 + " "+ ans2);
		
	}

}
