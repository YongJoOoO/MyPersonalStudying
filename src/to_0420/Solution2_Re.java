package to_0420;
/* 2-2. 다시 풀기ㅣ RE */
import java.util.*;
class Solution2_Re {
	public int[] solution(String s){
		int[] answer = new int[5];
		HashMap<Character, Integer> map = new HashMap<>();
		//1) 해싱
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1); //중복 없는 문자 발견 시 +1
		}
		//2) max를 찾아야 거기에 맞춰서 더 추가해야할 문자개수 발견 가능 
		int max = Integer.MIN_VALUE;
		String tmp = "abcde"; // 이 순서대로 값 담아야 하니
		
		for(char x : tmp.toCharArray()) {
			//최대 max 값 찾는 용도라
			if(map.getOrDefault(x, 0) > max) {
				max = map.getOrDefault(x, 0);
			}
		}
		
		//3) max-자기값
		for(int i=0; i<tmp.length(); i++) {
			answer[i] = max - map.getOrDefault(tmp.charAt(i), 0);
		}
		
		return answer;
	}

	public static void main(String[] args){
		Solution2_Re T = new Solution2_Re();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
