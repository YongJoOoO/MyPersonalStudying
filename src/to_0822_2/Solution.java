package to_0822_2;
import java.util.*;
//벽 허물기 - RE 
class Solution {
	static int N, M;
	static int[][] distance;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//솔루션 함수 
    public int solution(int[][] board) {
    	
    	N= board.length;
    	M=board[0].length;
    	distance = new int[N][M];
    	//d[0] 행 d[1]열 의 가중치 값은 d[2] 로 둔다. pQ로 가중치 오름차순 : 즉 작은 가중치 우선으로 정렬하도록 ㅎ나다. 여기서 가중치 = 1 제거 횟수 
    	PriorityQueue<int[]> pQ = new PriorityQueue<> ((a,b)-> a[2] - b[2]);
    	
    	//무한대값으로 초기화
    	for(int i=0; i<N; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
    	
    	//0,0으로 시작점 세팅 
    	distance[0][0] = 0;
    	pQ.add(new int[] {0, 0, 0});
    	
    	while(!pQ.isEmpty()) {
    		int[] cur = pQ.poll();
    		//즉 기존의 담긴 가중치 값보다 새로 담을 가중치가 큰 경우에는 그냥 넘김
    		if(distance[cur[0]][cur[1]] < cur[2]) continue;
    		
    		for(int k=0; k<4; k++) {//4방향으로 가면서 
    			int nx = cur[0] + dx[k];
    			int ny = cur[1] + dy[k];
    			if(nx <0 || ny <0 || nx >= N || ny >=M) continue;
    			
    			//0 이면서 더 작은 가중치 갱신 가능한 경우 
    			if(board[nx][ny] == 0 && cur[2] < distance[nx][ny]) {
    				distance[nx][ny] = cur[2];//현재 값을 그대로 가져가고
    				pQ.add(new int[] {nx, ny, cur[2]});
    			}
    			//1 이면서 더 작은 가중치 갱신 가능한 경우
    			else if(board[nx][ny] == 1 && cur[2] + 1 < distance[nx][ny]) {
    				distance[nx][ny] = cur[2] + 1;//1 뿌시기 때문에 증가 시키고 
    				pQ.add(new int[] {nx, ny, cur[2]+1});
    			}
    		}
    	}
        return distance[N-1][M-1]; 
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