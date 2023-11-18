package to_1118_5;
import java.util.*;
//방향 바꾸기 - 다익스트라 문풀 - 최소 벽 허물기도 다익스트라 (비슷한 유형임)
class Solution {
	//1(오), 2(왼), 3(아), 4(위)
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int N, M;
	static int[][] cost;
	static PriorityQueue<int[]> pQ;
	//솔루션 함수 
	public int solution(int[][] board){
		
		N = board.length;
		M = board[0].length;
		
		cost = new int[N][M];
		for(int i = 0; i < N; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		pQ = new PriorityQueue<>((a, b)-> a[2]-b[2]);//오름차순 가중치 
		
		cost[0][0] = 0;
		pQ.offer(new int[] {0, 0, 0});
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			int dir = board[cur[0]][cur[1]] - 1;//이게 해당 기준 방향임
			
			if(cur[2] > cost[cur[0]][cur[1]]) continue;
			
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				//1) 동일한 방향이면 cur[2]의 값 그대로 주면 됨 
				if(k == dir && cost[nx][ny] > cur[2]) {
					//같은 방향이면서 기존값이 더 큰 경우
					cost[nx][ny] = cur[2];
					pQ.offer(new int[] {nx, ny, cost[nx][ny]});
				}
				//2) 다른 방향이면 cur[2] + 1 값을 줘서 방향 한번 바꾼 처리해주기 
				else {
					if(cost[nx][ny]> cur[2] + 1) {
						cost[nx][ny] = cur[2] + 1;//그니까
						pQ.offer(new int[] {nx, ny, cost[nx][ny]});
					}
				}
			}
		}
		return cost[N-1][M-1];
   	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
		System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
		System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
		System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
		System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
	}
}