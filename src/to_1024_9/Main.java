package to_1024_9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1926번. 그림 문풀 - BFS
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	//4방향
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//BFS
	static int BFS(int x, int y) {
		int cnt =0;
		
		Queue<int[]> Q =new LinkedList<>();
		Q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			cnt++;//넓이 처리
			for(int k=0; k<4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if(nx < 0 || ny <0 || nx>=N || ny>=M) continue;
				if(visited[nx][ny] || map[nx][ny] == 0)continue;
				
				Q.offer(new int[] {nx , ny });
				visited[nx][ny] = true;	
			}
		}
		return cnt;//그림 넓이
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		
		//데이터 입력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = kb.nextInt();
			}
		}
		
		int answer =  0;//그림 개수
		int max = 0;//가장 큰 넓이
		
		//데이터 호출
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					int tmp = BFS(i, j);
					answer++;//호출 횟수 = 덩어리 개수 
					max = Math.max(max, tmp);
				}
			}
		}
		
		System.out.println(answer);
		System.out.println(max);		
	}
}