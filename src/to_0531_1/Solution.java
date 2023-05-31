package to_0531_1;

import java.util.Scanner;

/* 11659번. 구간 합 구하기 4
 * */
public class Solution {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		int[] arr = new int[N+1];
		int[] sum = new int[N+1];
		//구간합 구해야 하는 이유 : 시간 제한 0.5초이므로
		for(int i=0; i<N; i++) {
			arr[i+1] = kb.nextInt();
			//동시에 구간합 구해놓기 
			sum[i+1] = sum[i] + arr[i+1]; //구간 합 
		}
		
		int[] answer = new int[M];
		//i, j 입력 받으면서 구함
		for(int i=0; i<M; i++) {
			int k = kb.nextInt();
			int j = kb.nextInt();
			
			answer[i] = sum[j] - sum[k-1];
		}
		
		//정답 출력
		for(int x : answer) {
			System.out.println(x);
		}
	}

}