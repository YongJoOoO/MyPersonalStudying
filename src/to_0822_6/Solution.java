package to_0822_6;
//다익스트라 - 방향 바꾸기 RE 풀이 
import java.util.*;
class Solution {
	static int N, M;
	static int[][] cost;
	static PriorityQueue<int[]> pQ;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};	
	
	//솔루션 함수 
    public int solution(int[][] board) {
    	
    	N = board.length;
    	M = board[0].length;
    	
    	cost = new int[N][M];
    	//가중치 오름차순 즉 작은 가중치 우선 정렬 
    	pQ = new PriorityQueue<>((a, b) -> a[2]-b[2]);
    	//무한대로 비용 초기화
    	for(int i=0 ; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
    	
    	//시작점 세팅
    	cost[0][0] = 0;
    	pQ.add(new int[] {0,0, 0});
    	
    	while(!pQ.isEmpty()) {
    		int[] cur = pQ.poll();
    		int dir = board[cur[0]][cur[1]] -1;//이게 방향 좌표지칭
    		//현재 뽑은 가중치가 기존 비용보다도 클 경우에는 탐색 안하고 넘어감 
    		if(cur[2] > cost[cur[0]][cur[1]]) continue;
    		
    		for(int k=0; k<4; k++) {
    			int nx = cur[0] + dx[k];
    			int ny= cur[1] + dy[k];
    			if(nx <0 || ny<0 ||nx>=N || ny >=M) continue;
    			//방향이 같으면서 현재 비용이 더 작을 경우 갠신 
    			if(dir == k && cur[2] < cost[nx][ny]) {
    				cost[nx][ny] = cur[2];
    				pQ.offer(new int[] {nx, ny, cur[2]});
    			}else if(dir != k && cur[2] +1 <cost[nx][ny]) {
    				cost[nx][ny] = cur[2]+1;
    				pQ.offer(new int[] {nx, ny, cur[2]+1});
    			}
    		}
    	}
    	return cost[N-1][M-1];
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
		System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
		System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
		System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
		System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
	}
}