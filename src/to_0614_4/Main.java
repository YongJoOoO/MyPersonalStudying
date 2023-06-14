package to_0614_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 1931번. 회의실 배정하기 */
class Time implements Comparable<Time>{
	int s; //시작 시간 
	int e; //끝 시간 
	Time(int s, int e ){
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Time o) {
		// TODO Auto-generated method stub
		if(this.e == o.e){//만약 종료시간이 두 객체 모두 같다면.
			return this.s - o.s;//빠른 시작 시간 우선 
		}
		return this.e - o.e; //기본적으로 빠르종료 시간 우선 정렬 
	}
}
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt(); //회의실 개수 
		ArrayList<Time> arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			arr.add(new Time(a, b)); //객체에 담고 
		}
		int cnt =0;
		//재정의한 기준으로 정렬
		Collections.sort(arr);
		//기본 종료 시간은 0 으로 세팅해놓고 
		int et = 0;
		
		for(Time x : arr) {
			if(x.s >= et) { //종료시간 기준 정렬된 상태에서 가장 먼저 나타난 시작시간 회의를 발견시 
				cnt++;//회의 배정++
				et = x.e;//현재 선택한 회의의 종료시간으로 et를 갱신
			}		
		}
		System.out.println(cnt);		
	}
}