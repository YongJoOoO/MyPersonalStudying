package to_0822_5;
//방향 바꾸기 - 다익스트라로 풀 것 
import java.util.*;
class Solution {
	static int N, M;
	static int[][] cost;
	static PriorityQueue<int[]> pQ;
	//4방향 1 : 오른쪽, 2: 왼쪽, 3: 아래 4:위
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//솔루션 함수 
    public int solution(int[][] board) {
        //초기화 
    	N = board.length;
    	M = board[0].length;
    	
    	cost = new int[N][M];
    	pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    	
    	//cost 최소 구해야 하니 MAX로 초기화
    	for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
    	
    	//시작점 세팅 
    	cost[0][0] = 0; //출발
    	pQ.add(new int[] {0, 0, 0});
    	
    	while(!pQ.isEmpty()) {
    		//board값이 방향 좌표임
    		int[] cur = pQ.poll();
    		int dir = board[cur[0]][cur[1]] - 1;
    		//현재 가중치가 기존 비용보다 더클 경우 그냥 탐샘ㄱX
    		if(cur[2] > cost[cur[0]][cur[1]]) continue;
    		
    		for(int k=0; k<4; k++) {//얘가 dir과 같을 떄
    			int nx = cur[0] + dx[k];
    			int ny = cur[1] + dy[k];
    			
    			if(nx <0 || ny<0 || nx>=N || ny>=M) continue;
    			//방향이 같으면서 비용이 기존보다 더 작아지게 만들 수 있다면 
    			if(k == dir && cost[nx][ny] > cur[2]) {
    				cost[nx][ny] = cur[2];
    				pQ.add(new int[] {nx, ny, cur[2]});
    			}
    			//방향은 다르며서 비용+1 한 값이 기존 값보다는 작을 경우 갱신 
    			else if(k != dir && cost[nx][ny] > cur[2]+1) {
    				cost[nx][ny] = cur[2]+1;
    				pQ.add(new int[] {nx, ny, cur[2]+1});
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