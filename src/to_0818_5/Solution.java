package to_0818_5;
import java.util.*;
/*집을 짓자 - BFS */
class Solution {
	static int len;
	static boolean[][] visited;
	static int[][] dist;
	//4방향 좌표
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//솔루션 함수 
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
		x = x/cnt; //1의 개수만큼 나누기 
		y = y/cnt;
		System.out.println("시작 좌표: " + x + ". " + y);
		//시작점은 x, y가 된다.
		Queue<int[]> Q = new LinkedList<>();
		
		if(board[x][y] != 2) {
			Q.add(new int[] {x, y});
			visited[x][y]= true;
		}
		int lv = 0;
		while(!Q.isEmpty()){
			lv++;
			int len= Q.size();
			for(int i=0; i<len; i++) {
				int[] cur = Q.poll();
				for(int j=0; j<4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					if(nx<0 || ny <0 || nx >=len || ny>=len || board[nx][ny] == 2) continue;
					
					if(!visited[nx][ny]) {
						Q.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						dist[nx][ny] += lv;
					}
				}
			}
		}

		
		
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