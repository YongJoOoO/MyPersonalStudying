package to_0712_1;

import java.util.Scanner;

/* 백준 11726번. 2Xn 타일링
 * */
public class Main {
	//MOD 는 long타입으로 선언할 것 *** RunTIme 에러 발생 안하게 
	static final long MOD = 10007;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();//타일링
		//D long 타입 
		long [] D = new long[1001];//N의 크기는 최대 1000 이므로 : 이거 때문에 자꾸 RunTime 에러 발생 
		
		D[0]=0;
		D[1]=1;
		D[2]=2;
		
		for(int i=3; i<=N; i++) {
			D[i] = (D[i-1] + D[i-2]) % MOD;//나눈 결과값
		}		
		System.out.println(D[N]);
	}
}