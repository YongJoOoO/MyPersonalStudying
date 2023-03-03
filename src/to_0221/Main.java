package to_0221;

import java.util.Scanner;

// 섹션 1-1 문자 찾기 
//한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.

//대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.

//입력 : 첫 줄 문자열 , 두 번째줄 문자 입력
//출력 : 첫 줄의 문자열 속에서 두 번째 '문자' 포함된  [문자 개수]를 출력한다.

public class Main {	
	//솔루션 함수 (문자열, 문자) => 포함 개수 리턴 
	public int solution(String str, char t) {
		int answer = 0;
		
		//대소문자 구분 X => 하나의 문자로 통일 시켜놓고
		str = str.toUpperCase();
		t = Character.toUpperCase(t);
		
		//이제 실질적 카운팅 (1) 
		for(int i = 0 ; i <str.length(); i++) {
			if(str.charAt(i) == t) {
				answer++;
			}
		}

		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		
		Scanner kb = new Scanner(System.in);
		//1) 문자열 입력
		String str = kb.next();
		//2) 문자 입력 
		char c = kb.next().charAt(0); //한 문자 가져오기
		
		//솔루션 리턴값 출력
		System.out.println(T.solution(str, c));
	}

}