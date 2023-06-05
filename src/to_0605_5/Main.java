package to_0605_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*11286번. 절댓값 힙 구현하기 */
public class Main {
	//정적변수로 입출력 변수 세팅 
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	//실행 메인 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int n = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> pQ = new PriorityQueue<>((o1, o2) -> {
	      int first_abs = Math.abs(o1);
	      int second_abs = Math.abs(o2);
	      if (first_abs == second_abs)
	        return o1 > o2 ? 1 : -1;// 절대값이 같은 경우 음수 우선 정렬
	      else
	        return first_abs - second_abs;// 절대값을 기준으로 정렬
	    });
		
		for(int i =0; i<n; i++) {
			int request = Integer.parseInt(bf.readLine());
			if(request == 0) {
				if(pQ.isEmpty()) {
					System.out.println("0");
				}else {
					System.out.println(pQ.poll());
				}
			}else {
				pQ.add(request);
			}
		}
	}
}