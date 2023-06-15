package to_0615_6;

import java.util.Arrays;
import java.util.Scanner;

/* 2012번. 등수 매기기 - 그리디 
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n= kb.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		
		Arrays.sort(arr);
		//long 형이어야 정답이다. 
		long sum =0;
		for(int i=0; i<arr.length; i++) {
			sum += Math.abs(arr[i] - (i+1));
		}
		
		System.out.println(sum);
	}
}