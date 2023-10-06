package to_1006_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*14502번. 연구소 - DFS & BFS 문풀 */
public class Main {
	static int N, M;
	static int[][] map;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] virusMap;//얘는 BFS 할때마다 갱신될 용도긴 함
	//max
	static int max = Integer.MIN_VALUE;
	
	//DFS -> 벽 3개씩 세우기 
	static void DFS(int wall) {//시작 벽 개수 
		if(wall == 3) {
			//3개가 세워졌을 떄 
			BFS();///호출시킴 2 퍼뜨려야 하니까 
			return;//복귀
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {//0인 지점에서 
					map[i][j] = 1;
					DFS(wall+1);//벽 하나 세우고 깊이 탐색
					//돌아오면 초기화
					map[i][j] = 0;//0처리 
				}
			}
		}
	}
	
	
	//BFS -> 3개씩 세워질 때마다 BFS로 바이러스 퍼뜨리기 
	static void BFS() {
		Queue<int[]> Q = new LinkedList<>();
		virusMap = new int[N][M];//새롭게 2 뻗어가는 애들 만들거고 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				virusMap[i][j] = map[i][j];//복사시킨 뒤 
				if(virusMap[i][j] == 2) {
					//바이러스 존재하는 애들을 
					Q.offer(new int[] {i, j});
				}
			}
		}
		//1) 3개 세운 상태에서 2의 시작점이 뻗어갈 수 있는 곳까지 다 뻗어간 뒤에 
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx <0 || ny <0 || nx>=N || ny>=M )continue;
				
				if(virusMap[nx][ny] == 0) { //닿을 수 있는 0인 지점을 모두 뻗어감 
					//바이러스로 뻗어갈 수 있는 곳까지 뻗어감 
					virusMap[nx][ny] = 2;
					Q.offer(new int[] {nx, ny});
				}
			}
		}
		
		//2) 그럼에도 여전히 0으로 남아있는 영역을 max로 갱신시키면 됨 
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virusMap[i][j] == 0) {
					//남아있는 0의 영역에 대하여 
					cnt++;
				}
			}
		}
		//max값을 갱신
		max = Math.max(max, cnt);//더 큰 값으로 
		
	}
	
	//실행 메인 
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		
		DFS(0);
		System.out.println(max);
	}
}