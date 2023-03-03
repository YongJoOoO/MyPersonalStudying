package back_0228_2;

import java.util.Scanner;
/* 백준 8393번. 합
 * [설명] n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
 * */

public class Main {
	//솔루션 함수 
	public int solution(int n) {
		int answer = 0;
		
		for(int i = 1; i<= n;i++) {
			answer += i;
		}
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		
		System.out.println(T.solution(n));
	}
}