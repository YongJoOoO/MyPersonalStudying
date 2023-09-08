package to_0908_B;
import java.util.*;
class Solution {
	public int solution(int[][] board){
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		Queue<int[]> Q = new LinkedList<>();

		Q.offer(new int[]{0, 0});
		int lv = 0;
		while(!Q.isEmpty()) {
			//레벨 탐색도 가능 
			lv++;
			int len = Q.size();
			for(int i=0; i<len; i++) {
				int[] cur = Q.poll();
				for(int k=0; k<4; k++) {
					int nx = cur[0] + dx[k];
					int ny = cur[1] + dy[k];
					if(nx <0 || ny <0 || nx >= 7 || ny>=7) continue;
					if(board[nx][ny] == 0) {
						board[nx][ny] =lv;
						Q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		if(board[6][6]==0) return -1;
		else return board[6][6];
	}
		
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