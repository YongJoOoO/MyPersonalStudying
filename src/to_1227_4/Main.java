package to_1227_4;

import java.util.Scanner;

/**
 * 1735번. 분수 합 - gcd 활용 
 */
public class Main {
	static int gcd(int a, int b) {
		int r = a % b;
		if(r==0) return b;
		else return gcd(b, r);
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int a = kb.nextInt();//분자
		int A = kb.nextInt();//분모
		
		int b = kb.nextInt(); //분자
		int B = kb.nextInt(); //분모 
		
		int M = A * B; //공통 분모 
		int m = (a*B) + (b * A); //분자 
		
		int gcd = gcd(M, m); //분수의 분자 분모를 기약분수로 만들 '최대공약수'
		// M, m에 각각 최대공약수로 나누고 나면 기약분수 형태가 된다.
		M /= gcd;
		m /= gcd;
		
		System.out.println(m + " " + M);
	}
}