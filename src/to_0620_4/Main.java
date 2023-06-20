package to_0620_4;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/* 1850번. 최대공약수 구하기 
 * */
public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long gcd (long a, long b) {
		if(b==0) return a;
		else {
			return gcd(b, a%b);
		}
	}
	//실행 메인
	public static void main(String[] args) throws Exception{
		
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		long a= kb.nextLong();
		long b = kb.nextLong();
		
		long result = gcd(a,b);
		
		while(result > 0) {
			bw.write("1");
			result--;
		}
		bw.flush();
		bw.close();
	}
}