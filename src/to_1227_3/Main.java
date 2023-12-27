package to_1227_3;

import java.util.Scanner;

/**
 * 13241번. 최소공배수 - gcd 활용
 * @author MYLG
 *
 */
public class Main {
	static long gcd(long a, long b) {
		long r = a % b;
		if(r==0) return b;
		else return gcd(b, r);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		long a = kb.nextLong();
		long b = kb.nextLong();
		
		long gcd = (a*b) /gcd(a, b);
		
		System.out.println(gcd);
	}
}