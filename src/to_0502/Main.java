package to_0502;

import java.util.*;
/* 9093번. 단어 뒤집기 - 스택 사용 -(1) 답은 맞았는데. 메모리 초과 ㅠ
 * */
public class Main {
	//솔루션 함수 
	public String solution(String str) {
		String answer= "";
		Stack<Character> st = new Stack<>(); 
		
		for(String x : str.split(" ")) {
			
			char[] tmp = x.toCharArray();
			
			for(int i=0; i<tmp.length; i++) {
				st.push(tmp[i]);
			}
			
			while(!st.isEmpty()) {
				answer += st.pop();
			}		
			answer += " ";
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
			
		int tc = Integer.parseInt(kb.nextLine());
		String[] tmp = new String[tc];
		
		for(int i=0; i<tc; i++) {
			tmp[i] = kb.nextLine();
		}
		
		for(int i=0; i<tc; i++) {
			System.out.println(T.solution(tmp[i]));
		}
	}

}