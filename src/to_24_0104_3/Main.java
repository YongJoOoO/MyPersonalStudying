package to_24_0104_3;

import java.util.Scanner;

/**
 * 2580번. 스도쿠 - 백트래킹 문풀
 * @author MYLG
 *
 */
public class Main {
	static int[][] map;

	//DFS
	static void DFS(int row, int col) {
		if(col == 9) {
			DFS(row+1, 0);//열이 9까지 다 채워졌따면 다음 행으로 이동
			return;
		}
		
		if(row == 9) { //행이 다 채워졌다면 (이제 행9열9 모두 채워진 상태임)

			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);//아예 프로그램 종료 시킴
		}
		
		//현재 깊이로 들어온 행,열 안에 담긴 값이 0 = 빈칸이라면 적절 값 찾아주기 
		if(map[row][col] == 0) {
			for(int val=1; val <=9; val++) {
				if(isPossible(row, col, val)) {
					map[row][col]= val; //값 담아주고
					DFS(row, col+1);// 다음 열에 대해서 조사 
				}
			}
			
			//다 돌았음에도 못 구한 경우 == 스도쿠가 뭔가 잘못 됐다는 거임 디버깅
			map[row][col] = 0;
			return;
		}
		
		DFS(row, col + 1); //열 채워지기 전까지는 현재 행의 다음 열에 대해 조사 
	}
	
	//isPossible
	static boolean isPossible(int row, int col, int val) {
		//행에 중복값 있을 경우 
		for(int i=0; i<9; i++) {
			if(map[row][i] == val) return false;
		}
		
		//열에 중복값 있을 경우 
		for(int i=0; i<9; i++) {
			if(map[i][col] == val) return false;
		}
		
		//3X3에 중복값 있을 경우 
		int r = (row/3) * 3;
		int c = (col/3) * 3;
		
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				if(map[i][j] == val) return false;
			}
		}
		return true;
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		map = new int[9][9];
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				map[i][j] = kb.nextInt();
			}
		}
		
		DFS(0,0);
	}
}