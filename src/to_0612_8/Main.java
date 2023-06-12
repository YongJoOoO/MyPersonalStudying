package to_0612_8;

import java.util.*;

/*유기농 배추 - DFS 풀이 */
public class Main {
	static int n, m;
	static int e;
	static int [][] arr;
	static boolean [][] visited;
	//방향 변수
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int answer;
	
	//DFS
	static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny<0 || nx >= m || ny >=n) continue;
			if(arr[nx][ny] == 0 || visited[nx][ny]== true) continue;
			
			//다음 분기로 방문 
			DFS(nx, ny);
		}
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int tc = kb.nextInt();
		
		for(int t=0; t<tc; t++) {
			//거꾸로 중요 
			m = kb.nextInt();//열 개수
			n = kb.nextInt();//행 개수
			e = kb.nextInt();//엣지 개수
			
			
			arr = new int[n][m];
			visited = new boolean[n][m];
			
			for(int i=0; i<e; i++) {
				int b = kb.nextInt();
				int a = kb.nextInt();
				//거꾸로 담기 
				arr[a][b] = 1;
			}
			answer = 0;
			//DFS 호출할 건데 
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						answer++;
						DFS(i,j);
					}
				}
			}
			
			//정답 출력 
			System.out.println(answer);
		}
	}

}
