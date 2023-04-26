package to_0424;

import java.util.HashMap;
import java.util.HashSet;

public class Solution1_Re {

	//솔루션 함수 
	public int solution(String s) {
		int answer= 0;
		HashMap<Character, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		
		//1) 맵에 우선 중복없이 각 빈도수를 담는다.
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		
		//2) 각 key별 빈도수가 유일한지 확인용 Set에 담기 전 확인하면서 담는다. 
		//Set = 중복 불허 자료구조
		for(char key : map.keySet()) {
			//Set에 이미 map의 빈도수 중복 값 있는 동안 반복할 거임
			while(set.contains(map.get(key))) {
				//중복되는 동안. 해당 키의 빈도수값 -1처리 
				map.put(key, map.get(key)-1);
				answer++;
			}
			//탈출 후 만약 해당 빈도수 0 되면 별다르 처리없이 continue처리
			if(map.get(key) == 0) continue;
			
			set.add(map.get(key));//Set에 중복되지 않는 빈도수를 담는다. 
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
