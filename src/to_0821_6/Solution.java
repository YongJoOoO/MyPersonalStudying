package to_0821_6;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
/*다익스트라로 풀기 one - to - one */
class Solution {
	static int N, M;
	static boolean[][] visited;
	static PriorityQueue<int[]> pQ = new PriorityQueue<>();
	static int[][] cost;//비용 담기 
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//solution 함수 
    public int solution(int[][] board) {
    	
    	N = board.length;
    	M = board[0].length;
    	visited= new boolean[N][M];
    	cost = new int[N][M];
    	//초기 비용 무한대로 채우기
    	for(int i=0; i<N; i++) { //각 i행에 대한 값 처리 
    		Arrays.fill(cost[i], Integer.MAX_VALUE);
    	}
    	
    	PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2]-b[2]);
    	//시작점 초기화
    	cost[0][0] = 0;
    	pQ.add(new int[] {0, 0, 0}); //0,0까지의 가중치 0
    	
    	while(!pQ.isEmpty()){
    		int[] cur = pQ.poll();
    		//cur[0]행 cur[1]열의 가중치 cur[2] 에 있다. 
    		if(cur[2] > cost[cur[0]][cur[1]]) continue;
    		
    		for(int k=0; k<4; k++) {
    			int nx = cur[0] + dx[k];
    			int ny = cur[1] + dy[k];
    			if(nx <0 || ny<0 || nx >=N || ny >= M) continue;
    			//만약 0으로 통로이면서 현재 cur[2]거쳐 가는 비용이 기존 비용보다 더 작을 경우 갱신 
    			if(board[nx][ny] == 0 && cost[nx][ny] > cur[2]) {
    				cost[nx][ny] = cur[2];
    				pQ.offer(new int[] {nx, ny, cur[2]});
    			}
    			else if(board[nx][ny] == 1 && cost[nx][ny] > cur[2] + 1) {//1인 경우 가중치 1 더하기 
    				cost[nx][ny] = cur[2] + 1;
    				pQ.offer(new int[] {nx, ny, cur[2]+1});
    			}
    		}
    	}
    	//최종 도착지점 리턴 
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