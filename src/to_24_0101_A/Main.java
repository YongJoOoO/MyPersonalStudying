package to_24_0101_A;

import java.util.Scanner;

/**
 * 2580번. 스도쿠 - 백트래킹 
 */
public class Main {
	static int[][] map;
	//DFS
	static void DFS(int row, int col) {
		if(col == 9) {
			//다음 행에 대한 깊이 탐색
			DFS(row+1, 0);
			return;
		}
		
		if(row == 9) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		
		if(map[row][col] == 0) {
			//빈값 매꾸기 
			for(int val=1; val<= 9; val++) {
				if(isPossible(row, col, val)) {
					map[row][col] = val;
					DFS(row, col+1);//다음 열에 대해 조사 
				}
			}
			//무언가 문제가 발생한 경우 
			map[row][col] = 0;//다시 두고 
			return;//여기서 복귀 
		}
		
		DFS(row, col+1);
	}
	
	//isPossible
	static boolean isPossible(int row, int col, int val) {
		for(int i=0; i<9; i++) {
			if(map[row][i] == val) {
				return false;
			}
		}
		for(int i=0; i<9; i++) {
			if(map[i][col] == val) {
				return false;
			}
		}
		
		//3X3 크기 상자 안에도 중복 확인
		int st_row = (row/3) * 3;
		int st_col = (col/3) * 3;
		
		for(int i=st_row; i<st_row+3; i++) {
			for(int j=st_col; j<st_col+3; j++) {
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