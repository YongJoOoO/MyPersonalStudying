package to_0818_2;
//미로의 최단거리 통로 
import java.util.*;
class Solution {
	static int[][] dist;//거리용 
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public int solution(int[][] board){
		//초기화
		dist = new int[7][7];
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] {0, 0});//시작점 처리
		board[0][0] = 1;//방문체크 
		
		int lv= 0;
		while(!Q.isEmpty()){
			int len = Q.size();
			lv++;
			for(int i=0 ;i<len ;i++) {
				int[] cur = Q.poll();
				for(int j=0; j<4; j++) {
					//여기서 dx인덱스 찍을 때 변수 잘 보고 찍기
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					if(nx < 0 || ny <0 || nx >=7 || ny >=7) continue;
					if(board[nx][ny] == 0) {
						board[nx][ny] = 1;
						Q.add(new int[] {nx, ny});
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