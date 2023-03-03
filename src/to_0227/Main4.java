package to_0227;

import java.util.Scanner;

/* 2-4. 피보나치 수열 
 *  1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
	2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 * */
public class Main4 {
	//솔루션 함수 
	public int[] solution (int n) {
		int[] answer = new int[n];
		//초기화 a1, a2 = 1
		answer[0] = 1; answer[1] = 1;
		
		for(int i = 2; i<n; i++) {
			answer[i] = answer[i-2] + answer[i-1];
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		//입력
		int n = kb.nextInt();
		//출력
		for(int x : T.solution(n) ) System.out.print(x + " ");
	}
}