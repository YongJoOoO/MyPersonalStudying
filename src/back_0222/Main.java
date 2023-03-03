package back_0222;

import java.util.Scanner;

/* 백준 10809번.
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다.
 * 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는
 * 	 처음 등장하는 위치를, 
 *    포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.

   //첫 등장은 indexOf() 가 주니까. charAt(i)
	// => 그니까 a~z 까지 돌면서 입력 단어에 해당하는 알파벳 위치에 index 주고, 없으면 -1 주고 그러라는 뜻!
 * 
 * */
public class Main {
	//솔루션 함수 
	public String solution(String str) {
		String answer = "";
		// 전체 알파벳
        for (char c = 'a' ; c <= 'z' ; c++) {
        	answer += str.indexOf(c) + " ";
        }
		return answer;
	}
	
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		//1) 입력
		String str = kb.next();
		
		//2) 출력 
		System.out.println(T.solution(str));	
	}
}