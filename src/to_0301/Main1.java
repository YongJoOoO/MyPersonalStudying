package to_0301;

import java.util.Scanner;

/* 2-9. 격자판 최대합 
[입력]첫 줄에 자연수 N이 주어진다.(2<=N<=50)
	두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 
	각 자연수는 100을 넘지 않는다.
[출력]최대합 출력
*/
public class Main1 {
	//솔루션 함수 
	public int solution(int n, int[][]arr) {
		int answer = Integer.MIN_VALUE;
		int sum1, sum2;
		
		//1) 행의 합, 열의 합 한번에 구하기 
		for(int i = 0; i<n; i++) {
			sum1 = sum2 = 0;
			for(int j = 0; j<n; j++) {
				//각 행의 합 
				sum1 += arr[i][j];
				//각 열의 합
				sum2 += arr[j][i];
			}
			// answer에는 더 큰 값이 비교된 뒤 저장됨
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}
		//2) 두 대각선의 합 (sum1. sum2)
		sum1 = sum2 = 0;
		for(int i=0; i<n; i++) {
			//왼쪽 대각선 합 
			sum1 += arr[i][i];
			//오른쪽 대각선 합
					//주의 n에 따라 값이 달라져야 하므로 n-i-1 처리해야함
			sum2 += arr[i][n-i-1];
			
			// answer에는 더 큰 값이 비교 후 저장됨
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		//입력
		int n = kb.nextInt();
		int[][] arr = new int[n][n];

		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		//출력
		System.out.println(T.solution(n, arr));
	}
}