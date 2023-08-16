package to_0816_1;
/*DFS- 알파코드 문제 풀이 */
import java.util.*;
class Solution {
	static int len;
	static int answer;
	
	//dfs
	static void DFS(int st, String s ) {//s는 시작 인덱슽 
		if(st == len) { //DFS(5) 호출 시 복귀 
			answer++;
			return;
		}else {
			for(int i=st; i<len; i++) {
				String num = s.substring(st, i+1);
				if(Integer.parseInt(num) < 1 || Integer.parseInt(num) > 27) return;
				
				DFS(i+1, s);//다음으로 더 깊이
			}
		}
	}
	
	//솔루션 함수 
	public int solution(String s){
		
		len = s.length();
		answer = 0;
		DFS(0, s);

		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution("25114"));
		System.out.println(T.solution("23251232"));
		System.out.println(T.solution("21020132"));
		System.out.println(T.solution("21350"));
		System.out.println(T.solution("120225"));
		System.out.println(T.solution("232012521"));
	}
}