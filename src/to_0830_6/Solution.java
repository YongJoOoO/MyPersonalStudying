package to_0830_6;
import java.util.*;
//벽 허물기 
class Solution {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//솔루션 함수
    public int solution(int[][] board) {
        
    	int N = board.length;
    	int M = board[0].length;
    	//가중치 값 적은 거 우선 
    	PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2]-b[2]);
    	
    	int[][] cost = new int[N][M];//비용 저장용 
    	for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
    	
    	//시작값 초기화
    	cost[0][0] = 0;
    	pQ.offer(new int[] {0, 0 ,0 });//좌표, 가중치
    	
    	while(!pQ.isEmpty()) {
    		int[] cur = pQ.poll();
    		//기존좌표에 대한 cost 비용보다 더 큰 경우 넘어감 
    		if(cur[2] > cost[cur[0]][cur[1]]) continue;

    		for(int k=0; k<4; k++) {
    			int nx = cur[0] + dx[k];
    			int ny = cur[1] + dy[k];
    			if(nx <0 || ny <0 || nx >= N || ny>=M) continue;
    			//현재 좌표 다음 좌표가 0  = 통로 && 기존값보다 더 적은 cur[2] 존재한다면 
    			if(board[nx][ny] == 0 && cost[nx][ny] > cur[2] ) {
    				cost[nx][ny] = cur[2];
    				pQ.offer(new int[] {nx, ny, cost[nx][ny]});
    			}else if(board[nx][ny] == 1 && cost[nx][ny] > cur[2] + 1) {
    				cost[nx][ny] = cur[2]+1;
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