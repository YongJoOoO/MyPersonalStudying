package to_0615_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*백준 1946번. 신입 사원 - 그리디 문풀
 * 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙
 * 즉, 둘다 떨어지는 지원자는 탈락시킨다. 
 * 그러므로 성적 순 정렬시켜놓고, 선발시킨 '현재'만 기준으로 생각 (그리디)
 * 현재 뽑은 사람의 면접 점수를 기준 점수로 갱신시켜놓고
 * 이 점수보다 뒤쳐지면. 그 지원자는 탈락시키는 식으로 뽑는다. 
 * 왜냐하면 성적순으로 이미 정렬시켜놓았기 때문에.
 *  현재 사람보다 면접이 떨어진다. == 성적도 면접도 둘다 떨어진다 이기 때문
 * */

class Sawon implements Comparable<Sawon>{
	int sj;
	int mj;
	Sawon(int sj, int mj){
		this.sj = sj;
		this.mj = mj;
	}
	@Override
	public int compareTo(Sawon o) {
		// TODO Auto-generated method stub
		return this.sj - o.sj;//성적 기준 오름차순 정렬 
	}
}
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner (System.in);
		
		int T = kb.nextInt();
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int t=0; t<T; t++) {
			ArrayList<Sawon> arr = new ArrayList<>();
			int n = kb.nextInt();
			
			for(int i=0; i<n; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				arr.add(new Sawon(a, b));
			}
			Collections.sort(arr);
			
			int cnt = 1;
			int pivot = arr.get(0).mj;//첫 번째 인간 성적 기준으로 두고 
			
			for(int i=1; i<arr.size(); i++) {
				if(pivot < arr.get(i).mj) continue;
				
				cnt++;
				pivot = arr.get(i).mj;
			}
			answer.add(cnt);
			
		}
		
		for(int x : answer) System.out.println(x);
	}
}