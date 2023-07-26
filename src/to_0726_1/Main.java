package to_0726_1;

import java.util.Scanner;

/*2579번. 계단 오르기 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();//계단 개수 
		int[] score = new int[N+1];
		for(int i=1; i<=N; i++) score[i] = kb.nextInt();
		
		int[] D = new int[N+1];
		D[1] = score[1];
		if(N > 1) D[2] = score[1] + score[2];
		
		for(int i=3; i<=N; i++) {
			D[i] = Math.max(D[i-2] + score[i], D[i-3] + score[i-1]+ score[i]);
		}
		System.out.println(D[N]);
		
	}

}
