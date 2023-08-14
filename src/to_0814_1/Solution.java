package to_0814_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

//팰린드롬 경우 수 
class Solution {
	static Deque<Character> dq;
	static ArrayList<String> res;
	static HashMap<Character, Integer> map;
	static int len;
	
	//dfs
	static void DFS() {
		if(dq.size() == len) { //dq가 len길이만큼 완성되면 
			String Ts = "";
			for(char x : dq) Ts += x; 
			res.add(Ts);//리스트에 담음 - 답 복제용
		}else {
			//해쉬맵 순회하면서 
			for(char key : map.keySet()) {
				if(map.get(key) == 0) continue;//건너뜀
				//하나의 key에 대하여 
				//1) 앞에 담고 
				dq.addFirst(key);
				//2) 뒤에 담고
				dq.addLast(key);
				map.put(key, map.get(key)-2);//두 번 담았으니까 빼주고
				DFS();//재귀 호출 
				//1) 복귀하면서 앞에 문자 빼고 
				dq.pollFirst();
				//2) 복귀하면서 뒤에 문자 빼고
				dq.pollLast();
				map.put(key, map.get(key)+2);//개수 복귀 
			}
		}
	}
	
	//솔루션 함수 
	public String[] solution(String s){
		//초기화
		dq = new LinkedList<>();
		res = new ArrayList<>();
		map = new HashMap<>();
		len = s.length();
		
		//각 문자 구성별 빈도수 체크
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) +1);
		}
		//1) 애초에 팰린드롬 가능한 구성인지 확인 
		//빈도수 홀수개, 짝수개인지 따라 
		int odd = 0;
		char mid = '#';//임시 초기화 
		
		for(char key : map.keySet()) {
			if(map.get(key) % 2 == 1) { //빈도수 홀수개인지 
				mid = key;//일단 그 키로 세팅
				odd++;//홀수개의 빈도수 문자 개수 카운팅 
			}
		}
		//홀수 빈도 갖는 문자 1개 이상인 경우 어차피 팰린드롬 못 만듬
		if(odd > 1) return new String[] {}; //여기서 빈 문자열 리턴 
		
		if(mid != '#') { //위에서 갱신된 홀수개 문자가 1개 있던지 or 없던지 해서 갱신된 상태면 
			dq.add(mid);//데크 가운데에 1개만 담고 
			map.put(mid, map.get(mid)-1);//빈도수 -1
		}
		//호출
		DFS();
		
		//정답 세팅
		String[] answer = new String[res.size()];
		
		for(int i=0; i<res.size(); i++) { //ArrayList에 담아뒀던 각 String 값 넘겨주기 
			answer[i] = res.get(i);
		}

		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution("aaaabb")));	
		System.out.println(Arrays.toString(T.solution("abbcc")));
		System.out.println(Arrays.toString(T.solution("abbccee")));
		System.out.println(Arrays.toString(T.solution("abbcceee")));
		System.out.println(Arrays.toString(T.solution("ffeffaae")));
	}
}

