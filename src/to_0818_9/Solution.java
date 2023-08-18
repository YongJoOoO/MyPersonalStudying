package to_0818_9;
//집을 짓자  
import java.util.*;
class Solution {
	static int N;
	//4방향
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] dist;

	public int solution(int[][] board){
		int answer = 0;
		N = board.length;
		//각각의 1들에서 주변으로 가는 최단거리를 누적합 할거임 
		Queue<int[]>  Q = new LinkedList<>();
		dist = new int[N][N];
		int emptyLand = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j] == 1) {
					answer = Integer.MAX_VALUE;
					Q.add(new int[] {i, j}); //출발점으로 담음 
					int lv = 0;
					
					while(!Q.isEmpty()) {
						lv++;
						int len = Q.size();
						for(int k=0; k<len; k++) {
							int[] cur = Q.poll();
							for(int r = 0; r<4; r++) {
								int nx = cur[0] + dx[r];
								int ny = cur[1] + dy[r];
								
								if(nx<0 || ny <0 || nx >= N || ny >= N) continue;
								
								if(board[nx][ny] == emptyLand ) {
									board[nx][ny]--;//얘를 처리시켜야 동시에 접근한 애들거를 누적시킬수 있음
									Q.add(new int[] {nx, ny});
									dist[nx][ny] += lv;//누적 시킴
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