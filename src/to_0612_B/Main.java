package to_0612_B;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 4963번. 섬의 개수 
 * */
public class Main {
	//정적 변수 
	static int W, H;
	static int[][] map;
	static boolean[][] visited;
	//8방향
	static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
	static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
	//정답 세팅 
	static ArrayList<Integer> arr = new ArrayList<>();
	
	//BFS
	static void BFS(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		
		visited[x][y] = true;
		Q.add(new int[] {x, y});
		
		while(!Q.isEmpty()) {
			int[] cur  = Q.poll();
			
			for(int i=0; i<8; i++) {
				int nx = cur[0] + dx[i];
				int ny= cur[1] + dy[i];
				
				if(nx<0 || ny <0 || nx>=H || ny>= W) continue;
				if(map[nx][ny] == 0 || visited[nx][ny] == true) continue;
				
				//그 외에는 방문 처리
				visited[nx][ny] = true;
				Q.add(new int[] {nx, ny});
				
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb =new Scanner(System.in);
	
		while(true) {
			W = kb.nextInt();
			H = kb.nextInt();
			
			if(W==0 && H==0) break;
			
			map = new int[H][W];
			visited = new boolean[H][W];
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = kb.nextInt();
				}
			}
			int answer = 0;
			//호출
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						answer ++;
						BFS(i, j);
					}
				}
			}
			
			arr.add(answer);
		}
		
		for(int x : arr) System.out.println(x);
	}
}