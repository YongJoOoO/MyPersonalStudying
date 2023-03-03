package to_0302;

import java.util.Scanner;

/* 3-4. 연속 부분수열 
[입력]
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
[출력]
첫째 줄에 경우의 수를 출력한다.
*/
public class Main4 {

	//솔루션 함수 
	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		//lt = 0 찍어놓고 
		int lt = 0, sum = 0;
		//rt 확장시키면서 그 구간의 sum을 비교 m과 비교함
		for(int rt = 0; rt <n; rt++) {
			sum += arr[rt];
			if(sum == m) answer++;
			//for이 아니라 while을 돌리는 이유
				//[11115] 일 경우 sum==6될때까지 lt가 연속 증가 가능하도록 
			while(sum >= m) {
				sum -= arr[lt++];
				if(sum == m) answer++;
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.println(T.solution(n, m, arr));
	}
}