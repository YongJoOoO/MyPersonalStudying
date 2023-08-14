package to_0814_5;
import java.util.*;
//IP 주소 다시 풀기 
class Solution {
	static LinkedList<String> tmp;
	static ArrayList<String> res;
	
	//DFS
	static void DFS(int st, String s) {
		if(tmp.size() == 4 && st == s.length()) {
			String Ts = "";
			for(String x : tmp) Ts += x + ".";
			res.add(Ts.substring(0, Ts.length()-1));//마지막 값은 .을 빼야하니까 
		}else {
			for(int i=st; i<s.length(); i++) {
				if(s.charAt(i) =='0' && st < i) return;///0으로 시작하는 두자리 이상 값은 안되니까
				String num = s.substring(st, i+1);//항상 i번쨰까지 값으로 세팅해서 자르고
				if(Integer.parseInt(num) > 255) return;//넘어가는 값은 걍 복귀시킴
				tmp.add(num);//가능하면 담고
				DFS(i+1, s);//마지막에 끝난 자리 부터 다시 탐색 
				tmp.pollLast();//복귀 시 마지막 값 떼고 복귀 
			}
		}
	}
	
	//솔루션 함수 
	public String[] solution(String s){
		//초기화
		tmp = new LinkedList<>();
		res = new ArrayList<>();
		
		DFS(0, s);//시작 0 부터 
		
		String[] answer = new String[res.size()];
		for(int i=0; i<res.size(); i++) answer[i] = res.get(i);
		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution("2025505")));	
		System.out.println(Arrays.toString(T.solution("0000")));
		System.out.println(Arrays.toString(T.solution("255003")));
		System.out.println(Arrays.toString(T.solution("155032012")));
		System.out.println(Arrays.toString(T.solution("02325123")));
		System.out.println(Arrays.toString(T.solution("121431211")));
	}
}