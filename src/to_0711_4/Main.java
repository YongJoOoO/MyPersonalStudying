package to_0711_4;

import java.util.Scanner;

/*백준 2193번. 이친수 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		long D[][] = new long[N+1][2]; //N의 자릿수에서 0으로 끝나는 vs 1로 끝나는 이친수 개수 
		D[1][1] = 1;//1개
		D[1][0] = 0; 
		for(int i=2; i<=N; i++) {
			D[i][0] = D[i-1][0] + D[i-1][1];//0또는1로 끝나는 모든 수에 0 붙일 수 있음
			D[i][1] = D[i-1][0];//0으로 끝나는 수에만 0 붙일 수 있음 
		}
		System.out.println(D[N][0]+D[N][1]);//모든 이친수 개수
	}
}