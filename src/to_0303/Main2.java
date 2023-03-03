package to_0303;

import java.util.Scanner;

/* 3-5. 연속된 자연수의 합 (수학적인 방식으로 접근)
*/
public class Main2 {
	//솔루션 함수 
	public int solution(int n ) {
		int answer = 0, cnt = 1;
		n--; //1 뺐고
		while(n > 0) {
			cnt++; 
			n = n- cnt; //2 뺐고, 3뺐고 ... 답 나올 때까지 뺌
			if(n % cnt == 0) { //답이 나오면 
				answer++;
			}
		}
		return answer;
	}	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		System.out.println(T.solution(n));
	}
}