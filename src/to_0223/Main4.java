package to_0223;

/* 1-12. 암호 
 * 비밀 편지 해독 문제 
[입력]
첫 줄에는 보낸 문자의 개수(10을 넘지 안습니다)가 입력된다. 
다음 줄에는 문자의 개수의 일곱 배 만큼의 #또는 * 신호가 입력됩니다.
현수는 항상 대문자로 해석할 수 있는 신호를 보낸다고 가정합니다.

[출력]
영희가 해석한 문자열을 출력합니다.
 
 // 암호는 7개 단위로 하나의 대문자 대체 O 
  1) 암호 -> 2진수 (#=1, *=0) 로 바꾸고
  2) 2진수 -> 10진수 변환 
  3) 아스키 번호 기준으로 10진수 -> 65 문자로 변환시킴 (최종 해석문) 
  
  //받은 문자열을 
   * -> 7개 단위로 잘라서 subString() 끊어 읽고.  -> 2진수 replace() 하고 
   * -> 10진수로 변형하고 -> 아스키에 맞게 문자 변형  
 * */

import java.util.Scanner;

public class Main4 {

	//솔루션 함수 
	public String solution(int n, String s) {
		String answer = "";
		// 글자 개수 n 번 반복 
		for(int i = 0; i<n; i++) {
			//(1) 7개 단위로 뽑고 # = 1, * = 0 변형시킴
			String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
			
			//(2) tmp(String형태) 2진수 를 10진수 num으로 변형 
			int num = Integer.parseInt(tmp, 2); 
				//현재 String tmp를 2진수로 읽어서 10진수 정수형으로 변환시켜 num으로 받아라
			
			//(3) num을 char 강제 형변환 시킨 뒤 answer에 이어붙임
			answer += (char) num;
			
			// 뽑고 난 뒷 내용물은 보존시킴
			s = s.substring(7); 	
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb= new Scanner(System.in);
		//1) 입력
		int n = kb.nextInt();
		String s = kb.next();
		
		//2) 출력
		System.out.println(T.solution(n, s));
		
	}
}