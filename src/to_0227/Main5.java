package to_0227;

import java.util.Scanner;

public class Main5 {
	
	public void solution(int n) {
		int a = 1, b =1, c;
		
		System.out.print(a + " " + b + " ");
		for(int i =2; i<n; i++) {
			c = a+b;
			System.out.print(c + " ");
			//갱신되어야 수열 생성됨
			a = b;
			b = c;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main5 T = new Main5();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		
		T.solution(n);
	}
}