package to_0728_2;

import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		
		int[] D = new int[N+2];
		D[1] = 1;
		D[2] = 2;
		for(int i=3; i<=N+1; i++) {
			D[i] = D[i-1] + D[i-2];
		}
		System.out.println(D[N+1]);
	}
}