package to_1120_F;

import java.util.Scanner;

/**
 * 5622번. 다이얼 - 구현 
 * @author MYLG
 *
 */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		String str = kb.next();
		
		int time = 0;
		for(int i=0; i<str.length(); i++) {
			//총 글자수 만큼 반복할 건데 
			char c = str.charAt(i);
			
			if(c == 'A' || c == 'B' || c == 'C') {
				time += 3;
				
			}
			if(c == 'D' || c == 'E' || c == 'F') {
				time += 4;
			}
			if(c == 'G' || c == 'H' || c == 'I') {
				time += 5;
			}
			if(c == 'J' || c == 'K' || c == 'L') {
				time += 6;
			}
			if(c == 'M' || c == 'N' || c == 'O') {
				time += 7;
				
			}
			if(c == 'P' || c == 'Q' || c == 'R' || c == 'S') {
				time += 8;
			}
			if(c == 'T' || c == 'U' || c == 'V') {
				time += 9;
				
			}
			if(c == 'W' || c == 'X' || c == 'Y' || c=='Z') {
				time += 10;
			}
		}
		
		System.out.println(time);
	}

}
