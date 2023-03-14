package to_0314;

import java.util.ArrayList;
import java.util.Scanner;

/* 6-1. 선택 정렬
 * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 * 정렬하는 방법은 선택정렬입니다.
 * */
public class Main1 {
	//솔루션 함수
	public int[]solution(int n, int[] arr){
	
		 //정렬 모두 마치면 마지막 값은 어차피 가장 큰 수만 남음
		for(int i = 0; i<n-1; i++) {
			//기준 i 인덱스값
			int idx = i;
			//j가 i+1 ~ n 까지 돌며 가장 작은 작은 값의 idx값을 세팅함
			for(int j = i+1; j<n; j++) {
				if(arr[j] < arr[idx]) idx = j;
			}
			//for 탈출하면 idx에는 i기준 뒤쪽을 j가 돌며 가장 작은 값의 idx를 세팅한 상태
			//따라서 기준 i의 값 <-> idx로 찍은 최소값 swap
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		return arr;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		//출력
		for(int x : T.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}
}