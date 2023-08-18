package to_0818_8;
//숲속의 기사 문제 풀이 - BFS
import java.util.*;
class Solution {
	static int[][] dist;
	static int N, M;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//solution
	public int solution(int[][] board){
		int answer = Integer.MAX_VALUE;
		
		N = board.length;
		M = board[0].length;
		
		dist = new int[N][M];
		//2, 3 각각 출발해서 탐색한 거리를 서로 합친 4를 발견하면 그 중 최소값 
		
		Queue<int[]> Q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				//출발은 2, 3 각각에서 1 제외한 모든 지점을 탐색하는 식으로 
				if(board[i][j] == 2 || board[i][j] == 3) {
					Q.offer(new int[] {i, j});
					int[][] ch = new int[N][M];//체크용 배열 
					ch[i][j] = 1;
					int lv = 0;
					while(!Q.isEmpty()){
						lv++;
						int len = Q.size();
						for(int r = 0; r<len; r++) {
							int[] cur = Q.poll();
							for(int k =0; k<4; k++) {
								int nx = cur[0] + dx[k];
								int ny = cur[1] + dy[k];
								if(nx <0 || ny< 0 || nx >=N || ny>=M )continue;
								
								if(ch[nx][ny] == 0 && board[nx][ny] != 1) {
									Q.offer(new int[] {nx, ny});
									ch[nx][ny] = 1;
									dist[nx][ny] += lv;//각각 접근하는 모든 레벨에 대하여 누적 처리 
								}
							}
						}
					}
				}
			}
		}
		
		//정답 처리 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j] == 4 && dist[i][j] > 0) {
					answer = Math.min(answer, dist[i][j]);
				}
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 0, 1, 0, 0}, 
			{0, 2, 1, 1, 3, 0, 4, 0},
			{0, 0, 0, 4, 1, 1, 1, 0}}));
		System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4}, 
			{0, 1, 1, 0, 0, 0, 1, 0}, 
			{0, 1, 4, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 0, 1, 1, 0}, 
			{4, 0, 0, 0, 1, 0, 0, 0}, 
			{4, 1, 0, 0, 1, 0, 0, 0}, 
			{4, 0, 0, 0, 0, 0, 1, 2}}));
		System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0}, 
			{0, 1, 0, 1, 0}, 
			{0, 0, 2, 3, 4}, 
			{0, 1, 0, 1, 0}}));
	}
}