package to_0306;

import java.util.Scanner;

/* 3-6. 최대 길이 연속 부분 순열 ** 어려움 ㅠㅠ
[입력]
첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000), k가 주어집니다.
두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
[출력]
첫 줄에 최대 길이를 출력하세요.
*/
public class Main1 {
	//솔루션 함수
	public int solution(int n, int k, int[] arr) {
		int answer = 0, cnt = 0, lt=0;
		
		for(int rt = 0; rt<n; rt++) {
			if(arr[rt] == 0) cnt++;
			while(cnt>k) {
				if(arr[lt] == 0) cnt--;
				lt++;
			}
			answer = Math.max(answer, rt-lt+1);//최대 길이로 갱신 
		}
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(n, k, arr));
	}
}