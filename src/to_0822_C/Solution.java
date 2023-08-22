package to_0822_C;
import java.util.*;
class Solution {
	public int solution(int[][] board, int[] s, int[] e){
		int n = board.length;
		int m = board[0].length;
		int[][] cost = new int[n][m];
		for(int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    	pq.add(new int[]{s[0], s[1], 0});
    	cost[s[0]][s[1]] = 0;
        	
    	while(!pq.isEmpty()) {
           int[] cur = pq.poll();
           if(cur[2] > cost[cur[0]][cur[1]]) continue;
           //방향을 4방향으로 가긴 할거임 
           for(int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}){
            	int nx = cur[0];
            	int ny = cur[1];
            	int len = cur[2]; //초기화
            	//while문 돌면서 : 벽인 1이 나오기 전까지 값이 0이면서 범위 벗어나지 않는 동안 갈 수 있는 매끄러운 길이 len++ 처리하며 이동 
            	while(nx>= 0 && nx < n&& ny >= 0 && ny < m && board[nx][ny] == 0){
                	nx += dir[0]; //이동
               	 	ny += dir[1];//이동 
                	len ++;//길이++
            	}
            	//1 만나거나 범위 벗어나서 탈출 : 벽 만남
            	//1인 벽을 만나서 1개씩 직전으로 빼줌  
            	nx -= dir[0]; //직전 x --
            	ny -= dir[1]; //직전 y --
            	len --; //직전 길이 --
            	
            	//이제 이 지점까지의 len길이가 기존의 cost 비용보다 작을 경우 값 갱신처리 
            	if(cost[nx][ny] > len){
					 cost[nx][ny] = len;
                	 pq.add(new int[]{nx, ny, len});
           	    }
       	    }
    	}
    	//여전히 그대로 max값일 경우 -1
		if(cost[e[0]][e[1]] == Integer.MAX_VALUE) return -1;
	    //아닌 경우 비용 반환
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

