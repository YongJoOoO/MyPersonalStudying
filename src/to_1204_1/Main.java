package to_1204_1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 1874번. 스택 수열 - 스택 활용 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int T;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		int temp = 1;
		boolean flag = false;
		
		T = kb.nextInt();
		for(int i=0; i<T; i++) { //T개의 숫자 들어오고 
			int N = kb.nextInt();
			
			for(; temp <= N; temp++) {
				stack.push(temp);
				sb.append("+").append("\n");
			}
			
			if(stack.peek() == N) {
				stack.pop();
				sb.append("-").append("\n");
			}else {
				flag = true;
			}
		}
		
		if(flag ) System.out.println("NO");
		else System.out.println(sb);
	}
}