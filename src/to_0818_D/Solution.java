package to_0818_D;
//미로의 최단거리 통론 ok
import java.util.*;
class Solution {
	static int[][] dist;//거리배열
	static boolean[][] visited;//방문체크 
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public int solution(int[][] board){
		int N = board.length;
		dist = new int[N][N];
		visited= new boolean[N][N];
		
		//출발점 처리
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {0, 0});//0, 0 -> 6,6
		visited[0][0] =true;
		//레벨 탐색 
		int lv = 0;
		while(!Q.isEmpty()) {
			lv++;
			int len = Q.size();
			for(int i=0; i<len; i++) {
				int[] cur = Q.poll();
				for(int j=0; j<4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					if(nx <0 || ny <0 || nx >=7 || ny >=7) continue;
					if(!visited[nx][ny]&& board[nx][ny] == 0) {
						Q.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						dist[nx][ny] = lv;
					}
				}
			}
		}
		
		if(dist[6][6] > 0) return dist[6][6];
		
		return -1;
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