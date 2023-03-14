package back_0314;

import java.util.Arrays;
import java.util.Scanner;

/* 10817번. 세 수
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int[] arr = new int[3];
		
		for(int i = 0; i<3; i++) {
			arr[i] = kb.nextInt();
		}
		
		//정렬
		Arrays.sort(arr);
		System.out.println(arr[1]);
	}
}