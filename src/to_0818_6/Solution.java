package to_0818_6;
import java.util.*;
class Solution {
	static int len;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//BFS
	static void BFS(int x, int y, int[][] board) {
		
	}
	//솔루션 
	public int solution(int[][] board){
	
		int x = 0;
		int y = 0;
		int cnt = 0;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] == 1) {
					x += i;
					y += j;
					cnt++;
				}
			}
		}
		len = board.length;
		visited = new boolean[len][len];
		dist = new int[len][len];//거리용 
		//우리가 탐색을 시작할 중앙 좌표는 
		System.out.print(x+" , " + y+ " ");
		
		x = x/cnt; //1의 개수만큼 나누기 
		y = y/cnt;
		
		System.out.print(x+" , " + y+ " ");
		
		
		
		return -1;
	}
		
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
		System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
		System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
	}
}