package to_0531_1;

import java.util.Scanner;

/* 2018번. 연속된 자연수의 합 구하기 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int sum = 1, count = 1; 
		
		int st = 1, ed = 1;
		
		while(ed != N) {
			if(N == sum ) {
				count++;
				ed++;
				sum = sum + ed;
			}else if(sum < N) {
				ed++;
				sum = sum+ed;
			}else if(sum > N) {
				sum = sum - st;
				st++;
			}
		}
		
		System.out.println(count);
	}

}
