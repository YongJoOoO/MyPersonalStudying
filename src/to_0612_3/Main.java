package to_0612_3;

import java.util.Arrays;
import java.util.Scanner;

/*RE 풀이 */
public class Main {
	
	private static int n;
	private static int[][] map;
	private static boolean[][] visited;
	//방향용
	private static int dx[] = {0, 0, 1, -1};
	private static int dy[] = {1, -1, 0, 0};
	
	private static int apartNum;
	//정답용 
	private static int[] answer = new int[25*25];
	
	//DFS
	static void DFS(int x, int y) {
		visited[x][y] = true;
		answer[apartNum]++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny <0 || nx >=n || ny >=n) continue;
			
			if(map[nx][ny] == 0 || visited[nx][ny] == true) {
				continue;
			}
			
			visited[nx][ny] = true;
			DFS(nx, ny);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		
		map = new int[n][n];
		visited = new boolean[n][n];
		answer = new int[n*n];
		
		for(int i=0; i<n; i++) {
			String s = kb.next();
			for(int j=0; j<n; j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					apartNum++;
					DFS(i, j);
				}
			}
		}
		Arrays.sort(answer);
		
		System.out.println(apartNum);
		for(int x : answer) {
			if(x==0)continue;
			System.out.println(x);
		}		
	}
}