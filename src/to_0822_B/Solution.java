package to_0822_B;
//공 굴리기 문풀 
import java.util.*;
class Solution {
	static int N, M;
	static int[][] distance;
	static PriorityQueue<int[]> pQ;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//솔루션 함수 
	public int solution(int[][] board, int[] s, int[] e){
		//초기화
		N = board.length;
		M = board[0].length;
		
		distance= new int[N][M];
		//가중치 적은 애 우선 정렬 
		pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		//거리 배열 초기는 무한대로 
		for(int i=0; i<N; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
		
		//시작점 세팅 
		distance[s[0]][s[1]] = 0;//자기 자신에 대한 거리는 0 
		pQ.add(new int[] {s[0], s[1], 0});
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			if(cur[2] > distance[cur[0]][cur[1]]) continue;
			
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k] ;
				int ny = cur[1] + dy[k];
				//격자 범위 벗어나거나 값이 1인 벽일 경우 근야 넘엄감 
				if(nx <0 || ny <0 || nx >= N || ny >= M || board[nx][ny]==1) continue;
				
				if(board[nx][ny] == 0 && distance[nx][ny] > cur[2] + 1) { //이번에는 무조건 직전 + 1 처리 하면서 나아가야 됨 거리 ++이니까 
					distance[nx][ny] = cur[2]+1;
					pQ.add(new int[] {nx, ny, cur[2]+1});
				}
			}
		}
		
		//만약 닿지 못할 경우 -1 
		if(distance[e[0]][e[1]] == Integer.MAX_VALUE) return -1;
	
		return distance[e[0]][e[1]];
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

