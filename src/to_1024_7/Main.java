package to_1024_7;

import java.util.Scanner;

/**
 * 1926번. 그림 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int tmp = 0;
	
	//4방향
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//DFS
	static void DFS(int x, int y) {
		visited[x][y] = true;
		tmp++;//방문할 때마다 넓이 ++처리
		
		for(int k=0; k< 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx <0 || ny <0 || nx >=N || ny>=M) continue;
			if(map[nx][ny] ==0 || visited[nx][ny] == true) continue;
			
			DFS(nx, ny);
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = kb.nextInt();
			}
		}
		
		int answer = 0;
		int max = 0;
		//호출
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					DFS(i,j);
					answer++; //전체 그림 개수 
					max = Math.max(max, tmp);//더 큰 값으로 세팅 
					tmp = 0;
				}
			}
		}
		System.out.println(answer);
		System.out.println(max);
	}
}