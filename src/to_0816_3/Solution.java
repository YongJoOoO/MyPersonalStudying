package to_0816_3;
//알파코드 - DP + DFS 풀이 
import java.util.*;
class Solution {
	static int[] dy;
	//DFS
	static int DFS(int st, String s) {
		if(dy[st] > 0) return dy[st];
		if(st < s.length() && s.charAt(st) == '0') return 0;
		if(st ==  s.length() -1 || st == s.length()) return 1;
		else {
			int res = DFS(st+1, s);
			int tmp = Integer.parseInt(s.substring(st, st+2));
			if(tmp <= 26) res += DFS(st+2, s);
			return dy[st] = res;
		}
	}
	//솔루션 함수
	public int solution(String s){
		dy = new int[101];
		int answer = DFS(0, s);

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