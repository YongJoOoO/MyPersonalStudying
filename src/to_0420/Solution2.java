package to_0420;
/* 2-2. 같은 빈도수 만들기 */
import java.util.*;
class Solution2 {
	//솔루션 함수 
	public int[] solution(String s){
		int[] answer = new int[5];
		HashMap<Character, Integer> map = new HashMap<>();
		//일단 담고 카운팅 
		for(char x: s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		
		int max = Integer.MIN_VALUE;
		//이 순서대로 answer 담아야 하므로 
		String tmp = "abcde";
		
		for(char key : tmp.toCharArray()) {
			//없는 문자가 있어도 기본으로 0이라도 반환함 
			if(map.getOrDefault(key, 0) > max) {
				max = map.getOrDefault(key, 0);
			}
		}
		//정답 세팅 
		for(int i =0; i<tmp.length(); i++) {
			//맵 내부 순회하면서 abcde 순서대로 각 (max-빈도수)필요한 추가 개수 가져오되
			// 없으면 0 반환하도록 
			answer[i] = max - map.getOrDefault(tmp.charAt(i), 0);
		}
		return answer;	
	}
	//실행 메인 
	public static void main(String[] args){
		Solution2 T = new Solution2();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}