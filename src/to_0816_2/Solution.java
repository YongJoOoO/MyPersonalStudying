package to_0816_2;
//RE 풀이 
import java.util.*;
class Solution {
	static int answer;
	static int len;
	//DFS
	static void DFS(int st, String s) {
		if(len == st) {
			answer++;
			return;
		}else {
			for(int i=st; i<len; i++) {
				String num = s.substring(st, i+1);//하나씩 늘어가고
				if(Integer.parseInt(num) < 1 || Integer.parseInt(num) > 27) return;
				DFS(i+1, s);
			}
		}
	}
	
	//솔루션 함수 
	public int solution(String s){
		answer = 0;
		len = s.length();
		
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