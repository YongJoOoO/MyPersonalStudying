package to_0814_D;

import java.util.Scanner;

//1987번 다시 풀기 
public class Main {
	static int R, C;
	static String [][] map;
	static boolean[][] visited;
	static int answer;
	//4방향 좌표
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	//DFS
	static void DFS(int x, int y, String tmp,  int cnt) {
		//만약 이미 거쳤던 문자를 또 가려고 할 경우에는 
		if(answer < cnt) {
			answer = cnt;
		}
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx <0 || ny <0 || nx >= R || ny>=C || visited[nx][ny]) continue;
			
			if(!tmp.contains(String.valueOf(map[nx][ny]))) {
				visited[nx][ny] = true;
				DFS(nx, ny, tmp+map[nx][ny], cnt+1);
				visited[nx][ny] = false;
			}
		} 
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		R= kb.nextInt();
		C=kb.nextInt();
		map = new String[R][C];
		visited = new boolean[R][C];
		
		//데이터 입력받기 
		for(int i=0; i<R; i++) {
			String s = kb.next();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j) + ""; //담고
			}
		}
		answer = 0;
		//호출 
		DFS(0, 0,map[0][0], 1);//카운팅 		
		System.out.println(answer);
	}
}