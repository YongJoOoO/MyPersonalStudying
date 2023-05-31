package to_0530_2;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			if(arr[i] < max ) max = arr[i];
			sum += arr[i];
		}
		
		
		
	}
}