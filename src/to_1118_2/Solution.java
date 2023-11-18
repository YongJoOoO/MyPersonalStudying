package to_1118_2;
import java.util.*;
/**
 * 벽 허물기 
 * @author MYLG
 *
 */
class Solution {
	static int N, M;
	static int[][] cost;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static PriorityQueue<int[]> pQ;
	
    public int solution(int[][] board) {
        
    	N = board.length;
    	M = board[0].length;
    	
    	cost = new int[N][M];
    	pQ = new PriorityQueue<>((a, b)-> a[2]- b[2]);//가중치 작은 애 우선
    	
    	for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
    	
    	//시작점 초기화
    	cost[0][0] = 0;//시작점 0,0에서의 벽은 0개 부숨
    	pQ.offer(new int[] {0, 0, 0});
    	
    	while(!pQ.isEmpty()) {
    		int[] cur = pQ.poll();
    		//가중치가 기존값보다 틀 경우 넘어감 
    		if(cur[2] > cost[cur[0]][cur[1]]) continue;
    		
    		for(int k=0; k<4; k++) {
    			int nx = cur[0] + dx[k];
    			int ny = cur[1] + dy[k];
    			if(nx <0 || ny <0 || nx>=N || ny>=M) continue;
    			
    			//0이면서 기존 cost보다 더 작은 cur[2] 가중치 가질 경우==그대로 갱신 
    			if(board[nx][ny] == 0 && cur[2] < cost[nx][ny]) {
    				//0이면서 기존 cost보다 더 작은 cur[2]일 경우 갱신
    				cost[nx][ny] = cur[2];//그대로 가져감
    				pQ.offer(new int[] {nx, ny, cost[nx][ny]});
    			}
    			if(board[nx][ny] == 1 && cur[2] + 1 < cost[nx][ny]) {
    				//1개 더 부신 가중치값이 되려 더 작다면 
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