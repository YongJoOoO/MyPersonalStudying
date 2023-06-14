package to_0614_8;

import java.util.Scanner;

/*2839번. 설탕 배달 - 그리디 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner (System.in);
		int n = kb.nextInt();
		int cnt = 0;
		while(true) {
			if(n % 5 == 0) {
				cnt = n/5;//나눈 몫
				break;
			}
			n -= 3;
			cnt++;
			if(n <= 0) {
				n = -1;
				break;
			}
		}
		System.out.println(n);
	}

}
