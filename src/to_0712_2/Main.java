package to_0712_2;

import java.util.Scanner;

/*백준 10844번. 계단 수 */
public class Main {
	static final long MOD = 1000000000;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();
		long[][] D = new long[N+1][11];
		
		//초기화
		for(int i=1; i<=9; i++) {
			D[1][i] = 1;
		}	
		//값 세팅 
		for(int i=2; i<=N; i++) { //i로는 각 자릿수 찍을 거임 
			//i번째 끝자리에 0과 9가 오면, 직전 i-1번째 자리엔 각각 1과 8밖에 못 온다.  
			D[i][0] = D[i-1][1];
			D[i][9] = D[i-1][8];
			
			for(int j=1; j<=8; j++) {
				D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % MOD;
			}
		}
		//sum
		long sum = 0;
		for(int i=0; i<10; i++) {
			sum = (sum + D[N][i]) % MOD;
		}
		System.out.println(sum);
	}
}