package to_0814_6;
//알파코드  
import java.util.*;
class Solution {
	static LinkedList<String> tmp; //임시용
	static int answer;
	
	//DFS
	static void DFS(int st, String s) {
		if(st == s.length()) {//마지막 문자값에 대하여 재귀 들어오면 완성된 거니까 
			 answer++;//값이 끝까지 갔으면 갈 때마다 복귀하면서 answer 누적 
		}else {
			for(int i=st; i<s.length(); i++) {
				String num = s.substring(st, i+1);
				if(Integer.parseInt(num) > 27 || Integer.parseInt(num) < 1) return;//걍 복귀
				tmp.add(num);
				DFS(i+1, s);//그 뒷자리부터 다시 순회
				tmp.pollLast();//마지막에 넣었던 거 다시 뽑기 
			}
		}
	}
	
	public int solution(String s){
		//초기화
		tmp = new LinkedList<>();
		
		DFS(0, s);

		return answer;
	}
		
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