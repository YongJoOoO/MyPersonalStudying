package to_1227_1;

import java.util.Scanner;

/**
 * 백준 최대공약수와 최소공배수 - gcd 유클리드 호제법 문풀 
 * 
 *
 */
public class Main {
	static int gcd(int a, int b) {
		int r = a % b;
		if(r == 0) return b;
		else return gcd(b, r);
	}
	
	//실행메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int a = kb.nextInt();
		int b = kb.nextInt();
		
		int g = gcd(a, b);
		int d = (a * b) / g;
		
		System.out.println(g);
		System.out.println(d);
		
	}
}