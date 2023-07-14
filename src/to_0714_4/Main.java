package to_0714_4;

import java.util.ArrayList;
import java.util.Scanner;

/*LCS 문제 풀이 다시 */
public class Main {
	static char[] A;
	static char[] B;
	static long[][] DP;
	static ArrayList<Character> Path;
	
	static void getText(int r, int c) {
		if(r==0 || c==0) return;
		
		if(A[r-1] == B[c-1]) {
			Path.add(A[r-1]);
			getText(r-1, c-1);//왼쪽 대각선 위로 올라가 
		}else {
			if(DP[r-1][c] > DP[r][c-1]) {
				//왼쪽 값이 더크면
				getText(r-1, c);
			}else {
				getText(r, c-1);//위로 이동 
			}
		}
	}
	
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb= new Scanner(System.in);
		A = kb.next().toCharArray();
		B = kb.next().toCharArray();
		DP = new long[A.length+1][ B.length+1];
		Path = new ArrayList<>();
		
		for(int i=1; i<=A.length; i++) {
			for(int j=1; j<=B.length; j++) {
				if(A[i-1] == B[j-1]) {
					DP[i][j] = DP[i-1][j-1] + 1;
				}else {
					DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
				}
			}
		}
		//길이 출력 
		System.out.println(DP[A.length][B.length]);
		
		getText(A.length, B.length);
		
		//역으로 문자 출력 
		for(int i=Path.size()-1; i>=0; i--) {
			System.out.print(Path.get(i));
		}
		System.out.println();
	}
}