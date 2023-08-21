package to_0821_8;
import java.util.*;
//다익스트라로 벽 허물기 - RE
class Solution {
	//솔루션 함수 
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] cost = new int[n][m];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    	
        for(int i=0; i<n; i++) {
        	Arrays.fill(cost[i], Integer.MAX_VALUE);//최대값으로 초기화 
        }
        
        //시작점 초기화
        cost[0][0] = 0;//시작점
        pQ.add(new int[] {0, 0, 0});
        
        while(!pQ.isEmpty()) { //가중치 적은 애 우선으로 뽑음 
        	int[] cur = pQ.poll();
        	//cur[0]행 cur[1]열의 가중치는 cur[2] 이다. 
        	if(cur[2] > cost[cur[0]][cur[1]]) continue;
        	
        	for(int k=0; k<4; k++) {
        		int nx = cur[0] + dx[k];
        		int ny = cur[1] + dy[k];
        		if(nx <0 || ny<0 || nx>= n || ny>=m)continue;
        		//0이면서 기존 cost보다 더 작은 cur[2]가중치 나타난 경우 얘로 이동처리 
        		if(board[nx][ny] == 0 && cur[2] < cost[nx][ny]) {
        			cost[nx][ny] = cur[2];
        			pQ.add(new int[] {nx, ny, cur[2]});
        		}else if(board[nx][ny] == 1 && cur[2]+1 < cost[nx][ny]) {
        			cost[nx][ny]= cur[2]+1;
        			pQ.add(new int[] {nx, ny, cur[2]+1});
        		}
        	}
        }
        return cost[n-1][m-1];
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