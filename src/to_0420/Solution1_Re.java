package to_0420;

import java.util.*;
/* 2-1. 다시 풀기 | RE */
class Solution1_Re {
	//솔루션 함수 
	public int solution(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		//여기서 value를 1로 갖는 애 찾는 즉시 리턴해야 함 
		for(int i=0; i<s.length(); i++) {
			if(map.get(s.charAt(i)) == 1) return i+1;
		}
		return -1;
	}
	//메인 함수 
	public static void main(String[] args){
		Solution1_Re T = new Solution1_Re();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}