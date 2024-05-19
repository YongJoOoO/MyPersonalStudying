package to_240519_1;

import java.util.*;

class Solution{
	
	static int N;
	static List<Integer> want;//각 사람이 원하는 모자 크기 
	static List<Integer> hats;//실제 real 모자 크기 
	
	
	
	//실행 메인
	public static void main(String args[]) throws Exception{

	Scanner kb = new Scanner(System.in);

	int T = kb.nextInt();
	for (int test_case = 1; test_case <= T; test_case++)	{

		N = kb.nextInt();
		want = new ArrayList<>();
		hats = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int tmp = kb.nextInt();
			want.add(tmp);
		}
		
		for(int i=0; i<N; i++) {
			int tmp = kb.nextInt();
			hats.add(tmp);
		}
		
		int max = 0;
		
		for(int i=0; i<N; i++) {//현재 값 
			boolean flag = false;
			int cur = want.get(i);//현재값 
			
			for(int j=0; j<N; j++) {//타겟값 
				//두 값의 차 
				int diff = Math.abs(cur - hats.get(j));
				if(diff <=3) flag = true;//3이하 하나라도 있으면
			}
			
			//현재 i사람은 모자 가질 수 있다.
			if(flag == true) max++;
		}

		
		// 표준출력(화면)으로 답안을 출력합니다.
		System.out.println("#" + test_case + " " + max);
	
	}
	
	kb.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}
}
