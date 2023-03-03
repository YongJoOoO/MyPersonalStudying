package to_0221;

import java.util.ArrayList;
import java.util.Scanner;

/*
 *  1-4. 단어 뒤집기 
 *  설명 : N개 단어 주어지면 각 단어 뒤집어 출력 프로그램
 *  
 *  입력 : 첫 줄에 자연수 N개(<=20) 주어짐 
 *  	둘째 줄부터 N개의 단어를 각 줄에 하나씩 입력. (단 영어로만 구성)
 *  
 *  출력 : N개 단어 입력한 순서대로 한 줄에 하나씩 뒤집어서 출력 
 * */

public class Main4 {
	//솔루션 함수 
	public ArrayList<String> solution(int n, String[] str) {
		ArrayList<String> answer = new ArrayList<>();
	
		//reverse() 함수를 직접 구현하기 
		
		//String -> char 배열 변경 후 -> 대칭 요소 간 자리 바꾸기 -> 가운데는 그대로니까
		// lt <-> rt 찍어서 서로 교환
		for(String x: str) {
			char[] s = x.toCharArray();
			int lt = 0, rt = x.length()-1;
			
			while(lt < rt) { //엇갈리지만 많은 상태에서 교환하면 됨
				char tmp = s[lt];
				s[lt] = s[rt];
				s[rt] = tmp;
				lt ++;
				rt --;
			}
			// valueOf() 내용물을 string화 하는 메소드
			String tmp = String.valueOf(s);
			answer.add(tmp);
		}

		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		//입력 규격 맞추기 
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		
		// 입력 : 사용자가 입력한 N개만큼 문자열 입력받기
		String[] str = new String[n]; //n개 문자열 배열 입력
		for(int i = 0; i<n; i++) {
			str[i] = kb.next();
		}

		// 출력 
		for(String x : T.solution(n, str)) {
			System.out.println(x);//각각 뒤집은 애들 for 돌면서 출력
		}
	}
}