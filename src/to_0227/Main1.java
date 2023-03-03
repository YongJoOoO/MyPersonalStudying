package to_0227;

import java.util.ArrayList;
import java.util.Scanner;

/* 2-1. 큰 수 출력하기
 * 설명
	N개의 정수를 입력받아, '자신의 바로 앞 수'보다 큰 수만 출력하는 프로그램을 작성하세요.
	(첫 번째 수는 무조건 출력한다)
 * */
public class Main1 {
	
	//솔루션 함수 
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		answer.add(arr[0]); //첫수 무조건 넣기
		//현재 수가 바로 앞수보다 크면 answer에 붙임
		for(int i = 1; i<n; i++) {
			if(arr[i] > arr[i-1]) answer.add(arr[i]);
		}
		
		return answer;
	}

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		
		Scanner kb = new Scanner(System.in);
		//1) 입력 N
		int n = kb.nextInt();
		//2) N개 숫자 입력 
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		//출력
		for(int x: T.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}
}