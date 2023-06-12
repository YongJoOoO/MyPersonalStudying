package to_0612_A;

import java.util.ArrayList;
import java.util.Scanner;

/* 4963번. 섬의 개수 - DFS
 * */
public class Main {
	static int W, H;
	
	static int[][] map;
	static boolean[][] visited;
	//상하좌우대각선
	static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
	static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1}; 
	
	//정답 담는 용도 
	static ArrayList<Integer> arr = new ArrayList<>();
	
	//DFS
	static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<8; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0 || nx>=H || ny >= W) continue;
			if(map[nx][ny] == 0 || visited[nx][ny] == true) continue;
			
			DFS(nx, ny);
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			
			W = kb.nextInt();
			H = kb.nextInt();
			
			if(W==0 && H==0) break;//마지막 라인은 탈출
			
			map = new int[H][W];
			visited = new boolean[H][W];
			//입력받고 
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = kb.nextInt();
				}
			}
			
			int answer =0;
			
			//DFS 호출
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						answer++;// 섬의 개수== 호출개수
						DFS(i,j);//호출 
					}
				}
			}
			 arr.add(answer);
		}
		//정답 출력 
		for(int x : arr) {
			System.out.println(x);
		}
	}
}