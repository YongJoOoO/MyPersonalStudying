package to_0718_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*2178번. 미로 탐색 */
public class Main {
	//4방향 배열 
	static int dx[] = {0,0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	
	static int N, M;
	static boolean[][] visited; //방문 체크용 배열 
	static int[][] A;//원본 배열 
	
	//bfs
	static void bfs(int i, int j) {
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			//4방향으로 움직일 건데 
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx>=0 && ny >=0 && nx<N && ny<M) {
					if(A[nx][ny] !=0 && !visited[nx][ny]) {
						visited[nx][ny] =true;
						A[nx][ny] = A[cur[0]][cur[1]] + 1;
						Q.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//데이터 입력받기 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
			}
		}
		bfs(0, 0);//시작 0,0에서 하고 		
		//최종 
		System.out.println(A[N-1][M-1]);//0부터 시작해으니 마지막 배열에 최종 최솟값 담김 
	}
}