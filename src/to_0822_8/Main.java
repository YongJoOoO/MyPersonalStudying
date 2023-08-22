package to_0822_8;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*1261번. 알고스팟 */
public class Main {
	static int N, M;
	static int[][] cost;
	static int[][] board;
	static PriorityQueue<int[]> pQ;
	//4방향 
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	//실행 메인 
	public static void main(String[] args){
		// TODO Auto-generated method stub

		Scanner kb= new Scanner(System.in);
		M = kb.nextInt();
		N = kb.nextInt();
		
		cost= new int[N][M];
		board = new int[N][M];
		//가중치 적은 값 우선 정렬 
		pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		//데이터 입력받기 
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<M; j++) {
				board[i][j]= Character.getNumericValue(tmp.charAt(j));
			}
		}
		//cost 비용 max로 세팅 
		for(int i=0; i<N; i++) Arrays.fill(cost[i], 10000);
		
		//시작점 초기화 
		cost[0][0] = 0;
		pQ.add(new int[] {0,0,0});
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			//만약 현재 가중치로 가는 게 기존 가중치보다 클 경우 탐색할 이유 
			
			//System.out.println(cur[0] + ", " + cur[1] +  " : "+ cur[2]);
			
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
								//여기서 nx >= N  ny >= M을 N으로 둬서 계속 오류였음
				if(nx<0 || ny <0 || nx >= N || ny >= M) continue;
				
				//1) 0으로는 그냥 갈 수 있다. 갱신 가능한가 ?
				if(board[nx][ny] == 0 && cur[2] < cost[nx][ny]) { //갱신 
					cost[nx][ny] = cur[2];
					pQ.add(new int[] {nx, ny, cur[2]});
				}
				//2) 1로는 부셔야 갈 수 있다. 더 적은 값으로 가능한가 ?
				else if(board[nx][ny] == 1 && cur[2] + 1 < cost[nx][ny]) {//갱신 
					cost[nx][ny] = cur[2] + 1;
					pQ.add(new int[] {nx, ny, cur[2]+1});
				}
			}
		}
		
		System.out.println(cost[N-1][M-1]);
	}
}