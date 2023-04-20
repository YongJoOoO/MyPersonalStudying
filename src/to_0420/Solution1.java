package to_0420;
// 2-1. 한 번 사용한 문자 
import java.util.*;
class Solution1 {
	//솔루션 함수 
	public int solution(String s){
		//각 문자, 빈도수 
		HashMap<Character, Integer> map = new HashMap<>();
		//각 문자별 빈도수 카운팅
		for(char x : s.toCharArray()) {
			//맵에 담되, 중복 없이 담음 
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		
		//i를 길이만큼 순회하면서
		for(int i=0; i<s.length(); i++) {
			//만약 맵에 각 i번째 문자 (key)값 기준으로 value를 가져왔더니 1이면 리턴함
			if(map.get(s.charAt(i)) == 1) return i+1;
		}
		
		return -1;
	}
	//실행 메인
	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}