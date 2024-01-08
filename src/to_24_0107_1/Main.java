package to_24_0107_1;

import java.util.Scanner;

/**
 * 2579번. 계단 오르기 - DP 문풀 
 * @author MYLG
 *
 */
public class Main {
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();
		int[] arr = new int[N+1];
		int[] dy = new int[N+1];
		
		for(int i=1; i<=N; i++) arr[i] = kb.nextInt();
		
		dy[0] = 0;
		
		if (N == 1) {
			dy[1] = arr[1];
		} else if (N == 2) {
			dy[2] = Math.max(arr[1] + arr[2], arr[2]);
		} else {
			dy[1] = arr[1];
			dy[2] = arr[1] + arr[2];
			for(int i=3; i<=N; i++) {
				dy[i] = Math.max(dy[i-2] + arr[i], dy[i-3] + arr[i-1] + arr[i]);
			}
		}
	 
		System.out.println(dy[N]);
		
	}

}
