package to_0303;

import java.util.Scanner;

/* 3-5. 연속된 자연수의 합 
[설명]
N입력으로 양의 정수 N이 입력되면 
2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
*/
public class Main1 {
	//솔루션 함수 
	public int solution (int N) {
		int answer = 0, sum = 0, lt= 0;
		int m = N/2+1;
		int[] arr = new int[m];
		for(int i = 0; i<m; i++) {
			arr[i] = i+1;
		}
		
		//two pointers 알고리즘 적용한 실질 로직 
		for(int rt = 0; rt<m; rt++) {
			//1씩 증가하는 rt 따라 sum 누적하면서
			sum += arr[rt];
			if(sum == N) {
				answer++;
			}
			//근데 sum >= n 이 되면 (같을 때도 빼줘야 함 다음 꺼 찾게)
			while(sum >= N) {
				sum -= arr[lt++];
				if(sum == N) answer++;
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T  = new Main1();
		
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		
		System.out.println(T.solution(N));		
	}
}