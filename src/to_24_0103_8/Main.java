package to_24_0103_8;

import java.util.*;

/**
 * 2580번 스도쿠 - 백트래킹 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int[][] map;
	
	//DFS
	static void DFS(int row, int col) {
		if(col == 9) {
			//다음 행에 대해 탐색
			DFS(row+1, 0);
			return;
		}
		if(row == 9) {
			//이제 다 탐색한 거라 출력
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);//여기서 종료
		}
		
		if(map[row][col] == 0) {
			//빵꾸난 경우
			for(int i=1; i<=9; i++) {
				if(isPossible(row, col, i)) {
					//가능한 value가 있다면 
					map[row][col]= i;//세팅하고 
					DFS(row, col+1);
				}
			}
			//여기서 만약 적당한 방법을 찾이 못했으면 
			map[row][col] = 0;
			return;
		}
		
		DFS(row, col + 1);
	}
	
	
	//isPossible
	static boolean isPossible(int row, int col, int val) {
		//동일 행
		for(int i=0; i<9; i++) {
			if(map[row][i] == val) {
				return false;
			}
		}
		
		///동일 열 
		for(int i=0; i<9; i++) {
			if(map[i][col] == val) {
				return false;
			}
		}
		
		//동일 칸 
		int tmp_row = (row/3) * 3;
		int tmp_col = (col/3) * 3;
		
		for(int i=tmp_row; i<tmp_row+3; i++) {
			for(int j=tmp_col; j<tmp_col+3; j++) {
				if(map[i][j] == val) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		map = new int[9][9];
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				map[i][j] = kb.nextInt();
			}
		}
		
		DFS(0, 0);
	}

}
