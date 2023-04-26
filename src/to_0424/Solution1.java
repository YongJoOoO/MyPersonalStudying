package to_0424;
/* 2-3번. 서로 다른 빈도수 만들기 
 *  */
import java.util.*;
class Solution1 {
	public int solution(String s){
		int answer = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		//1) 중복없이 각 문자의 빈도수 저장시킴 
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		//2) 확인용(빈도수 유일하게) Set 사용
		HashSet<Integer> set = new HashSet<>();
		//3) 빈도수 모두 다르게 만들기 
		for(char key : map.keySet()) {
			//ch에 map의 key에 대한 value 와 일치하는 동안 반복 
			while(set.contains(map.get(key))) {
				answer++; //삭제처리할 때마다 ++
				map.put(key, map.get(key)-1);
				//key를 담되, 그 키에대한 value-1처리 하면서
			}
			if(map.get(key)==0) continue; //그냥 지속
			set.add(map.get(key)); //유니크한 빈ㄴ도수를 set에 담기 
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(T.solution("aaabbbcc"));	
		System.out.println(T.solution("aaabbc"));	
		System.out.println(T.solution("aebbbbc"));	
		System.out.println(T.solution("aaabbbcccde"));	
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));	
	}
}