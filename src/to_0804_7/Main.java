package to_0804_7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2164번. 카드게임 
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();
		
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			Q.add(i);
		}
		
		while(Q.size() > 1) {
			Q.poll();//그냥 버리고 
			Q.add(Q.poll());//그 다음 꺼는 뒤에 밀고 
		}
		
		if(Q.size() == 1) {
			//가장 마지막에 남은 1장은 무엇인고
			System.out.println(Q.poll());
		}
	}

}
