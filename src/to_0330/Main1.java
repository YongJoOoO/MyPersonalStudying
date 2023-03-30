package to_0330;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 9-1. 씨름 선수 
 * A와 다른 모든 선수 비교하며 (키 & 무게) 모두 높은 애만 선발/모두 낮으면 탈락시킴 */

class Body implements Comparable<Body>{
	public int h, w;
	Body(int h, int w){
		this.h = h;
		this.w = w;
	}
	//객체 비교 메소드 
	public int compareTo(Body o) {
		return o.h - this.h; //키 기준 내림차순이 됨
		//A기준 오름차순 : this.A - 대상.A
		//A기준 내림차순 : 대상.A - this.A
	};
}

public class Main1 {
	//솔루션 함수 
	public int solution(ArrayList<Body> arr, int n) {
		int cnt = 0;
		Collections.sort(arr); //내림차순 객체 정렬 
		int max = Integer.MIN_VALUE;
		//이미 키 기준 정렬되어 있기 때문에 
		//다음 순서대로 돌면서 기준 max보다 큰값이 나오면 카운팅한다. (선발)
		//기준 max보다 작은 애들이 나오면 탈락인 이유는 
		//이미 키 기준 후순위인데, 몸무게까지 낮은 상황이기 때문임
		for(Body ob : arr) { //키 기준 내림차순 정렬된 애 하나씩 뽑아와서
			//몸무게만 비교하면됨. 
			if(ob.w > max) {
				max = ob.w;
				cnt++;
			}
		}
		return cnt;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Body> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int h = kb.nextInt();
			int w = kb.nextInt();
			arr.add(new Body(h,w));
		}
		System.out.println(T.solution(arr, n));
	}

}