package to_0605_4;

import java.util.*;

/* 2164번. 카드 게임 
 * */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();//카드 개수
		
		Queue<Integer> queue = new LinkedList<>();
		//1~n까지 차례로 큐에 세킹 
		for(int i=1; i<=n; i++) queue.add(i);
		
		while(queue.size() > 1) { //1보다 사이즈 큰 동안 반복 
			//1) 맨 앞 카드 제외
			queue.poll();
			//2)다음 카드 빼서 뒤에 담기 
			queue.add(queue.poll());
		}
		//최후 남은 카드 출력 
		System.out.println(queue.poll());
		
	}

}