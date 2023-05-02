package to_0502_3;

import java.util.*;
/*10773번. 제로 */
public class Main {
	//솔루션 함수
	public int solution(int n, int[] arr) {
		int answer= 0;
		Stack<Integer> st= new Stack<>();
		
		for(int x : arr) {
			if(x == 0) {
				st.pop();
			}else {
				st.push(x);
			}
		}
	
		for(int x : st) {
			answer += x;
		}
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n= kb.nextInt();
		int[] arr  = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] =  kb.nextInt();
		}
		System.out.println(T.solution(n, arr));
	}
}