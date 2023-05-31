package to_0530_1;

import java.util.Scanner;

public class Solution {
	
	//실행 메인 	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int a = kb.nextInt();
		
		for(int i =0; i<100; i++) {
			if(a == i) {
				System.out.println(a );
				break;
			}
		}
	}
}
