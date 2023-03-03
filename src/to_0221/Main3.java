package to_0221;

import java.util.Scanner;

/* 1-3. 문장 속 단어 
 * 
 *  설명 : 한 문장 주어지면, 해당 무낭 속 가장 긴 단어 출력 프로그램 작성 
 *  
 *  입력 : 첫 줄에 문장 1개 입력 (100 이하. 알파벳구성)
 *  
 *  출력 : 첫 줄에 가장 긴 단어 출력 (긴 단어 여러 개인 경우, 더 앞쪽에 위치한 단어 우선)
 * */

public class Main3 {

	//솔루션 함수 
	public String solution(String str) {
		String answer = "";
		
		//카운팅 Max 값에 우선 가장 작은 값 초기화
		int M = Integer.MIN_VALUE;
		
		// 문장 속 공백 기준 단어 자르기 추출 : split()
		String[] s = str.split(" ");
		
		for(String x : s) {
			//각 [] 속 단어 길이 측정
			int len = x.length();
			// 카운팅 M보다 더 큰 길이 발견 시
			if(len > M) {
				M = len; // 더 큰 길이 M으로 갱신
				answer = x; //정답도 갱신
			}
		}
		return answer;
	}
	
	//실행 메인 (입력 애들 세팅, 출력)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		//입력 규격 맞추기 
		Scanner kb = new Scanner(System.in);
		// 입력 : 공백 포함한 라인 전체를 입력받아야 하므로 
		String str = kb.nextLine();
		
		// 곧장 출력
		System.out.println(T.solution(str));
	}
}