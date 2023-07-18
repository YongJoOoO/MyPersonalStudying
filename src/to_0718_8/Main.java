package to_0718_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*1931번. 회의실 배정 */
class Heai implements Comparable<Heai>{
	int st, ed;
	Heai(int st, int ed){
		this.st = st;
		this.ed = ed;
	}
	@Override
	public int compareTo(Heai o) {
		if(this.ed == o.ed) {//종료 시간 같다면
			return this.st - o.st;//시작 시간 기준 오름차순 
		}
		return this.ed - o.ed;//종료 시간 기준 오름차순 
	}
}
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		
		ArrayList<Heai> arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int a = kb.nextInt();
			int b=  kb.nextInt();
			arr.add(new Heai(a, b));//객체 담고 
		}
		//저 기준대로 정렬 
		Collections.sort(arr);
		
		//그리디 알고리즘 - 종료 시간 기준 정렬 해놓고,선택 한 종료 시간보다 크거나 같은 시작 시간 갖는 애 택 
		int answer= 1;//일단 얘는 한다 생각 하고 카운팅 
		int ed = arr.get(0).ed; //첫번쨰 종료 시간   
		for(int i=1; i<N; i++) {
			if(ed <= arr.get(i).st) {//현재 끝 시간 다음에 올 수 있는 시작 회의 발견 시 
				answer++;//누적 
				ed = arr.get(i).ed;//얘로 갱신
			}
		}
		//정답 출력 
		System.out.println(answer);		
	}
}