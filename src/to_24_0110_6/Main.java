package to_24_0110_6;

import java.util.Scanner;

/**
 * 9251번. LCS - DP 문풀 
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
		
		int[][] D = new int[A.length+1][B.length+1];//더 크게 
		
		for(int i=1; i<=A.length; i++) {
			for(int j=1; j<=B.length; j++) {
				//DP는 0일 때를 0으로 두기 위해 1칸씩 크게 뒀음
				//직접 참조하는 부분은 i-1, j-1이므로 
				if(A[i-1] == B[j-1]) {
					D[i][j] = D[i-1][j-1] + 1;
				}else {
					D[i][j]= Math.max(D[i-1][j], D[i][j-1]);//더 큰 값 
				}
			}
		}
		//출력
		System.out.println(D[A.length][B.length]);
	}
}