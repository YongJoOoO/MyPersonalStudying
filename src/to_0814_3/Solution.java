package to_0814_3;
//유효한 IP 주소 
import java.util.*;
class Solution {
	static LinkedList<String> tmp;
	static ArrayList<String> res;
	//DFS
	static void DFS(int start, String s) {
		if(tmp.size() == 4 && start == s.length()) {
			String Ts = "";
			for(String x : tmp) Ts += x + ".";
			res.add(Ts.substring(0, Ts.length()-1));//마지막 . 제거하려고 
		}else {
			//입력으로 들어온 start 값을 기준으로 s길이 전까지 순회는 하는데 
			for(int i=start; i<s.length(); i++) {	
				//시작점이 0이면서 i>start인 경우 = 02 이런 식으로 0으로 시작하는 두 자리 이상 숫자로 갈 경우 return
				if(s.charAt(start) == '0' && i > start) return;
				//항상 start부터 뽑고 i는 증가함 
				String num = s.substring(start, i+1);//start지점부터 각 i지점까지 뽑기
				if(Integer.parseInt(num) > 255) return; //그냥 복귀하고 
				tmp.add(num);//자른 문자 담고 
				//마지막으로 뽑은 지점부터 start 지점으로 두고 호출 
				DFS(i+1, s);
				//복귀 - 다른 깊이 탐색 하려면 복귀시키고 
				tmp.pollLast();
			}
		}
	}
	
	//솔루션 함수 
	public String[] solution(String s){
		//초기화
		tmp = new LinkedList<>();//임시 배열 
		res = new ArrayList<>();//. 담은 리스트
		
		DFS(0, s); //문자열 그대로 보내고 
		
		//정답 세팅 
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