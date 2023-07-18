package to_0718_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//신입 사원 
class Sawon implements Comparable<Sawon>{
	int s;//서류
	int m;//면접
	Sawon(int s, int m){
		this.s= s;
		this.m = m;
	}
	@Override
	public int compareTo(Sawon o) {
		// TODO Auto-generated method stub
		if(this.s == o.s) {
			return this.m - o.m;//같으면 면접 오름차순 정렬 
		}
		return this.s-o.s;//성적 등수 기준 오름차순 정렬 
	}
}
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int T = kb.nextInt();
		ArrayList<Integer> answer= new ArrayList<>();//정답용 
		
		for(int t = 0; t<T; t++) {
			int N = kb.nextInt();//사람 수 
			ArrayList<Sawon> arr = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				arr.add(new Sawon(a, b));//성적, 면접 담기 
			}
			//아까 기준대로 정렬시킴
			Collections.sort(arr);
			int cnt= 1;
			int target = arr.get(0).m;
			//그리디 - 서류 높은 순서대로 니까. 이제 현재 애보다 면접 등수 낮으면 탈락 
			for(int i=1; i<N; i++) { //뒤부터 돌면서 
				if(target > arr.get(i).m) { //타겟보다 더 높은 면접 점수 갖는 애 발견 시 
					cnt++;
					target = arr.get(i).m;//면접 기준 점수 갱신 
				}
			}
			//정답 세팅 
			answer.add(cnt);//현재 카운팅
		}
		//답 출력 
		for(int x : answer )System.out.println(x);
	}
}