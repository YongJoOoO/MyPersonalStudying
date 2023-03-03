package to_0223;

import java.util.Scanner;

/*
 * 1-10. 가장 짧은 문자거리
 * 한 개의 문자열 s와 문자 t가 주어지면,
 * 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 * 예를 들어, 
 *  s: teachermode    t : e
 *  
 *  [양쪽 모두에 e 가 존재하는데 이 경우 최소거리 구하는 법]
 *  1) 왼쪽 e 기준의 거리
 *  2) 오른쪽 e 기준의 거리
 *  3) 둘 중 작은 값 = 최소거리 로 세팅한 최종 answer 배열 반환하면 됨
 * 
 * */
public class Main2 {
	//솔루션 함수
	public int[] solution(String s, char t) {
		int[] answer = new int[s.length()];
		int p = 1000;  // 측정용 변수
		
		//1) 왼쪽 e 기준 거리 
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i) == t) { //타겟 문자인 경우 0 세팅
				p = 0;
				answer[i] = p;
			}else { //본인 아닌 경우 
				p++; //측정 p 증가시키면서 
				answer[i] = p; //정답지에 세팅
			}
		}
		
		//2) 오른쪽 e 기준 거리 | 거꾸로 돌려서 측정
		p = 1000;
		for(int i = s.length()-1; i>=0; i--) {
			if(s.charAt(i) == t) {
				p = 0;
			}else {
				p++;
				// *** answer[]는 min()으로 비교 (기존값 vs 현 P) 중 더 작은값으로 세팅 ****
				answer[i] = Math.min(answer[i], p);
			}
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Aut o-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		
		// 1) 입력 
		String s = kb.next();
		char t = kb.next().charAt(0);
		
		// 2) 출력
		for(int x: T.solution(s, t)) {
			System.out.print(x+" ");
		}
	}
}