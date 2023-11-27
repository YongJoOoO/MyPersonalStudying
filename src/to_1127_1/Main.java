package to_1127_1;

import java.util.Scanner;

/**
 * 그리디 - 5585번. 거스름돈 문풀 - 목표 : 거스름돈 최대 적게 
 * @author MYLG
 *
 */
public class Main {
	static int N;//지불금액 
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb=  new Scanner(System.in);
		
		N  = kb.nextInt();
		//거스를 금액 : 1000- N원
		N = 1000- N;
		
		int count = 0;
		while(N != 0) {
			if(N >= 500) {
				count += N / 500;//몫이 개수
				N %= 500;
			}else if(N >= 100) {
				count += N / 100;
				N %= 100;
			}else if(N >=50) {
				count += N / 50;
				N %= 50;
			}else if(N >= 10) {
				count += N / 10;
				N %= 10;
			}else if(N >= 5) {
				count += N / 5;
				N %= 5;
			}else if(N>=1) {
				count += N / 1;
				N %= 1;
			}
		}
		System.out.println(count);
	}
}