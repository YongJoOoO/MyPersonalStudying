package to_0331;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 9-4. 최대 수입 스케줄 (PriorityQueue) */ 
class Lecture implements Comparable<Lecture>{
	public int money;
	public int time;
	Lecture(int money, int time){
		this.money = money;
		this.time = time;
	}
	@Override
	public int compareTo(Lecture o) {
		return o.time - this.time; //시간 기준 내림차순 정렬 
	};
}

public class Main1 {
	static int n, max = Integer.MIN_VALUE;
	//솔루션
	public int solution(ArrayList<Lecture> arr) {
		int answer = 0;
		//생성 시 COllections.reverseOrder() 하면 우선순위 높은 순으로 객체 저장된다. 
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		
		//객체 정렬
		Collections.sort(arr);
		int j = 0;
		//역순으로 돌기  
		for(int i = max; i>=1; i--) {
			for(; j<n; j++) {
				if(arr.get(j).time < i) break;
				pQ.offer(arr.get(j).money);
			}
			if(!pQ.isEmpty()) answer += pQ.poll();
		}
		return answer;
	}

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb=  new Scanner(System.in);
		n = kb.nextInt();
		ArrayList<Lecture> arr = new ArrayList<>();
		for(int i =0; i<n; i++) {
			int m = kb.nextInt();
			int d = kb.nextInt();
			arr.add(new Lecture(m, d));
			if(d>max) max = d; //일단 최대 날짜값을 담아주고 
		}
		System.out.println(T.solution(arr));	
	}
}