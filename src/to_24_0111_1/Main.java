package to_24_0111_1;

import java.util.Scanner;

/**
 * 9251번. LCS - 문풀 
 * @author MYLG
 *
 */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		char[] A = kb.next().toCharArray();
		char[] B = kb.next().toCharArray();
		
		int[][] DP = new int[A.length+1][B.length+1];
		//DP[i][j] : A의 0~i 와 B의 0~j까지 겹치는 문자열 최대 길이를 담을 용도임
		
		for(int i=1; i<=A.length; i++) {
			for(int j=1; j<=B.length; j++) {
				//DP[0][0] 인 부분은 서로 겸치는 게 없는 부분임 한칸씩 밀림
				if(A[i-1] == B[j-1]) {
					DP[i][j] = DP[i-1][j-1] + 1;//직전에 두개 다 뺀 문자열 LCS+1
				}else {
					DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
				}
			}
		}
		System.out.println(DP[A.length][B.length]);
	}

}
