package back_0302;

import java.util.Arrays;
import java.util.Scanner;

/* 백준 2750번. 수 정렬하기 
 N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
*/
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		//정렬
		Arrays.sort(arr);
	
		//출력 
		for(int x : arr) {
			System.out.println(x);
		}
	}
}