package back_0227_3;

import java.util.Scanner;

/* 10818번. 최소, 최대 
 * */
public class Main {
	
	//출력 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		//입력
		int n = kb.nextInt();
		int [] arr = new int[n];
		
		for(int i =0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		//솔루션
		int Max = arr[0];
		int Min = arr[0];
		
		for(int i =0 ;i<n; i++){
			if(Max < arr[i]) Max = arr[i];
			if(Min > arr[i]) Min = arr[i];
		}
		//출력
		System.out.print(Min + " " + Max);
	}
}