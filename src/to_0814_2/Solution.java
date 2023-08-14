package to_0814_2;
//팰린드롬 RE
import java.util.*;
class Solution {
	static Deque<Character> dq;
	static ArrayList<String> list;
	static HashMap<Character, Integer> map;
	static int len;
	
	//DFS
	static void DFS() {
		if(dq.size() == len) {
			String t = "";
			for(char x : dq) t += x;//누적하고 
			list.add(t);
		}else {
			//map 순회하면서 
			for(char key : map.keySet()) {
				if(map.get(key) == 0) continue;//개수 0이면 건너뛰고 
				//1) 현재 key 앞에 담기 
				dq.addFirst(key);
				//2) 현재 key 뒤에 담기
				dq.addLast(key);
				//3) 빈도수 --
				map.put(key, map.get(key) - 2);
				//4) 재귀 더 깊이 탐색 호출 
				DFS();
				//5) 복귀 시 다시 poll
				dq.pollFirst();
				dq.pollLast();
				
				map.put(key, map.get(key) + 2);
				
			}
		}
	}
	
	//solution 함수 
	public String[] solution(String s){
		//초기화
		dq = new LinkedList<>();
		list = new ArrayList<>();
		map = new HashMap<>();
		len = s.length();
		
		//1) 빈도수 구성 담기 
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1	);
		}
		
		int odd= 0;
		char tmp = '#';//임시
		//2) 빈도수가 홀수개인지 확인 
		for(char key : map.keySet()) {
			if(map.get(key) % 2 == 1) {
				tmp = key;//해당 키로 담고 
				odd++;
			}
		}
		//3) odd 개수에 따라서 
		if(odd > 1) return new String[] {};
		
		//4) 그게 아니라면 팰린드롬 가능한 거니까 
		if(tmp != '#') { //만약 홀수 1개여서 존재할 경우 
			dq.add(tmp);//중앙에 담고
			map.put(tmp, map.get(tmp) -1);
		}
		
		//5) DFS 호출 
		DFS();
		
		//6) 정답 세팅 
		String[] answer =new String[list.size()];
		for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
			
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