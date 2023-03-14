package to_0314;

import java.util.Scanner;

/* 6-2. 버블 정렬 
N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 버블정렬입니다.*/
public class Main2 {
	//솔루션 함수 
	public int[] solution(int n, int[] arr) {
		for(int i = 0; i<n-1; i++) {
			// 각 단계 끝날 때마다 뒤에서 i번째 요소 자리가 확정되어야 함 
			for(int j = 0; j<n-i-1; j++) {
				//인접 두 수 비교후 뒷 요소가 더 작으면 swap
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		return arr;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		
		Scanner kb = new Scanner(System.in);
		int n =kb.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		//츨력
		for(int x : T.solution(n, arr)) System.out.print(x + " ");
	}
}