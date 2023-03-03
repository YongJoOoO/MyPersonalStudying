package to_0228;

import java.util.ArrayList;
import java.util.Scanner;

/* 2-8. 등수 구하기 
 * [설명] 
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
   같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
   즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 */
public class Main4 {
	//솔루션 함수 
	public int[] solution(int n, int[] arr){
		//기본 생성 시 0출력 
		//등수 
		int[] answer = new int[n];
		
		for(int i =0; i<n; i++) {
			int cnt = 1; //등수 누적시키기
			for(int j = 0; j<n; j++) {
				if(arr[i] < arr[j]) cnt++;
			}
			answer[i] = cnt; //등수 담음 
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		//입력
		int n = kb.nextInt();
		
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