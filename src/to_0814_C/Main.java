package to_0814_C;

import java.util.Scanner;

//알파벳 문제 
public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int answer;
	static String tmp;//여기에 깊이 간 값 담아서 contains로 존재 확인 
	static int res = 1;
	//상하좌우
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//DFS
	static void DFS(int x, int y, int cnt) {
		//이미 방문했거나 기존 tmp 에 담겨있는 문자일 경우 복귀시킴
		if(visited[x][y] || tmp.contains(String.valueOf(map[x][y])) ) {//다음으로 이미 방문해서 더 깊이 갈 수 없을 떄 리턴싴미 
			answer = Math.max(answer, cnt);
			return; // 복귀 
		}else {
			visited[x][y] = true;//그게 아니라면 방문 처리 
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx <0 || ny <0 || nx >=R || ny >=C) continue;
				tmp += map[nx][ny];
				DFS(nx, ny, cnt+1); //깊이 갈수록 +1
				tmp = tmp.substring(0, tmp.length()-1);//하나씩 값 감소 
			}
			visited[x][y] = false;//다시 복귀할 떄 처리 
		}	
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		R = kb.nextInt();//행
		C = kb.nextInt();//열
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		//데이터 입력 받기 
		for(int i=0; i<R; i++) {
			String s = kb.next();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		tmp += map[0][0];//시작값은 일단 담아주고 
		DFS(0, 0, 1); //시작점으로 호출 
		
		System.out.println(answer);
		
	}
}