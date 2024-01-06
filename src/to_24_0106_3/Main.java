package to_24_0106_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 2210번. 숫자판 점프 
 * @author MYLG
 *
 */
public class Main {
	static int[][] arr;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static Map<Integer, Integer> map = new HashMap<>();
	//DFS
	static void DFS(int lv, int x, int y, int num) {
		if(lv == 5) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			return;
		}
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx < 0 || nx >= 5 || ny <0 || ny >= 5) continue;
			
			DFS(lv+1, nx, ny, (num *10) + arr[nx][ny]);
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		arr = new int[5][5];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				DFS(0, i, j, arr[i][j]);
			}
		}
		System.out.println(map.size());
	}
}