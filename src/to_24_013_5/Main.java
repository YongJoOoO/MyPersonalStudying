package to_24_013_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 2580번. 스도쿠 - 백트래킹 문풀
 */
public class Main {
	static int[][] map;
	//DFS
	static void DFS(int row, int col) {
		if(col == 9) {
			DFS(row+1, 0);//다음 행에 대해 깊이 탐색 
		}
		
		if(row == 9) { //행도 9가 되면 -> 모두 탐색한 상황이니 출력 
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
            // 여러 경우의 수 중 하나만 출력해햐 함.
            System.exit(0);
		}
		
		//값이 비워져있는 0 이라면
		if(map[row][col] == 0) {
			//1~9의 값중 어떤 값이 담길 수 있는지 알아야 합니다.
			for(int i=1; i<=9; i++) {
				if(isPossible(row, col, i)) {
					map[row][col] = i;
					DFS(row, col + 1);
				}
			}
			//뭔가 다음 깊이로 가지 못했다면, 스도쿠 상에 문제가 있는 거라 복귀하면서 0 을 다시 심는다.	
			map[row][col]=  0;//얘는 뭐죠 ? 
			return; 
		}
		
		DFS(row, col+1);
	}
	
	//isPossible
	static boolean isPossible(int row, int col, int val) {
		//스도쿠 
		//1) 행에 숫자 겹치면 안됨
		for(int i=0; i<9; i++) { 
			if(map[row][i] == val) {
				return false;
			}
		}
		
		//2) 열에 숫자 겹치면 안됨
		for(int i=0; i<9; i++) {
			if(map[i][col] == val) {
				return false;
			}
		}
		
		//3) 3X3에도 숫자 겹치면 안됨 <- 이 부분을 어떻게 처리해야 하는지 몰랐다. 
		/**
		 * 들어온 행, 열 값을 3으로 나눈 몫에 우리가 찾기 시작할 소속 네모 st 를 알고자 *3 곱한다.
		 * 
		 *  0/ 3= 0
		 *  1/ 3 = 0
		 *  2/ 3 - 0
		 *  
		 *  3/3 = 1
		 *  4/3 = 1
		 *  5/3 = 1
		 *  
		 *  6/3 = 2
		 *  7/3 = 2
		 *  8/3 = 2
		 */
		int tmp_row = (row/3) * 3;
		int tmp_col = (col/3) * 3;
		
		for(int i=tmp_row; i<tmp_row + 3; i++) {
			for(int j=tmp_col; j<tmp_col + 3; j++) {
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