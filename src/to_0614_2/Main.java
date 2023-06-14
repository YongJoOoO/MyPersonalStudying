package to_0614_2;

import java.util.PriorityQueue;
import java.util.Scanner;

/* 1715번. 카드 정렬하기 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();//최초 카드 묶음의 개수
		//데이터값 자동 오름차순 정렬될 우선순위 큐에 값 저장시킬 것 
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int data = kb.nextInt();
			pq.add(data);
		}		
		int sum = 0;//비교 횟수 합 더할 것 
		while(pq.size()!=1) { //내부 카드묶음 1개 되면 더이상 비교 불가하므로
			int a = pq.poll();//첫 데이터 뽑고
			int b = pq.poll();//다음 데이터 뽑고 
			sum += a+b;//두 데이터 묶음을 sum에 누적 
			//합친 카드묶음은 새 데이터로 우선순위큐에 저장
			pq.add(a+b);
		}
		//탈출한 sum 이 최종 답
		System.out.println(sum);
	}
}