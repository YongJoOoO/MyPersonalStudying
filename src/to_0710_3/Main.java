package to_0710_3;

import java.util.ArrayList;
import java.util.Scanner;

/* 2775번. 부녀회장이 퇼테야 
 * */
public class Main {
	static int T, N, K;
	static int[][] D;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		D = new int[15][15];
		
		//초기화
		for(int i=0; i<15; i++) {
			D[i][1] = 1;
			D[0][i]= i;//각 i로 세팅 
		}
		//업데이트
		for(int i=1; i<15; i++) {
			for(int j=2; j<15; j++) {
				D[i][j]= D[i][j-1]+D[i-1][j]; //점화식 
			}
		}	
		//테스트케이스 개수만큼 반복하며 answer에 답 누적
		T = kb.nextInt();
		ArrayList<Integer> answer= new ArrayList<>();
		for(int i=0; i<T; i++) {
			N = kb.nextInt();
			K = kb.nextInt();
			answer.add(D[N][K]);
		}
		for(int x: answer) {
			System.out.println(x);
		}
	}
}