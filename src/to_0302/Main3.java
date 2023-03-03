package to_0302;

import java.util.Scanner;

/* 3-3. 최대 매출 (sliding window 알고리즘 사용)
[입력]
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
[출력]
첫 줄에 최대 매출액 출력 
*/
public class Main3 {
	//솔루션 함수 
	public int solution(int n, int k, int[] arr) {
		int answer = 0, sum = 0;
		
		//최초의 연속3개 합 세팅해놈
		for(int i =0; i < k; i++) {
			sum += arr[i];
		}
		answer = sum; //일단 초기화 저장시켜놓고 
		
		//sliding window
		//남은 뒷부분을 다시 for 돌면서 창 밀고 나가고 (민 만큼 앞 부분 빼고)
		for(int i = k; i<n; i++) {
			sum += (arr[i] - arr[i-k]); //민 만큼 더하고 (밀린 부분 빼고)
			answer = Math.max(answer, sum); //더 큰 값으로 세팅 
		}
		return answer;
	}
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		//입력 
		int n = kb.nextInt();
		int k = kb.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		//출력 
		System.out.println(T.solution(n, k, arr));
		
	}
}