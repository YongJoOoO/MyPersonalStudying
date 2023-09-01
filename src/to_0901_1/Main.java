package to_0901_1;

import java.util.*;

/*9505번. 엔터프라이즈호 탈출 - 다익스트라 문풀 */

class ClingOn implements Comparable<ClingOn> {
	String name;
	int time;

	ClingOn(String name, int time) {
		this.name = name;
		this.time = time;
	}

	@Override
	public int compareTo(ClingOn o) {
		// TODO Auto-generated method stub
		return this.time - o.time;// 시간 적은 거 우선
	}
}

public class Main {

	static int TC, K, W, H;
	static int[][] board;
	static int[][] cost;
	static final int INF = Integer.MAX_VALUE;
	// 4방향
	static int[] dx = {};
	static int[] dy = {};

	// cost 비용 초기화
	static void init() { // 모두 INF 값으로
		cost = new int[H][W];
		for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j)
				cost[i][j] = INF;
		}
	}

	// 다익스트라 함수로 우선 풀기
	static int dijkstra(int x, int y) {
		init(); // 무한대값으로 초기화
		PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
		cost[x][y] = 0;// 시작점은 0 처리
		pQ.offer(new int[] { x, y, 0 }); // 좌표와 가중치
		ArrayList<Integer> answer = new ArrayList<>();
		while (!pQ.isEmpty()) {
			int[] cur = pQ.poll();// 시작점
			if (cost[cur[0]][cur[1]] < cur[2])
				continue;// 넘어감

			if (cur[0] == 0 || cur[0] == H - 1 || cur[1] == 0 || cur[1] == W - 1) {
				pQ.clear();
				return cur[2];
			}

			for (int k = 0; k < 4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if (nx < 0 || ny < 0 || nx >= H || ny >= W)
					continue;
				// 다음 정점의 거리가 크다면 (현재 좌표에 그 가중치 더한 값보다)
				if (cost[nx][ny] > cost[cur[0]][cur[1]] + board[nx][ny]) {
					cost[nx][ny] = cost[cur[0]][cur[1]] + board[nx][ny];

					pQ.offer(new int[] { nx, ny, cost[nx][ny] });
				}
			}
		}

		return 0;
	}

	// 실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		TC = kb.nextInt();

		for (int t = 0; t < TC; t++) { // 테스트케이스별 조지기
			K = kb.nextInt();
			W = kb.nextInt();
			H = kb.nextInt();

			// 초기화
			board = new int[H][W];// H행 W열
			cost = new int[H][W];

			// K줄에 정보 뜰거야
			ArrayList<ClingOn> arr = new ArrayList<>();
			// 이름과 시간 객체로 담고
			for (int i = 0; i < K; i++) {
				String s = kb.next();
				int val = kb.nextInt();
				arr.add(new ClingOn(s, val));// 객체에 차례로 담기
			}

			// 임시 배열 담아놓고
			char[][] tmp = new char[H][W];

			for (int i = 0; i < H; i++) {
				String s = kb.next();
				for (int j = 0; j < W; j++) {
					tmp[i][j] = s.charAt(j);
				}
			}
			// 숫자 배열로 옮길 것 !
			int st_x = 0;
			int st_y = 0;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {

					for (ClingOn x : arr) {// 내가 String 객체로 변경했기 때문에 값 == 조건은 eqauls로 해줄 것 !!!!!
						if (x.name.equals(String.valueOf(tmp[i][j]))) {
							// 같다면
							board[i][j] = x.time;// 그 시간을 담아줌 . 그리고 E는 없기 때문에 자동 0 이 들어갈거임
						} else if (x.name.equals("E")) { // 츨발점
							st_x = i;
							st_y = j;
						}
					}
				}
			}

			
		}

	}

}
