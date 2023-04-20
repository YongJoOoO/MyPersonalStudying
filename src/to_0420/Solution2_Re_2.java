package to_0420;

import java.util.*;
class Solution2_Re_2 {
	public int[] solution(String s){
		int[] answer = new int[5];
		HashMap<Character, Integer> map = new HashMap<>();
		//1)각 문자별 빈도수 해싱하기
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		//2) max 찾기 
		int max = Integer.MIN_VALUE;
		String tmp = "abcde";//이 순서대로 답 세팅예정
		for(char x : tmp.toCharArray()) {
			if(max < map.getOrDefault(x, 0)) {
				max = map.getOrDefault(x, 0);
			}
		}
		//3) max-기존값 : 추가할 문자 개수이므로 
		for(int i =0; i<tmp.length(); i++) {
			answer[i] = max - map.getOrDefault(tmp.charAt(i), 0);
		}
		
		return answer;
	}

	public static void main(String[] args){
		Solution2_Re_2 T = new Solution2_Re_2();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
