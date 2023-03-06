package to_0306;

import java.util.HashMap;
import java.util.Scanner;

/* 04-02. 아나그램 (해쉬)
Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
[입력] 길이 같은 두 문자열 입력 [출력] 아나그램 판별 후 YES or No  
*/
public class Main3 {
	//솔루션 함수 
	public String solution(String s1, String s2) {
		String answer = "YES";
		
		HashMap<Character, Integer> map = new HashMap<>();
		//s1 기준으로 value에 누적시키고 
		for(char x : s1.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1	); //누적
		}
		//-> s2 는 감소시키면서 아나그램 판별
		for(char x : s2.toCharArray()) {
			//s2의 각 문자에 해당하는 값이 존재하는지 여부
			if(!map.containsKey(x)|| map.get(x) == 0) return "NO";
			map.put(x, map.get(x) - 1); //감소
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		
		String a = kb.next();
		String b = kb.next();
		
		System.out.println(T.solution(a, b));
	}
}