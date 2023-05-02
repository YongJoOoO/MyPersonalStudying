package to_0501;

import java.util.*;
/*2164번. 카드 2 */
public class Main {

	//솔루션 함수
	public int solution(int n) {
		int answer= 0;
		Queue<Integer> Q = new LinkedList<>();
		//일단 1~n까지 카드 담고 
		for(int i=1; i<=n; i++) {
			Q.add(i);
		}
		
		while(Q.size() != 1) {
			//1) 맨 앞 값 삭제
			Q.remove();
			//2) 다음 값은 뽑아서 맨 뒤로 보냄 
			Q.add(Q.poll());
		}
		
		answer = Q.poll();
		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		
		System.out.println(T.solution(n));
	}
}