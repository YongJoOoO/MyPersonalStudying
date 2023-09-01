package to_0901_7;

import java.util.*;

/*20046번. Road Reconstruction - 다익스트라 문풀 */
public class Main {
	static int N, M;
	static int[][] map;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//다익스트라 
	static int[][] dijkstra(int x, int y){
	
		int[][] distance = new int[N][M];
		for(int i=0; i<N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		PriorityQueue<int[]> pQ =new PriorityQueue<>((a, b) -> a[2] - b[2]);

		//시작점 처리 
		distance[x][y] = map[x][y];//자기 자신의 값으로 세팅 
		pQ.offer(new int[] {x, y, map[x][y]});
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			if(cur[2] > distance[cur[0]][cur[1]]) continue;//기존값보다 크면 건너뜀
			
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx <0 || ny <0 || nx >= N || ny >= M) continue;
				if(map[nx][ny] == -1) continue; //-1값 갖는 경우는 그냥 넘김 
				//0, 1, 2의 값만 갖는 경우에 한해서 
				if(distance[nx][ny] > distance[cur[0]][cur[1]] + map[nx][ny]) {
					distance[nx][ny] = distance[cur[0]][cur[1]] + map[nx][ny];
					pQ.offer(new int[] {nx, ny, distance[nx][ny]});
				}
			}
		}
		
		return distance;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		map = new int[N][M];
		
		//데이터 입력 받ㄱ ㅣ
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = kb.nextInt();
			}
		}
		//시작위치 or 도착 위치가 조차도 건설 불가능한 위치일 경우 
		if(map[0][0] == -1 || map[N-1][M-1] == -1) {
			System.out.println("-1");
		}else {
			int[][] dist = dijkstra(0, 0);
			
			if(dist[N-1][M-1] == Integer.MAX_VALUE) {
				System.out.println("-1");
			}else {
				System.out.println(dist[N-1][M-1]);
			}			
		}
	}
}