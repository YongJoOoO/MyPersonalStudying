package to_0310;

import java.util.Scanner;
import java.util.Stack;

/* 5-1. 올바른 괄호 // 스택 사용 
[입력]
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
[출력]
첫 번째 줄에 YES, NO를 출력한다.
*/
public class Main1 {
	//솔루션 함수
	public String solution(String str) {
		String answer = "YES";
		
		Stack<Character> stack = new Stack<>();
		//str 내부 탐색
		for(char x : str.toCharArray()) {
			if(x == '(') { //여는 괄호이면 
				stack.push(x);
			}else { //닫는 괄호인데 
				//pop 전에도 현 스택이 비어있는 상황이면 X
				if(stack.isEmpty()) return "NO";
				//아니면 현재 스택 top 데이터 pop
				stack.pop(); 
			}
		}
		//for 탐색 모두 돌고도 남아있는 것이 있으면 여는 괄호가 더 많은상태라 안됨 
		if(!stack.isEmpty()) return "NO";

		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}
}