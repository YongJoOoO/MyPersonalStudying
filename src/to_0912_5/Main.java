package to_0912_5;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*22116번. 창영이와 퇴근 - 다익스트라 문풀 */
public class Main {
	static int N;
	static int[][] map;
	static int[][] cost;//최소 절댓값 경사 사용하여 갈 거임 
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		map = new int[N][N];
		cost = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = kb.nextInt();//입력받고 
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				cost[i][j] = Integer.MAX_VALUE;
			}
		}
		
		//시작점은 
		cost[0][0] = 0;//이렇게 세팅 
		//적은 가중치 우선으로 할 거라서 
		PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2]-b[2]);
	
		pQ.offer(new int[] {0, 0, 0});//자기 자신에 대한 가중치도 0이다.
		int max = Integer.MIN_VALUE;//최소값으로 세팅해놓은 다음에 
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			//뽑은 애 가중치가 기존의 cost 비용보다 클 경우에는 X
			if(cost[cur[0]][cur[1]] < cur[2]) continue;
			
			if(cur[0]==N-1 && cur[1] == N-1) break;
			for(int k =0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx <0 || ny <0 || nx >= N || ny>= N) continue;
				//기존 값이 직전값 
				if(cost[nx][ny] >  cost[cur[0]][cur[1]] + Math.abs(map[cur[0]][cur[1]] - map[nx][ny])) {//최단 거리로 세팅해놓고 
					cost[nx][ny] = cost[cur[0]][cur[1]] + Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
					
					max = Math.max(max, Math.abs(map[cur[0]][cur[1]] - map[nx][ny]));//그 경사 차이 가중치 중 최대값을 얻어와서 
					
					pQ.offer(new int[] {nx, ny, cost[nx][ny]});
				}
			}
		}
		System.out.println(max);
	
	}

}
