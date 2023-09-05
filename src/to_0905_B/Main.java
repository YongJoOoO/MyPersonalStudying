package to_0905_B;

import java.util.*;

/*11403번. 경로찾기 - 플로이드 */
public class Main {
	static int N;
	static int[][] board;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N =  kb.nextInt();
		board = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		
		//플로이드 
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][k] == 1 && board[k][j] == 1) {
						board[i][j] =1;
					}
				}
			}
		}
		
		//이 상태 그대로 출력함
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}