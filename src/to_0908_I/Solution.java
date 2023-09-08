package to_0908_I;
import java.util.Arrays;
import java.util.PriorityQueue;
/*벽 허물기 문풀ㅇㄴ*/
class Solution {
	static int[] dx = {0, 0 , 1, -1};
	static int[] dy = {1, -1, 0 ,0};
	//solution
    public int solution(int[][] board) {
    	
    	int n = board.length;
    	int m = board[0].length;
    	//dy[i][j]는 0,0에서 i,j까지 가는데 최소로 허문 벽의 개수 담는 배열이다. 
    	int[][] dp = new int[n][m];
    	
    	for(int i=0; i<n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
    	//PQ에 담아서 비용 작은 거 우선으로 가도록 
    	PriorityQueue<int[]> pQ= new PriorityQueue<>((a,b)-> a[2]-b[2]);

    	pQ.offer(new int[] {0, 0 , 0});
    	
    	while(!pQ.isEmpty()) {{
    		int[] cur = pQ.poll();
    		if(cur[2] > dp[cur[0]][cur[1]]) continue;
    		for(int k =0; k<4; k++) {
    			int nx = cur[0] + dx[k];
    			int ny = cur[1] + dy[k];
    			if(nx <0 || ny <0 || nx >=n || ny>=m) continue;
    			
    			//다음 정점이 0일때
    			if(board[nx][ny]==0 && dp[nx][ny] > cur[2]) { //직전 가중치보다 클 때 갱신 
    				dp[nx][ny] = cur[2];
    				pQ.offer(new int[] {nx, ny, dp[nx][ny]});
    			}
    			//다음 정점이 1일떄
    			else if (board[nx][ny] == 1 && dp[nx][ny] > cur[2]+1) {
    				dp[nx][ny] = cur[2]+1;
    				pQ.offer(new int[] {nx, ny, dp[nx][ny]});
    			}
    		}
    	}
    	
    }
		return dp[n-1][m-1];
    }
    //main
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));	
		System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));	
		System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));	
		System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
		System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));	
	}
}