package to_0911_5;

import java.util.*;
import java.util.Scanner;

/*2210번. 숫자판 점프 - DFS & 완전탐색 */
public class Main {
	static String [][] board;
	static HashMap<String, Integer> map = new HashMap<>();
	//4방향 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	//DFS
	static void DFS(int x, int y, int lv, String num) {
		if(lv == 5) {
			map.put(num, map.getOrDefault(num, 0)+1);//카운팅 하면서 
			return;//여기서 복귀함
		}
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx <0 || ny<0 || nx >=5 || ny>=5 ) continue;
			
			DFS(nx, ny, lv+1, num + board[nx][ny]);//더 깊이 감
		
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		board = new String[5][5];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				board[i][j] = kb.next();
			}
		}
		//하나씩 보냄
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				
				//시작당시에 값 하나 담긴 상태로 보내기 때문에 최종 레벨은 5까지만 더 탐색해서 이어붙임녀 6자리 완성된다.
				DFS(i, j, 0, board[i][j]);
			}
		}
		System.out.println(map.size());
		
	}

}
