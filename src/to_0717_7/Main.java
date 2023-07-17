package to_0717_7;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*우선순위 큐 잘 사용할 것 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N =kb.nextInt();//연산 횟수 
		//우선순위 정렬 기준 재정의 
		PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//절대값 기준으로 앞 값이 더 크다면 자리를 바꿔준다.
				if(Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				//절대값 기준으로 두 값이 같다면 음수를 앞으로 보내준다.
				}else if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}else {
					return -1;
				}
			}
		});		
		for(int i =0; i<N; i++) {
			int request = kb.nextInt();
			
			if(request == 0) {
				if(pQ.isEmpty()) {
					System.out.println("0");
				}else {
					System.out.println(pQ.poll());
				}
			}else {
				pQ.add(request);//값을 담고 
			}
		}
	}
}