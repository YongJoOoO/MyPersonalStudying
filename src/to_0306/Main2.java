package to_0306;

import java.util.HashMap;
import java.util.Scanner;

/* 04-01. 학급 회장 (해쉬) 
[입력]
첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.
[출력]
학급 회장으로 선택된 기호를 출력합니다.
*/
public class Main2 {
	//솔루션 함수
	public char solution (int n, String s) {
		char answer = 0;
		//<문자 , 누적값> 형태로 넣을 거임
		HashMap<Character, Integer> map = new HashMap<>();
		for(char x : s.toCharArray()) {
			//map에 중복 키 없도록 getOrDefault 로 값 얻어오되 없으면 0을 얻어옴
			map.put(x, map.getOrDefault(x, 0)+1); // +1처리해서 카운팅
		}
		
		int max = Integer.MIN_VALUE;
		
		//해쉬맵을 key값 기준으로 전체 탐색
		for(char key : map.keySet()) {
			if(map.get(key)>max) {
				max = map.get(key);
				answer = key;
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String str = kb.next();
		System.out.println(T.solution(n, str));
	}
}