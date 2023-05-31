package to_0530_1;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N= kb.nextInt();
		
		String sNum = kb.next();
		
		int answer = 0;
		
		for(char x: sNum.toCharArray()) {
			answer += x - '0';
		}
		System.out.println(answer);
	}
}