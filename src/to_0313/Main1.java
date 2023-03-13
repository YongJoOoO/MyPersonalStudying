package to_0313;

import java.util.Scanner;
import java.util.Stack;

/* 5-5. 쇠막대기 
[입력]
한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다.
[출력]
잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.
*/
public class Main1 {
	//솔루션 함수
	public int solution(String str) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == '(') //여는 괄호이면 
				stack.push('(');
			else { //닫는 괄호이면 
				stack.pop();//일단 꺼내서
				//(1) 바로 앞자리가 ( 여는 괄호이면 == 레이저이므로
				//스택 사이즈만큼 막대기 잘렸을 거임
				if(str.charAt(i-1) == '(') {
					answer += stack.size();
				}else { //(2)레이저 X==막대기 오르쪽 끝
					answer++; //끝 부분으로 잘린 부분 담기
				}		
			}
		}
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