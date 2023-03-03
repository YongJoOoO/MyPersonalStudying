package to_0221;

import java.util.Scanner;

// 1-2. 대소문자 변환
/*
 *  설명 ; 대소문자 혼합 존재 문자열 입력 받고 
 *  대 -> 소, 소 -> 대 변환시켜 출력시키는 프로그램 작성하라
 *  
 *  입력 : 첫 줄 문자열 입력, (길이 100이하, 영어로만 구성)
 *  출력 : 첫 줄에 변환된 문자열 출력 
 *
 * */

public class Main2 {	
	//솔루션 함수 
	public String solution(String str) {
		String answer = "";
		// toCharArray : String -> char 배열로 만듬
		for(char x : str.toCharArray()) {
			//각각의 요소 대소문자 구분시켜서 바꿔주기
			
			//1) 소문자이면 => 대문자로 변경
			if(Character.isLowerCase(x)) answer += Character.toUpperCase(x);
			
			//2) 대문자이면 => 소문자로 변경
			else answer += Character.toLowerCase(x);
		}
		
		return answer;
	}
	
	//실행 메인 (입력 애들 세팅, 출력)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		//입력 규격 맞추기 
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		//곧장 출력
		System.out.println(T.solution(str));
	}

}