package to_0717_6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*2164번. 카드2 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		Queue<Integer> Q = new LinkedList<>();
		//값 넣기 
		for(int i=1; i<=N; i++) Q.add(i);
		
		while(Q.size() > 1) {
			//1) 첫장은 버리기 
			Q.poll();
			//2) 그 다음 장은 맨 뒤에 담기 
			Q.add(Q.poll());
		}		
		if(Q.size() == 1) {
			int tmp = Q.poll();
			System.out.println(tmp);//가장 마지막에 남은 카드 출력 
		}
	}
}