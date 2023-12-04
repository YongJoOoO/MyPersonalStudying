package to_1204_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 4949번. 균형잡힌 세상 - 스택 활용 문풀
 * @author MYLG
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str;
		
		while(true) {		
			str = in.nextLine();
			
			if(str.equals(".")) break;	
			
			System.out.println(solve(str));
		}
	
	}
	
	public static String solve(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);	// i 번째 문자 
			
			// 여는 괄호일 경우 스택에 push 
			if(c == '(' || c == '[') {
				stack.push(c);
			}else if(c == ')') {	
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}else {
					stack.pop();
				}
			}else if(c == ']') {
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}else {
					stack.pop();
				}
			}
		}	
		if(stack.empty()) {
			return "yes";
		}
		else {
			return "no";
		}
	}
}