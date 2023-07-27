package to_0727_3;

import java.util.Scanner;

//계단 오르기 
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] score= new int[n+1];
		for(int i=1; i<=n; i++) score[i] = kb.nextInt();
		
		int[] dy = new int[n+1];
		
		//초기화
		dy[1] = score[1];
		
		if(n > 1) dy[2] = score[1]+ score[2];
		
		for(int i=3; i<=n; i++) {
			//두 계단 전 vs 직전 계단
			dy[i] = Math.max(dy[i-2] + score[i], dy[i-3] + score[i-1] + score[i]);
		}
		System.out.println(dy[n]);
	}
}