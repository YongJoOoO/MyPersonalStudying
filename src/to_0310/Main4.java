package to_0310;

import java.util.Scanner;
import java.util.Stack;

/* 5-4. 후위식 연산 (postfix)  */
public class Main4 {
	//솔루션 함수
	public int soluiton( String str) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		//탐색
		for(char x : str.toCharArray()) {
			if(Character.isDigit(x)) { //숫자 만나면
				stack.push(x-48); //숫자 변형 후 push
			}else { //연산자 만나면 
				int rt = stack.pop();
				int lt = stack.pop();
				if(x == '+') stack.push(lt + rt);
				else if(x == '-') stack.push(lt - rt);
				else if(x == '*') stack.push(lt * rt);
				else if(x == '/') stack.push(lt/rt);
			}
		}
		//탐색 끝나면 결과만 스택에 남아있다.
		answer = stack.get(0);	
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		
		String str = kb.next();
		System.out.println(T.soluiton(str));
	}
}