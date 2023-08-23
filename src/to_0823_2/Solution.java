package to_0823_2;
//공굴리기 
import java.util.*;
class Solution {
	static int N, M;
	static int[][] cost;//비용 담기
	static PriorityQueue<int[]>	pQ;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//솔루션 함수 
	public int solution(int[][] board, int[] s, int[] e){
		N = board.length;
		M = board[0].length;
		
		//초기화
		cost = new int[N][M];
		pQ = new PriorityQueue<>((a, b)-> a[2]-b[2]);//가중치 오름차순 
		
		//비용 max로 초기화
		for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
		
		//시작점 초기화
		cost[s[0]][s[1]] = 0;
		pQ.add(new int[] {s[0], s[1], 0});
		
		
		while(!pQ.isEmpty()) {		
			int[] cur = pQ.poll();
			if(cur[2] > cost[cur[0]][cur[1]]) continue;
			 for(int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}){
	            	//시작 좌표 초기화
				 	int nx = cur[0];
	            	int ny = cur[1];
	            	int len = cur[2]; //초기화
	            	//while문 돌면서 : 벽인 1이 나오기 전까지 값이 0이면서 범위 벗어나지 않는 동안 갈 수 있는 매끄러운 길이 len++ 처리하며 이동 
	            	while(nx>= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0){
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
	                	 pQ.add(new int[]{nx, ny, len});
	           	    }
	       	    }
		}
		if(cost[e[0]][e[1]] == Integer.MAX_VALUE) return -1;
		else return cost[e[0]][e[1]];
   	}
	
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
		System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
		System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
		System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
		System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
	}
}

