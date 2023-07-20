package to_0720_7;

import java.util.HashMap;

class Solution {
	//솔루션 함ㅜㅅ 
	public int solution(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);//빈도수 저장 
		}
		
		//순서대로
		for(int i=0; i<s.length(); i++) {
			if(map.get(s.charAt(i)) == 1) {
				return i+1;//번째니까 +1처리해서 보냄 
				
			}
		}
		return -1;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}