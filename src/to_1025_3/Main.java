package to_1025_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 22352번. 항체 인식 - DFS, BFS 문풀  
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static int[][] Before;
	static int[][] After;
	//4방향 상,하,좌,우
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1 ,0 ,0};
	
	//BFS
	static void BFS(int x, int y) {
		int changeNum = After[x][y];//현재값으로 모두 바꿔줄 거임 //시작값
		int targetNum = Before[x][y];//현재값
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {x, y});
		Before[x][y] = changeNum;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx <0 || ny <0 || nx >= N || ny >= M ) continue;
				if(Before[nx][ny] == targetNum) {
					//바꿀 대상 번호는
					Q.offer(new int[] {nx, ny});
					Before[nx][ny] = changeNum;//변경
				}
			}
		}
	}
	
	static boolean isValid() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(Before[i][j] != After[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		Before = new int[N][M];
		After = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				Before[i][j] = kb.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				After[i][j] = kb.nextInt();
			}
		}
		
		//여기서 이제 Before과 After 지점이 다른 곳을 찾기 
		Here: for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(Before[i][j] != After[i][j]) {
					BFS(i, j);
					break Here;
				}
			}
		}
		
		if(isValid()) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}		
	}
}