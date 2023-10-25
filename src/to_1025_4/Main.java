package to_1025_4;
import java.util.*;

public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N,M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] BeforeBoard = new int[N][M];
		int[][] AfterBoard = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				BeforeBoard[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				AfterBoard[i][j] = sc.nextInt();
			}
		}

		Here: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (BeforeBoard[i][j] != AfterBoard[i][j]) {
					BFS(new int[] { i, j }, BeforeBoard, AfterBoard[i][j]);
					break Here;
				}
			}
		}
		
		System.out.println(ValidCheck(BeforeBoard,AfterBoard));

	}

	public static void BFS(int[] start, int[][] BeforeBoard, int ChangedNum) {
		int BeforeNum = BeforeBoard[start[0]][start[1]];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(start);
		BeforeBoard[start[0]][start[1]] = ChangedNum;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && BeforeBoard[nx][ny] == BeforeNum) {
					q.add(new int[] {nx,ny});
					BeforeBoard[nx][ny] = ChangedNum;
				}
			}
		}
	}
	
	public static String ValidCheck(int[][] BeforeBoard,int[][]AfterBoard) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(BeforeBoard[i][j] != AfterBoard[i][j]) {
					return "NO";
				}
			}
		}
		return "YES";
	}

}