package to_1204_3;

import java.util.Scanner;
import java.util.Stack;

/**
 * 백준 3986번. 좋은 단어 - 스택 활용
 * @author MYLG
 *
 */
public class Main {
	static int count;
	//solution
	static void solution(String str) {
		
		Stack<Character> stack = new Stack<>();
		stack.push(str.charAt(0));
		int idx = 1;
		while(idx != str.length()) {
			char c = str.charAt(idx);
			idx++;
			if(!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			}else {
				stack.push(c);
			}
		}
		
		if(stack.isEmpty()) count++;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		
		int N = kb.nextInt();
		count = 0;
		
		for(int i=0; i<N; i++) {
			String tmp = kb.next();
			if(tmp.length() % 2 ==0) {
				solution(tmp);
			}
		}
		
		System.out.println(count);
	}
}