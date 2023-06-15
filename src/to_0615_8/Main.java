package to_0615_8;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 26215번. 눈 치우기 
 * */
public class Main {
	//실행 메인 		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		//큰수 내림차순 으로 우선순위 큐에 담고 
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++) {
			int tmp = kb.nextInt();
			pQ.add(tmp);
		}
		
		long time = 0;
		
		while(!pQ.isEmpty()) {
			if(pQ.size() >= 2) {
				time++;
				int a = pQ.poll();
				int b = pQ.poll();
				if(a == 0) {
					pQ.add(b-1);
				}else if(b == 0) {
					pQ.add(a-1);
				}else {
					pQ.add(a-1);
					pQ.add(b-1);
				}
			}else if(pQ.size() == 1) {
				int a = pQ.poll();
				if(a == 0) {
					break;
				}
				time++;
				pQ.add(a-1);
			}
			
			if(time > 1440) {
				time = -1;
				break;
			}
		}
		System.out.println(time);
		
	}
}