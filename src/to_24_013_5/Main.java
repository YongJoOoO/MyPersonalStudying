package to_24_013_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 2580번. 스도쿠 - 백트래킹 문풀
 * @author MYLG
 */
public class Main {
	static int[][] map;
	static boolean[][] visited;
	//DFS
	static void DFS(int row, int col) {
		if(col == 9) {
			DFS(row+1, 0);//다음 행에 대해 깊이 탐색 
		}
		
		if(row == 9) { //행도 9가 되면 
			StringBuilder sb = new StringBuilder();
            for (int[] ints : map) {
                for (int anInt : ints) {
                    sb.append(anInt).append(' ');
                }
                sb.append('\n');
            }

            System.out.println(sb);
            

            // 여러 경우의 수 중 하나만 출력해햐 함.
            System.exit(0);
		}
		
		if(map[row][col] == 0) {
			for(int i=1; i<=9; i++) {
				if(isPossible(row, col, i)) {
					map[row][col] = i;
					DFS(row, col + 1);
				}
			}
			map[row][col]=  0;
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
		
		//3) 3X3에도 숫자 겹치면 안됨 
		int rec_row = (row/3) * 3;
		int rec_col = (col/3) * 3;
		
		for(int i=rec_row; i<rec_row + 3; i++) {
			for(int j=rec_col; j<rec_col + 3; j++) {
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
		
		Queue<int[]> Q=  new LinkedList<>();
		
		map = new int[9][9];
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				map[i][j] = kb.nextInt();
				if(map[i][j] == 0) {
					Q.offer(new int[] {i, j });
				}
			}
		}
		
		DFS(0, 0);
	}
}