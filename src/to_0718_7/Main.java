package to_0718_7;

import java.util.PriorityQueue;
import java.util.Scanner;

/*1715번. 카드 정렬하기 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();//묶음 개수 
		int[] arr= new int[N];
		for(int i=0; i<N; i++) arr[i] = kb.nextInt();
		//우선순위 큐 자동 오름차순 정렬 
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			pQ.add(arr[i]);//자동 우선순위 정렬 될건데 
		}
		int answer = 0;
		
		while(pQ.size() != 1){
		 	int a = pQ.poll();
		 	int b = pQ.poll();
		 	answer += (a+b);
		 	pQ.add(a+b);//다시 담기 
		}
		System.out.println(answer);
	}
}