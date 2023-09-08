package to_0908_A;
/*미로의 최단거리 구하기 */
import java.util.*;
class Solution {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//BFS
	static int BFS(int[][] board, int x, int y) {
		
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {x, y});
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx <0 || ny <0 || nx >=7 || ny>=7) continue;
				if(board[nx][ny] == 0) {
					board[nx][ny] = board[cur[0]][cur[1]] + 1;
					Q.offer(new int[] {nx, ny});
				}
			}
		}
		
		if(board[6][6] == 0) return -1;
		
		return board[6][6];
	}
	//solution 
	public int solution(int[][] board){
		
		int answer = BFS(board, 0, 0);
		
		return answer;
	}
	//main
	public static void main(String[] args){
		Solution T = new Solution();
		int[][] arr={{0, 0, 0, 0, 0, 0, 0}, 
				{0, 1, 1, 1, 1, 1, 0}, 
				{0, 0, 0, 1, 0, 0, 0}, 
				{1, 1, 0, 1, 0, 1, 1}, 
				{1, 1, 0, 1, 0, 0, 0}, 
				{1, 0, 0, 0, 1, 0, 0}, 
				{1, 0, 1, 0, 0, 0, 0}};
		System.out.println(T.solution(arr));
	}
}