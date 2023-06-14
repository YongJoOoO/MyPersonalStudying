package to_0614_6;

import java.util.Scanner;

public class Main {
	
	static int mySum(String x) {
		int sum = 0;
		for(String a : x.split("[+]")) {
			sum += Integer.parseInt(a);
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb =new Scanner(System.in);
		
		String x = kb.next();
		//- 기준으로 구분해놓고 
		String[] sArr = x.split("-");
		int sum =0;
		for(int i=0; i<sArr.length; i++) {
			int tmp = mySum(sArr[i]);
			if(i ==0) {
				sum += tmp;
			}else {
				sum -= tmp;
			}
		}
		
		System.out.println(sum);
	}
}