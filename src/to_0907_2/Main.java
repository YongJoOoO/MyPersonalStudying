package to_0907_2;

import java.util.Scanner;

/*백준 1789번. 수들의 합 - 그리디 문풀 */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner kb= new Scanner(System.in);
		 long S = kb.nextLong();
		 
		 int N= 0;
		 long sum = 0L;
		 int i=1;
		 while(true) {
			 sum += i; //차례로 더하면서 
			 i++;
			 if(sum > S) {
				 break;
			 }
			 N++;
		 }
		 System.out.println(N);
	}
}