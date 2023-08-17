package to_0817_3;
//미로탐색 
import java.util.*;
class Solution {
	static boolean[][] visited;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] dist;
	//BFS
	static void BFS(int x, int y, int[][] board) {
		Queue<int[]> Q = new LinkedList<>();
		visited[x][y] = true;
		Q.add(new int[] {x, y});
		int lv= 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i =0; i<len; i++) {
				int[] cur = Q.poll();
				for(int j=0; j<4; j++) {
					int nx = x + dx[i] ;
					int ny = y + dy[i];
					if(nx <0 || ny< 0 || nx >= 7 || ny >=7) continue;
					if(!visited[nx][ny] && board[nx][ny] == 0) {
						visited[nx][ny] = true;
						Q.add(new int[] {nx, ny});
						board[nx][ny] =  board[cur[0]][cur[1]] + 1;
					}
				}
			}
		}
	}
	
	//솔루션 함수 
	public int solution(int[][] board){
		
		//1.1 -> 7.7
		//0,0 
		visited = new boolean[7][7];
		dist = new int[7][7];
		
		BFS(0, 0, board);
		
		if(board[6][6] == 0) return -1;
		
		return board[6][6];
	}
		
	public static void main(String[] args){
		Solution T = new Solution();
		int[][] arr={{0, 0, 0, 0, 0, 0, 0}, 
					{ 0, 1, 1, 1, 1, 1, 0}, 
					{ 0, 0, 0, 1, 0, 0, 0}, 
					{ 1, 1, 0, 1, 0, 1, 1}, 
					{ 1, 1, 0, 1, 0, 0, 0}, 
					{ 1, 0, 0, 0, 1, 0, 0}, 
					{ 1, 0, 1, 0, 0, 0, 0}};
		System.out.println(T.solution(arr));
	}
}