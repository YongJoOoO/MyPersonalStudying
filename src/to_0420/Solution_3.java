package to_0420;
import java.util.*;
class Solution_3 {
	public int[] solution(String s){
		String tmp = "abcdefghijklmnopqrstuvxyz";

		int[] answer = new int[tmp.length()];
		
		HashMap<Character, Integer> map = new HashMap<>();
		//1) 맵 담고
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		//2)max 값을 구해서
		int max = Integer.MIN_VALUE;
		for(char x : s.toCharArray()) {
			if(max < map.getOrDefault(x, 0)) {
				max = map.getOrDefault(x, 0);
			}
		}
		//3)a~z 순서대로 필요한 애 = max - 자기 빈도수
		for(int i=0; i<tmp.length(); i++) {
			answer[i] = max - map.getOrDefault(tmp.charAt(i), 0);
		}
		
		return answer;
	}

	public static void main(String[] args){
		Solution_3 T = new Solution_3();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
