package back_0320_1;

import java.util.Scanner;

/* 27866번. 문자와 문자열 
 * */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		String str= kb.nextLine();
		int n = kb.nextInt();
		
		System.out.println(str.charAt(n-1));
	}
}