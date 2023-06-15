package to_0615_4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int cnt= 0;
		
		while(true) {
			if(N % 5 ==0) {
				cnt += N/5;
				break;
			}
			
			if(N < 3 ) {
				cnt = -1;
				break;
			}
			N -= 3;
			cnt++;
		}
		System.out.println(cnt);
	}
}