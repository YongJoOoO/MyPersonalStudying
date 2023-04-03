package to_0403;

import java.util.Scanner;

/* 10-1. 계단 오르기 */
public class Main3 {
	static int[] dy;
	//솔루션
	public int solution(int n) {
		//앞의 두 계단 초기화
		dy[1] = 1;
		dy[2] = 2;
		//피보나치처럼 가짓수 확장된다. 
		for(int i=3; i<=n; i++) {
			dy[i] = dy[i-2]+dy[i-1];//앞 두계단 합이 현재 계단 
		}
		return dy[n];
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		int n= kb.nextInt();
		dy = new int[n+1];
		System.out.println(T.solution(n));
	}
}