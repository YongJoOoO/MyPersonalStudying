package back_0227_4;

import java.util.Scanner;
/* 백준. 2562번. 최댓값 
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kb = new Scanner(System.in);
		//입력
		int[] arr = new int[9];
		for(int i =0; i<9; i++) {
			arr[i] = kb.nextInt();
		}
		
		int m = 0;
		int index = 0;
		//솔루션
		for(int i =0; i<9; i++) {
			if(arr[i] > m) {
				m = arr[i];
				index = i+1;
			}
		}
		//출력
		System.out.println(m);
		System.out.println(index);
	}
}