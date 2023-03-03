package to_0222;

import java.util.Scanner;

/* 1-8. 유효한 팰린드롭
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
알파벳 이외의 문자들의 무시합니다.
*/
public class Main4 {
	//솔루션 함수
	public String solution(String str) {
		String answer = "NO";
		// 1) 대소문자 통일 + 알파벳 제외 글자는 모두 "" 공백으로 대체해라
		// 알파벳만 검사해야 하므로
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		// 2) reverse 시키기 
		String tmp = new StringBuilder(str).reverse().toString();
		//3) 처음 vs reverse 시킨 것 비교할 것 
		if(str.equals(tmp)) answer = "YES";
				
		return answer;
	}
	
	//메인 함수 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		
		//1) 입력
		String str = kb.nextLine(); 
		//2) 출력
		System.out.println(T.solution(str));
	}
}