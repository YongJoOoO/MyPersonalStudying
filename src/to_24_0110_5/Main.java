package to_24_0110_5;

import java.util.Scanner;

/**
 * 9252번. LCS 2 - DP 문풀 
 * 
 * @author MYLG
 *
 */
public class Main {
	static char[] A;
	static char[] B;
	static int[][] DP;
	/**
	 * DP[i][j] 정의 : A[1~i]와 B[1~j] 까지 LCS 길이
	 * 점화식 
	 * 1) A[i] = B[j] : 직전값에 포함시켜야 하므로 D{i-1][j-1] + 1
	 * 1) A[i] != B[j] : 왼쪽, 위쪾 중 큰 값 (왜냐면, 둘 중 하나가 빠진 거 중에서)더 큰 값으로 이어붙여서 추후에 LCS 만들어야 하니까 
	 */

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		A = kb.next().toCharArray();
		B = kb.next().toCharArray();
		
		DP = new int[A.length + 1][B.length + 1];
		
		for(int i=1; i<=A.length; i++) {
			for(int j=1; j<=B.length; j++) {
				if(A[i-1] == B[j-1]) {
					DP[i][j] = DP[i-1][j-1] + 1;
				}else {
					DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
				}
			}
		}
	
		System.out.println(DP[A.length][B.length]);
	}

}
