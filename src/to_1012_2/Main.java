package to_1012_2;

import java.util.*;
import java.util.Scanner;

/*3187번. 양치기 꿍 */
public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int vCnt = 0;//늑대 카운팅
	static int kCnt= 0 ;//양 카운팅 
	
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
	//BFS
	static void BFS(int x, int y) {
		int wolf = 0;
		int sheep = 0;
		
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {x, y});
		
		while(!Q.isEmpty()) {
			int[] cur = Q.poll();
			int i = cur[0];
			int j = cur[1];
			if(map[i][j] == 'v') {
				wolf++;
			}else if(map[i][j] == 'k') {
				sheep++;
			}
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx >0 && nx <R && ny >0 && ny <C && !visited[nx][ny] && map[nx][ny] !='#') {	
					visited[nx][ny] = true;
					Q.offer(new int[] {nx, ny});
				}
			}
		}
		//빠져나와서 숫자 비교
		//이 영역에 대하여 
		if(sheep > wolf) {
			kCnt += sheep;
		}else if(sheep <= wolf) {
			vCnt += wolf;
		}
	}

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		R = kb.nextInt();
		C=  kb.nextInt();
		map = new char[R][C];
		visited= new boolean[R][C];
		//데이터 입력
		for(int i=0; i<R; i++) {
			map[i] = kb.next().toCharArray();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != '#' && !visited[i][j]) {
					//울타리도 아니면서 방문 전인 공간에 대하여 
					BFS(i, j);//탐색
				}
			}
		}
		//양의 개수 , 늑대 개수 
		System.out.println(kCnt + " " + vCnt);
	}
}