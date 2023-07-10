package to_0710_4;

import java.util.ArrayList;
import java.util.Scanner;

/*1010번. 다리 놓기 */
public class Main {
	static long [][] D;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		//초기화
		D = new long[31][31];
		
		for(int i=0; i<=30; i++) {
			D[i][0] = 1;
			D[i][i] = 1;
			D[i][1] = i;
		}
		
		//점화식으로 값 확장
		for(int i=2; i<=30; i++) {
			for(int j=1; j<i; j++) {
				D[i][j] = D[i-1][j]+D[i-1][j-1];
			}
		}
		
		int T = kb.nextInt();
		ArrayList<Long> arr= new ArrayList<>();
		for(int i=0; i<T; i++) {
			int N = kb.nextInt();
			int M = kb.nextInt();
			arr.add(D[M][N]);
		}
		for(long x : arr)System.out.println(x);
	}
}