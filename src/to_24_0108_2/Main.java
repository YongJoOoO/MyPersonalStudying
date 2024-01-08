package to_24_0108_2;

import java.util.Scanner;

/**
 * 1912번. 연속합 - DP 문풀 
 * @author MYLG
 *
 */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int[] arr = new int[N+1];
		int[] dy =  new int[N+1];
		
		for(int i=1; i<=N; i++) arr[i] = kb.nextInt();
		
		dy[1] = Math.max(arr[1], dy[0] + arr[1]);
		for(int i=2; i<=N; i++) {
			//직전합에 현재값 더한 것(=N을 마지막으로 하는 합) vs N부터 시작하는 합 중 큰 값 세팅 
			dy[i] = Math.max(dy[i-1] + arr[i], arr[i]);
		}
		int max = Integer.MIN_VALUE;
		//dy[]에 담긴 값들 중 최대값
		for(int i=1; i<=N; i++) {
			max = Math.max(max, dy[i]);
		}
		
		System.out.println(max);
	}

}
