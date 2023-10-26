package to_1026_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 1931번. 회의실 배정 - 그리디 문풀 
 * @author MYLG
 *
 */
class Room implements Comparable<Room>{
	int s, e;//시작, 끝 시간 
	Room(int s, int e){
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Room o) {
		// TODO Auto-generated method stub
		if(this.e == o.e) {
			return this.s - o.s;
		}
		return this.e- o.e;//종료 기준 오름찬순 
	}
}
public class Main {
	static int N;
	static ArrayList<Room> arr;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			//담기
			arr.add(new Room(s, e));
		}
		
		Collections.sort(arr);	
		
		//끝시간을 기준으로 오름차순 정렬된 상태에서 
		int E = arr.get(0).e; //가장 먼저 끝나는 일정을 뽑아두고 
		int answer = 1;
		for(int i=1; i<N; i++) { 
			//현재 끝<=시작인 다음 회의를 찾아서, 
			if(E <= arr.get(i).s) {
				answer++; //++처리 후 
				E = arr.get(i).e;//끝 시간을 갱신하면 
				//어쨋거나 가장 먼저 시작하는 회의 시간을 기준으로 가장 max인 개수가 나오게 된다 이거임
			}
		}	
		System.out.println(answer);
	}
}