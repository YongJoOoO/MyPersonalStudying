package to_0908_2;

import java.util.Scanner;

/*백준 16194번. 카드 구매하기 2 - DP 문풀 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();//구매하려는 카드 개수 
		int[] card = new int[N+1];//각 카드 개수의 묶음별 금액 
		int[] dy = new int[N+1];//카드 i개 구매시 지불하는 최소 금액 
		
		//데이터 입력받기 
		for(int i=1; i<=N; i++) {
			card[i] = kb.nextInt();
			dy[i] = Integer.MAX_VALUE;
		}
		//DP 사용
		for(int i=1; i<=N; i++) {
			dy[i] = card[i];
			for(int j=i-1; j>=1; j--) {
				dy[i] = Math.min(dy[i], dy[i-j] + card[j]);
			}
		}
		System.out.println(dy[N]);
	}
}