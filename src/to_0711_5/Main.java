package to_0711_5;

import java.util.Scanner;

/*1904번. 01타일 */
public class Main {
	static final int MOD = 15746;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();//자릿수 
		long [] D = new long [N+1];//1~N의 자릿수에 만들 수 있는 2진수
		
		//초기화
		D[0] = 0;
		D[1] = 1;
		D[2] = 2;
		
		
		for(int i=3; i<=N; i++) {
			D[i] = ( D[i-2] + D[i-1] ) % MOD;
		}		
		System.out.println(D[N]);
	}
}