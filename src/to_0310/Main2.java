package to_0310;

import java.util.Scanner;
import java.util.Stack;

/* 5-2. 괄호문자 제거
[설명]
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 
남은 문자만 출력하는 프로그램을 작성하세요.
*/
public class Main2 {
	//솔루션 함수
	public String solution(String str) {
		String answer = "";
		Stack<Character> stack = new Stack<>();
		//탐색
		for(char x : str.toCharArray())	{
			if(x == ')') { //닫는 괄호이면 여는 괄호 나올 때까지 pop
				while(stack.pop() != '('); //
			}else { //알파벳 , 여는 괄호이면 무조건 push
				stack.push(x);
			}
		}
		
		//for 탐색 모두 돌고 나와서 남아있는 애들이 살아남은 애들임 
		for(int i = 0; i<stack.size(); i++) {
			answer+=stack.get(i);//answer에 누적시킴
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		
		Scanner kb = new Scanner(System.in);
		
		String str =kb.next();
		System.out.println(T.solution(str));
	}

}