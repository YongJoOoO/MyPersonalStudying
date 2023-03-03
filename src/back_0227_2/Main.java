package back_0227_2;

import java.util.Scanner;

/* 백준 10871번. X보다 작은 수 
 * 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
 * */
public class Main {

	//솔루션 함수
	public String solution(int n, int x, int[] arr) {
		String answer = "";
		
		for(int i =0; i<n; i++) {
			if(x > arr[i]) {
				answer += arr[i]; 
				answer += " ";
			}
			
		}
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
	
		//1) 입력
		int n = kb.nextInt();
		int x = kb.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i<n ; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.println(T.solution(n, x, arr));
	}

}