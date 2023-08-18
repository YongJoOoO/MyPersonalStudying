package to_0818_A;
import java.util.*;
class Solution {
	public int solution(int[][] board){
		int answer = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int n = board.length;
		int[][] dist = new int[n][n];
		Queue<int[]> Q = new LinkedList<>();
		//모든 빌딩이 거치는 빌딩만 탐색하도록 변수를 선언한 것이다. 
		int emptyLand = 0; //각 빌딩에 대하여 출발하여 방문한 값 처리한 뒤 board값도 --처리
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(board[i][j] == 1){
					answer = Integer.MAX_VALUE;
					Q.offer(new int[]{i, j});
					int L = 0; 
					while(!Q.isEmpty()){
						L++;
						int len = Q.size();	
						for(int r = 0; r < len; r++){
							int[] cur = Q.poll();
							for(int k = 0; k < 4; k++){
								int nx = cur[0] + dx[k];
								int ny = cur[1] + dy[k];
								if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand){
									board[nx][ny]--;
									dist[nx][ny] += L;
									Q.offer(new int[]{nx, ny});
									answer = Math.min(answer, dist[nx][ny]);
								}
							}
						}
					}
					emptyLand--;
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