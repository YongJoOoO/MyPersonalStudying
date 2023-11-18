package to_1118_8;
/**
 * 공 굴리기 다시 풀기 
 */
import java.util.*;
class Solution {
	
	static int N, M;
	static int[][] cost;// 다익스트라임 
	static PriorityQueue<int[]> pQ;
	
	//솔루션 함수 
	public int solution(int[][] board, int[] s, int[] e){
		
		N = board.length;
		M = board[0].length;
		
		cost = new int[N][M];
		for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
		
		pQ = new PriorityQueue<>((a, b)-> a[2]- b[2]);
		
		//시작점들처리  
		cost[s[0]][e[0]] = 0;
		pQ.offer(new int[] { s[0], s[1], 0});
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			if(cur[2]> cost[cur[0]][cur[1]]) continue;
			
			for(int [] dir : new int[][] {{-1,0},{0, 1}, {1, 0}, {0, -1} }) { 
				int nx = cur[0];
				int ny = cur[1];
				int len = cur[2];
				
				while(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] ==0) {
					nx += dir[0];
					ny += dir[1];
					len++;
				}
				nx -= dir[0];
				ny -= dir[1];
				len --;
				if(cost[nx][ny] > len) {
					cost[nx][ny] = len;
					pQ.offer(new int[] {nx, ny, len});
				}
			}
		}
		if(cost[e[0]][e[1]] == Integer.MAX_VALUE) return -1;
    	else return cost[e[0]][e[1]];
   	}
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
		System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
		System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
		System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
		System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
	}
}

