package to_0223;

import java.util.Scanner;

/*
 *  1-11. 문자열 압축
 *  알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
	문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
	단 반복횟수가 1인 경우 생략합니다. 
	
	cnt = 반복횟수 카운팅 변수
	배열로 받아서 각 문자 i, i+1 지칭하는 애가 1) 같은 문자인 경우, cnt++ 
									2) 다른 문자인 경우, 반복 끝났으니 
								반환 answer에 [현 i 지칭 문자 + cnt(반복횟수)]붙이기
								 다시 cnt = 1 재세팅
 * */
public class Main3 {
	public String solution(String s) {
		String answer = "";
		s += " "; //뒤에 빈 문자 하나 덧붙여줄 것 (왜냐면 다를 때만 현 문자 출력하니까)
		int cnt = 1; //최소 1번은 반복되니
		
		for(int i = 0; i<s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) cnt++;
			else {
				answer += s.charAt(i);
				if(cnt > 1) { //반복 횟수 1은 생략하므로
					answer += String.valueOf(cnt);
					cnt = 1;//다시 초기화
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		System.out.println(T.solution(str));
	}
}