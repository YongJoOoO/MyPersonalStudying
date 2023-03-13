package to_0313;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 5-7. 교육과정 설계 | 큐 사용
[입력]
첫 줄에 한 줄에 필수과목의 순서가 주어집니다. 모든 과목은 영문 대문자입니다.
두 번 째 줄부터 현수가 짠 수업설계가 주어집니다.
[출력]
첫 줄에 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력합니다.
*/
public class Main3 {
	//솔루션 함수 
	public String solution(String need, String plan ) {
		String answer = "YES";
		Queue<Character> Q = new LinkedList<>();
		
		//필수과목 모두 세팅
		for(char x : need.toCharArray()) Q.offer(x);
		//계획표 돌면서
		for(char x : plan.toCharArray()) {
			if(Q.contains(x)) { //현재의 과목이 필수과목에 존재하면 
				//근데 그 과목이 큐 첫번째 값과 다르면 순서 X : "NO"
				if(x != Q.poll()) return "NO";
			}
		}
		//다 순회했는데도 필수과목에 무언가 남아있으면 이수하지 않은 필수과목 존재하는 것이므로 : "NO"
		if(!Q.isEmpty()) return "NO";
		
		return answer;
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		
		String a = kb.next();
		String b = kb.next();
		
		System.out.println(T.solution(a, b));
	}
}