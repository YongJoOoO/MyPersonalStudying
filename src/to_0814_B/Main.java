package to_0814_B;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//10026번. 적록색약 
public class Main {
	static int N, ans1, ans2;
	static int[][] map;
	static boolean[][] visited;
	
	//상하좌우 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//DFS
	static void DFS(int x, int y) {
		
		visited[x][y] = true;
		int tmp = map[x][y];//현재값과 같은 값에 대하여 깊이 탐색 
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx <0 || ny <0 || nx >= N || ny >= N) continue;
			
			if(map[nx][ny] == tmp && !visited[nx][ny]) {
				DFS(nx, ny);
			}
		}
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		
		map = new int[N][N];
		visited = new boolean[N][N];
		//R-1 G-2 B-3 으로 입력받기 
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			for(int j=0; j<N; j++) {
				if(tmp.charAt(j) == 'R') map[i][j] = 1;
				else if(tmp.charAt(j) == 'G') map[i][j] = 2;
				else if(tmp.charAt(j) == 'B') map[i][j] = 3;
			}
		}
		
		ans1 = 0;
		//1) 기본으로 했을 떄 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					DFS(i, j);
					ans1++;
				}
			}
		}
		
		visited = new boolean[N][N];
		ans2 = 0;
		//2) 적록색약이 봤을 때 
		//map 다시 짜기 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 2) map[i][j] = 1; //같은 영역으로 보게 
			}
		}
		
		//호출 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					DFS(i, j);
					ans2++;
				}
			}
		}
		
		//정답 세팅 
		System.out.println(ans1 + " " + ans2);
	}
}