package to_0614_3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*1744번. 수 묶어서 최대 만들기 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int N = kb.nextInt();
		//유형별 수 나눔
		//양수는 큰수 우선 -> 역순(내림차순)
		PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
		//음수는 작은 수 우선 -> 더 작은 수 끼리 곱이 더 크므로 (오름차순)
		PriorityQueue<Integer> minusQ = new PriorityQueue<>();
		
		//0과 1은 카운팅
		int zero =0;
		int one =0;
		
		//입력 받기 
		for(int i=0; i<N; i++) {
			int input = kb.nextInt();
			if(input == 1) one++;
			else if(input ==0) zero++;
			else if(input > 1) plusQ.add(input);
			else if(input <0) minusQ.add(input);
		}
		
		int sum = 0;//얘가 최대가 되어야 함
		//1) 양수들은 최댓값 우선 뽑아서 곱한 뒤 해결 
		
		while(plusQ.size() > 1) { //짝수이면 지들끼리 곱한 뒤 합하면 됨
			int a = plusQ.poll();
			int b = plusQ.poll();
			sum += (a*b);
		}
		//만약 홀수개라 마지막에 1개 남은 경우 
		if(!plusQ.isEmpty()) {
			int x = plusQ.poll();
			sum += x;
		}
		
		//2) 음수 처리 
		while(minusQ.size() > 1 ) {
			int a = minusQ.poll();
			int b = minusQ.poll();
			sum += (a*b);
		}
		if(!minusQ.isEmpty()) {
			int x = minusQ.poll();
			if(zero >= 1) {
				sum += (0 * x);
				zero--;
			}else {
				sum += x;
			}
		}
		//3) 남은 1 처리 
		sum += one;
		
		//최종 최댓값 출력 
		System.out.println(sum);
	}
}