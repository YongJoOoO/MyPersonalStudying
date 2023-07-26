package to_0726_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int[] score = new int[N+1];
		for(int i=1; i<=N; i++) score[i] = kb.nextInt();
		int[] dy = new int[N+1];
		
		dy[1] = score[1];
		if(N > 1) dy[2] = score[1] + score[2];
		
		for(int i=3; i<=N; i++) {
			dy[i] = Math.max(dy[i-2] + score[i], dy[i-3] + score[i-1] + score[i]);
		}
		System.out.println(dy[N]);
	}
}