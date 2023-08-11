package to_0811_6;
//팰린드롬 경우의 수 
import java.util.*;
class Solution {
	static Deque<Character> tmp;
	static ArrayList<String> res;
	static HashMap<Character, Integer> map;
	static int len;
	
	//DFS
	static void DFS() {
		if(tmp.size() == len){
		String Ts = "";
		for(char x : tmp) Ts += x;
		res.add(Ts);
	}
	else{
		for(char key : map.keySet()){
			if(map.get(key) == 0) continue;
			tmp.addFirst(key);
			tmp.addLast(key);
			map.put(key, map.get(key) - 2);
			DFS();
			tmp.pollFirst();
			tmp.pollLast();
			map.put(key, map.get(key) + 2);
		}
	}
}
	
	//솔루션 함수 
	public String[] solution(String s){
		tmp = new LinkedList<>();//데크
		res = new ArrayList<>();
		map = new HashMap<>();
		len = s.length();
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		int odd = 0;
		char mid = '#';
		for(char key : map.keySet()) {
			if(map.get(key) % 2 == 1) {
				mid = key;
				odd++;
			}
		}
		if(odd>1) return new String[] {};
		if(mid != '#') {
			tmp.add(mid);
			map.put(mid, map.get(mid)-1);
		}
		DFS();
		
		String[] answer = new String[res.size()];
		for(int i=0; i<res.size(); i++) answer[i] = res.get(i);

		return answer;
	}
	//메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution("aaaabb")));	
		System.out.println(Arrays.toString(T.solution("abbcc")));
		System.out.println(Arrays.toString(T.solution("abbccee")));
		System.out.println(Arrays.toString(T.solution("abbcceee")));
		System.out.println(Arrays.toString(T.solution("ffeffaae")));
	}
}