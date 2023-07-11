package to_0711_6;

import java.util.Scanner;

/*9095번. 123 더하기 */
public class Main {
	static int T, N;
	static int[] D;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		T = kb.nextInt();
		
		N = kb.nextInt(); //입력 받고 
		D = new int[11];
		
		//초기화
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for(int i=4; i<=11; i++) {
			D[i] = D[i-3]+D[i-2]+D[i-1];
		}
		
		for(int i=0; i<T; i++) {
			int n = kb.nextInt();
			System.out.println(D[n]);
		}
		
		
	}
}