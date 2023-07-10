package to_0710_1;

import java.util.Scanner;

/*백준 11050번. 이항 계수 1 */
public class Main {
	static int N, K;
	static int[][] DP;//배열 
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
			
		N = kb.nextInt();
		K = kb.nextInt();
		
		//초기화
		DP=new int[N+1][N+1];
		for(int i=0; i<=N; i++) {
			DP[i][i] = 1; //자기 자신 뽑는 게 1개 
			DP[i][1] = i; //nC1= n개 
			DP[i][0] = 1;
		}
		//배열 값 점화식 기반으로 세팅 
		for(int i=2; i<=N; i++) { //전체 개수 확장 
			for(int j=1; j<i; j++) { //뽑는 개수는 전체 개수 넘어설 수 없음 
				DP[i][j] = DP[i-1][j] + DP[i-1][j-1];//값 세팅 
			}
		}
		System.out.println(DP[N][K]);//NCK 구함 
	}
}