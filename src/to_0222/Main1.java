package to_0222;

import java.util.Scanner;

/*  1-5. 특정 문자 뒤집기 
 * 	영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,

	특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 * */

// 알파벳 구분 어떻게 할거냐 ? Character.isAlphabetic() 사용
// lt와 rt 가 양끝단에서 ++ 출발하고, 둘다 알파벳일 경우에만 교환이 이루어져야 함
// lt<rt 가 엇갈리면 끝나도록 하면 됨 

public class Main1 {
	//솔루션 함수
	public String solution(String str) {
		String answer = "";
		//일단 입력받은 문자열을 분해 => 각 문자 배열 만들어
		char[] s = str.toCharArray();
		int lt = 0, rt = str.length()-1; //각 포인팅 할 것 
		
		//주요 로직
		 // -> 이 안에서 알파벳 아닌 동안은 계속 ++ --
		while(lt<rt) {
			if(!Character.isAlphabetic(s[lt])) lt++;
			else if(!Character.isAlphabetic(s[rt])) rt--;
			else { //이때 즉, 둘다 알파벳인 경우 swap
				char tmp = s[lt];
				s[lt]= s[rt];
				s[rt] = tmp;
				lt++;
				rt--;
			}
		}
		
		//반환할 String 에 재세팅
		answer = String.valueOf(s); //char[]을 String화 시켜줌
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		// 1) 입력 : 섞인 문자열 입력 받아 
		String str = kb.next();
		
		// 2) 출력 : 알파벳만 뒤집힌 문자열 반환하여 출력함
		System.out.println(T.solution(str));
	
	}
}