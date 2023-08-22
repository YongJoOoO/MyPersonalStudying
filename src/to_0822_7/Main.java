package to_0822_7;

import java.util.*;

/*2655번. 미로 만들기 - 다익스트라 */
public class Main {
	static int N;
	static int[][] cost;
	static int[][] board;
	static PriorityQueue<int[]> pQ;
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		//초기화
		board = new int[N][N];
		cost = new int[N][N];
		//가중치 오름차순 정렬 
		pQ = new PriorityQueue<>((a,b)-> a[2] - b[2]);
		
		//데이터 입력받기 
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<N; j++) {
				board[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
		}
		
		//이 상태에서 cost max 초기화
		for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
		
		//시작값 세팅 
		cost[0][0] = 0;
		pQ.add(new int[] {0, 0, 0});
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			
			//현재 가려고 하는 정점의 가중치가 기존 cost 보다 큰 경우에는 탐색할 필요 X 넘어감 
			if(cost[cur[0]][cur[1]] < cur[2]) continue;
			
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx <0 || ny<0 || nx >=N || ny>= N ) continue;
				
				//똑같이 nx가 흰방 && 이거로 갔을 때 기존 가중치보다 더 작을 경우 갱신
				if(board[nx][ny] == 1 && cost[nx][ny] > cur[2]) {
					cost[nx][ny] = cur[2];
					pQ.offer(new int[] {nx, ny, cur[2]});
				}
				//nx 정점이 검은 방 && 거기로 갔을 때 기존 가중치보다 더 작게 만들 수 있으면 갱신 
				else if(board[nx][ny] == 0 && cost[nx][ny] > cur[2] + 1) {
					cost[nx][ny] = cur[2] + 1;
					pQ.offer(new int[] {nx, ny, cur[2] + 1});
				}
			}
		}		
		//정답은 n-1, n-1에 저장된 cost 가중치 값
		System.out.println(cost[N-1][N-1]);
	}
}