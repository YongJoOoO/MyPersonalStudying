package to_24_0110_1;

import java.util.Scanner;

/**
 * 11053번. 가장 긴 증가하는 부분 수열 - DP 문풀
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
			arr[i] = kb.nextInt();
		}
		
		//dy[N] 정의 : 0~N까지 현재값을 포함하여 만들 수 있는 가장 긴 증가 길이 
		
		dy[1] = 1; //자기 자신에 대한 길이 1
		int answer = 0;
		
		if(N >= 2) {
			if(arr[2] > arr[1]) dy[2] = dy[1] + 1;
			else dy[2] = 1;
		}
		
		for(int i=3; i<=N; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					max = Math.max(max, dy[j]);
				}
			}
			dy[i] = max + 1;
		}
		
		for(int i=1; i<= N; i++ ) {
			answer = Math.max(answer, dy[i]);
		}
		System.out.println(answer);
	}
}