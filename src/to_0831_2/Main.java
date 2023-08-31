package to_0831_2;

import java.util.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*4485번. 녹색 옷 입은 애가 젤다지 ? */
public class Main {
	static int N;
	static int[][] board;
	static int[][] cost;//최소 비용으로 가기
	//4방향
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		while(true) {
			N = kb.nextInt();
			if(N == 0) break; //0입력 시 걍 종료 
		
			board = new int[N][N];
			cost = new int[N][N];
			//최초 cost는 맥스로 초기화 
			for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
			
			//데이터 입력받기 
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					board[i][j] = kb.nextInt();
				}
			}
			
			//다익스트라 시작 
			//시작점 초기화 
			cost[0][0] = board[0][0];//그래도 값 가짐
			//pQ에 담을때 (x, y, 가중치) 로 담을 거임 
			//자동 가중치 우선 순위 
			PriorityQueue<int[]> pQ = new PriorityQueue<>((a,b)-> a[2]-b[2]);
			pQ.offer(new int[] {0, 0, board[0][0]});
			
			while(!pQ.isEmpty()) {
				int[] cur = pQ.poll();
				//만약 기존 cost보다 cur[2]가중치가 더 클 경우 로직 건너뜀
				if(cur[2] > cost[cur[0]][cur[1]]) continue;
				
				for(int k =0; k<4; k++) { //현 정점에서 4방향으로 뻗어갈 거임
					int nx = cur[0] + dx[k];
					int ny = cur[1] + dy[k];
					if(nx <0 || ny <0 || nx >= N || ny >= N) continue;
					
					if(cost[nx][ny] > cost[cur[0]][cur[1]] + board[nx][ny]) {
						//다음 cost 값이 > 현재 정점 cost 에 다음 정점가중치 값 더한 거 보다 큰 경우 
						//작은 값으로 갱신할 거임 
						cost[nx][ny] = cost[cur[0]][cur[1]] + board[nx][ny]; //갱신 처리 
						pQ.offer(new int[] {nx, ny, cost[nx][ny]});//갱신된 거리로 pQ에 담을 거
					}
				}
			}
			answer.add(cost[N-1][N-1]);//마지막 거리값 답에 담기 
		}
		
		
		//정답 출력 
		for(int i=0; i<answer.size(); i++) {
			System.out.println("Problem "+ (i+1) + ": " + answer.get(i));
		}		
	}
}