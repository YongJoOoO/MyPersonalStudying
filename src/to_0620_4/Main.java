package to_0620_4;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/* 1850번. 최대공약수 구하기 */
public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//최대공약수 구하는 법 
	static long gcd (long a, long b) {
		if(b==0) return a;//작은 수가 0이되면 그떄의 큰 수 반환 
		else {
			return gcd(b, a%b); //작은 수를 큰 수로 넘기면서, 작은수는 다시 나머지값 갱신
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