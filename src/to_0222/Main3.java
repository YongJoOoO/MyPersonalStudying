package to_0222;

import java.util.Scanner;

/* 1-7. 회문 문자열 
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
	문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
	// 단 대소문자 구분 X
 * */

/*
 *  1) 	대소문자 구분안하니까 일단 전부 통일시켜주기 (대문자로)
 *  2)  _ _ _ _ _  (i < len/2) 인 동안 반복
 *  3) 대칭하는 애들끼리 비교하면 됨
 * */

public class Main3 {
	//솔루션 함수 (1) 
	public String solution(String str) {
		String answer = "YES";
		//대소문자 구분X => 통일시켜주기
		str = str.toUpperCase();
		int len = str.length();
		
		for(int i = 0; i <len/2; i++) {
			// 0 1 2 3 이면 0과 3, 1과 2가 비교되어야 함 
			if(str.charAt(i) != str.charAt(len-i-1)) return "NO";
		}
		return answer;
	}
	
	//솔루션 함수 (2) 
	public String solution2(String str) {
		String answer = "NO";
		//reverse 해준 애가 처음이랑 같아도 회문 문자열
		
		String tmp = new StringBuilder(str).reverse().toString(); //뒤집고
		
		if(str.equalsIgnoreCase(tmp)) answer = "YES";
		
		
		return answer;
	}

	//메인 함수
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		//1) 입력 :
		String str = kb.next();
		
		//2) 출력 1
		System.out.println(T.solution(str));
		
		//3) 출력 2
		System.out.println(T.solution2(str));
	}
}