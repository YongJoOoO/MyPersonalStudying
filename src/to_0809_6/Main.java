package to_0809_6;

import java.util.Scanner;

/*14716번. 현수막 */
public class Main {
	static int N, M;
	static int[][] A;
	//8방향 
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	//DFS
	static void DFS(int x, int y) {
		
		for(int i=0; i<8; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || A[nx][ny] != 1) continue;
			DFS(nx, ny);
		}
	}

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		A = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				A[i][j] = kb.nextInt();
			}
		}
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j] == 1) {
					DFS(i, j);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}
