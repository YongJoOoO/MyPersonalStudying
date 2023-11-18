package to_1118_3;
import java.util.*;
class Solution {
	static int N, M;
	static int[][] cost;
	static PriorityQueue<int[]> pQ;
	//4방향
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

    public int solution(int[][] board) {
     
    	N = board.length;
    	M = board[0].length;
    	
    	cost = new int[N][M];
    	for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
    	
    	cost[0][0] = 0;//얘도 초기화
    	pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);//2의 값 기준 오름찻누 정렬 
    	
    	//시작점 처리 
    	pQ.offer(new int[] {0, 0, 0});//0,0에서의 가중치 0으로 시작 
    	
    	while(!pQ.isEmpty()) {
    		int[] cur = pQ.poll();
    		//cur[2]가 갱신될cost비용보다 크다면 그냥 넘어감 
    		if(cur[2] > cost[cur[0]][cur[1]]) continue;
    		
    		for(int k=0; k<4; k++) {
    			int nx = cur[0] + dx[k];
    			int ny = cur[1] + dy[k];
    			
    			if(nx < 0 || ny <0 || nx >= N || ny >= M) continue;
    			//0은 통로라서 그대로 감 
    			if(board[nx][ny] == 0 && cur[2] < cost[nx][ny]) {
    				//기존 cost보다 더 작은 cur[2]가 존재한다면. 이 값을 사용함
    				cost[nx][ny] = cur[2];
    				pQ.offer(new int[] {nx, ny , cost[nx][ny]});
    			}
    			//1은 벽이라서 부시기 + 1 처리
    			if(board[nx][ny] == 1 && cur[2] + 1 < cost[nx][ny]) {
    				cost[nx][ny] = cur[2] + 1;
    				pQ.offer(new int[] {nx, ny, cost[nx][ny]});
    			}
    		}
    	}
    	return cost[N-1][M-1];
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));	
		System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));	
		System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));	
		System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
		System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));	
	}
}