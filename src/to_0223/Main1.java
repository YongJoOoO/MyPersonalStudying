package to_0223;

import java.util.Scanner;

/*
 *  1-9.숫자만 추출
 *  
 *  문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 *  만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
	추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
		( 즉, 첫 0 은 무시함) 
		
		//  1)문자, 숫자 식별  -> 아스키 번호로 구분 
		 * 			 문자형 숫자 는'0': 48 <= x <= '9' : 57 가진다.
		    2) 숫자만 이어붙이고 
		    		방식 1)
		    		answer = answer * 10 + (x - 48) 로 이어붙임
		    		방식 2) 
		    		String 상태에서 isDigit()으로 구분한 뒤 이어붙인 문자열 parseInt로 형변환시킴
		    		
		    3) 리턴
 * */

public class Main1 {

	//솔루션 함수 -(1) 
	public int solution(String str) {
		int answer = 0;
		
		for(char x : str.toCharArray()) {
			if(x >= 48 && x <= 57) answer = answer * 10 + (x- 48);//실제 숫자로 교환됨
		}
		
		return answer;
	}
	//솔루션 함수 -(2)
	public int solution2(String str) {
		String answer = "";
		
		for(char x: str.toCharArray()) { //단순 문자로 취급하므로 첫 시작 0 은 제거해줘야 함
			if(Character.isDigit(x)) {
				answer += x;
			}
		}
		
		return Integer.parseInt(answer) ; // 0208 -> 숫자 208이 된다.
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		
		Scanner kb = new Scanner(System.in);
		//1) 입력 문자열 
		String str = kb.next();
		
		//2) 출력 (1) 
		System.out.println(T.solution(str));
		//3) 출력 (2) 
		System.out.println(T.solution2(str));
	}

}
