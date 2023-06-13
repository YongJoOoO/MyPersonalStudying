package to_0613_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*1926번. 그림 - BFS 풀이 */
public class Main {
	static int N, M;
	static int[][] picture;
	static boolean[][] visited;
	
	//상하좌우
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//정답용
	static int num;
	static int cnt;
	
	//BFS
	static void BFS(int x, int y) {
		Queue<int[]> Q= new LinkedList<>();
		
		cnt = 1;
		visited[x][y] = true;
		Q.add(new int[] {x, y});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx <0 || ny <0 || nx >=N || ny>=M) continue;
				if(picture[nx][ny] == 0 || visited[nx][ny]==true) continue;
				
				//BFS 정상 처리
				visited[nx][ny] = true;
				Q.add(new int[] {nx, ny});
				cnt++; //너비++
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		picture = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				picture[i][j] = kb.nextInt();
			}
		}
		int max = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(picture[i][j] == 1 && !visited[i][j]) {
					num++;//호출 횟수 == 어쨋든 덩어리 총 수 
					BFS(i,j);
					max = Math.max(max, cnt);
				}
			}
		}
		
		System.out.println(num + "\n" + max);
	}
}