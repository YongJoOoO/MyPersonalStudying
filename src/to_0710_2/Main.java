package to_0710_2;

import java.util.Scanner;

/*11051번. 이항 계수 2 */
public class Main {
	static int N, K;
	static int[][] D;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		K = kb.nextInt();
		//초기화
		D = new int[N+1][N+1];		
		for(int i=0; i<=N; i++) {
			D[i][1] = i;
			D[i][0] = 1;
			D[i][i] = 1;
		}
		//데이터에 점화식 기반으로 값 세팅
		 for(int i=2; i<=N; i++) {
			 for(int j=1; j<=i; j++) {
				 D[i][j] = D[i-1][j] + D[i-1][j-1];
				 //10007로 모듈러 연산 한 뒤 다시 세팅 
				 D[i][j] = D[i][j] % 10007;
			 }
		 }
		 //D[n][k] 구하기
		 System.out.println(D[N][K]);
	}
}