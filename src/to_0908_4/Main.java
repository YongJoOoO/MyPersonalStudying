package to_0908_4;

import java.util.*;

/*백준 14916번. 거스름돈 - DP 문제 */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int[] coin = new int[2];
		coin[0] = 2;
		coin[1] = 5;
		int[] dy = new int[N+1];//i원을 거슬러주는 최소 동전 금액 
		
		for(int i=1; i<=N; i++) {
			dy[i] = Integer.MAX_VALUE;
			for(int j=0; j<2; j++) {
				if(i % coin[j] == 0) {
					dy[i] = Math.min(dy[i], i/coin[j]);
				}
			}
		}
		
	
		
	}

}
