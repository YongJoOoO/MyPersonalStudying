package to_0228;

import java.util.Scanner;

/* 2-5. 소수(에라토스테네스 체) 
 * 
 * [설명] 
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * */
public class Main1 {
	//솔루션 함수
	public int solution(int n) {
		int answer = 0;
		//int [] 배열 타입은 처음 생성시 기본값 0으로 세팅되어 있다. 
		int[] ch = new int[n+1];
		
		for(int i = 2; i<=n; i++) {
			if(ch[i] == 0) {
				answer++; //카운팅
				//현재 찍은 i의 배수 전부 1로 세팅
				for(int j = i; j<=n; j= j + i) { 
							 //j = i의 배수 크기로 증가해야 함
					ch[j] = 1; //세팅 
				}
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		
		Scanner kb = new Scanner(System.in);
		//입력 N
		int n = kb.nextInt();
		
		//출력 
		System.out.println(T.solution(n));
	}
}