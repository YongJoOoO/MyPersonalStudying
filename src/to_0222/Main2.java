package to_0222;

import java.util.Scanner;

/* 1-6. 중복 문자 제거 
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
	중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
	 
	 중복 여부 검사 어떻게 할거냐 ?
	 		// 현재의 위치값 i == 해당 문자 첫 발견한 위치 indexOf(문자) 같으면 중복 X
			// 현재 위치와 첫 발견위치가 다르면 ==> 무시하고 같을 때만 쌓아서 반환하면 된다.
			//indexOf()는 처음으로 발견된 문자의 위치를 보여줌
 * */

public class Main2 {
	//솔루션 함수
	public String solution(String str) {
		String answer = "";
		for(int i = 0; i<str.length(); i++) {
			if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i); //이때만 누적시키면 됨
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		// 1) 입력
		String str = kb.next();
		// 2) 출력 
		System.out.println(T.solution(str));
	}
}