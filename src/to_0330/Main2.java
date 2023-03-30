package to_0330;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 9-2. 회의실 배정 */
class Time implements Comparable<Time>{
	public int s, e; //시작, 끝 시간
	Time(int s, int e){
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Time o) {
		// TODO Auto-generated method stub
		//만약 끝 시간이 같은 경우
		if(this.e == o.e) {
			return this.s - o.e; //시작시간 기준 오름차순 정렬
		}
		else return this.e - o.e;//기본적으로 끝 시간 기준 오름차순 정렬 
	}
}

public class Main2 {
	//솔루션 함수 
	public int solution(ArrayList<Time> arr, int n) {
		int cnt= 0;
		//정렬
		Collections.sort(arr);
		
		int et = 0; //끝나는 시간을 최소로 잡아두고 
		for(Time ob : arr) {//하나씩 꺼내오는데
			//꺼낸 회의의 시작시간이 기존 끝나는 회의 시간보다 크다면 회의 가능
			if(ob.s >= et) {
				cnt++; //카운팅
				et = ob.e; //끝나는 시간 = 현재 선택한 회의 끝 시간 
			}
		}
		return cnt;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		int n= kb.nextInt();
		ArrayList<Time> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			arr.add(new Time(s, e));
		}
		
		System.out.println(T.solution(arr, n));		
	}
}