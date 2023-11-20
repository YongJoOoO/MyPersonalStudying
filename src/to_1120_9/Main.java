package to_1120_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 1946번. 신입사원 - 그리디 
 * @author MYLG
 *
 */
class Sawon implements Comparable<Sawon>{
	int s, m;
	Sawon(int s, int m){
		this.s = s;
		this.m = m;
	}
	@Override
	public int compareTo(Sawon o) {
		// TODO Auto-generated method stub
		return this.s - o.s;//서류 오름차순 정렬
	}
}

public class Main {
	static int TC;
	static int N;
	static List<Sawon> arr;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		TC = kb.nextInt();
		List<Integer> answer = new ArrayList<>();
		
		for(int t = 0; t<TC; t++) {
			N = kb.nextInt();
			
			arr = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				int s = kb.nextInt();
				int m = kb.nextInt();
				arr.add(new Sawon(s, m));
			}
			
			Collections.sort(arr);
			//그리디s
			int cutLine = arr.get(0).m;///서류 1등의 면접 점수가 커트라인이 됨
			int cnt = 1;
			for(int i=1; i<N; i++) {
				//키는 이미 뒤떨어진 상태에서 면접 순위도 밀린다. == 탈락 
				if(cutLine < arr.get(i).m) continue;//탈락 
				cnt++;
				cutLine = arr.get(i).m;//
			}
			
			answer.add(cnt);
		}
		
		//답 출력 
		for(int x : answer) {
			System.out.println(x);
		}
		
	}

}
