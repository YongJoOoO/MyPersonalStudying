package to_24_0108_1;

import java.util.Scanner;

/**
 * 백준 2579번. 계단 오르기 - DP 문풀 
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
		
		for(int i=1; i<=N; i++) {
			arr[i]= kb.nextInt();
		}
		
		//[주의] : 계단의 개수는 300개 이하 자연수(1~300) 이니까 극단적으로 1이 들어오는 것도 가능함
		dy[1] = arr[1];
		if(N  >= 2) dy[2] = arr[1] + arr[2];
		
		for(int i=3; i<=N; i++) {
			//i번째 칸 = 1) 직전 칸(2칸+1칸) + 현재칸       2) 더플 직전칸 (2칸 전) + 현재 칸 
			dy[i] = Math.max(dy[i-3]+arr[i-1] +arr[i], dy[i-2] + arr[i]);
		}
		
		System.out.println(dy[N]);
	}	
}