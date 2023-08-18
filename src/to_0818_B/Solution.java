package to_0818_B;
//집을 짓자 - RE 다시 풀기 
import java.util.*;
class Solution {
	public int solution(int[][] board){
		
		int N = board.length;
		int[][]dist = new int[N][N];
		//4방향
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		int emptyLand = 0;//최초
		//1) 1인 빌딩 출발점으로 삼기 위해 큐에 담기 
		Queue<int[]> Q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j =0; j<N; j++) {
				if(board[i][j]==1) {
					Q.offer(new int[] {i, j});
					int lv = 0;
					while(!Q.isEmpty()) {
						lv++; //거리 처리
						int len = Q.size();
						for(int r =0; r<len ; r++) {
							int[] cur = Q.poll();
							for(int k=0; k<4; k++) {
								int nx = cur[0] + dx[k];
								int ny = cur[1] + dy[k];
								if(nx <0 || ny<0 || nx >=N || ny>=N) continue;
								
								if(board[nx][ny]==emptyLand) {
									//닿은 부분은 중복으로 다음에도 닿아야 하기 때문에
									board[nx][ny]--;//처리하고
									Q.add(new int[] {nx, ny});
									dist[nx][ny] += lv;
								}
							}
						}
					}
					emptyLand--;//각 빌딩 1에 대하여 모두 순회하고 중복순회해야하기 때문에 그 기준값도 처리
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		//정답 처리 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j] == emptyLand) {
					answer = Math.min(answer, dist[i][j]);//거기에 누적된 거리합
				}
			}
		}
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}
		
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
		System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
	}
}