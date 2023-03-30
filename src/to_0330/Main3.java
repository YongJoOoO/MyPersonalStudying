package to_0330;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 9-3. 결혼식 최대 인원  */
class Time1 implements Comparable<Time1>{
	public int time;
	public char state;
	Time1(int time, char state){
		this.time = time;
		this.state = state;
	}
	public int compareTo(Time1 o) {
		//시간이 같으면 상태 기준 오름차순 정렬 
		if(this.time == o.time) return this.state - o.state;
		else return this.time - o.time;
	};
}
public class Main3 {
	//솔루션 
	public int solution(ArrayList<Time1> arr) {
		int answer = Integer.MIN_VALUE;
		
		Collections.sort(arr);//정렬
		//시간 기준 오름차순, 동일 시간에 대해서는 상태 알파벳 순으로 (e -> s) 순 처리
		//현 순간 사람 카운팅용 
		int cnt= 0;
		for(Time1 x : arr) {
			//시작 시간 떄 카운팅하고 
			if(x.state == 's') cnt++;
			else cnt--; //끝나면 빼버림
			answer = Math.max(answer, cnt);//기존 answer 보다 카운팅 클 때 교체
		}
		return answer; 
	}
	
	//메인 실행 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Time1> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int sT = kb.nextInt();
			int eT = kb.nextInt();
			arr.add(new Time1(sT, 's'));
			arr.add(new Time1(eT, 'e'));
		}
		
		System.out.println(T.solution(arr));
	} 
}