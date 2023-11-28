package to_1128_4;

import java.util.Scanner;

/**
 * 팩토리얼 
 * @author MYLG
 *
 */
public class Main {
	static int answer = 1;
	//DFS
	static void DFS(int val) {
		if(val == 0) return;
		else {
			answer *= val;
			DFS(val - 1);
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		
		DFS(N);
		System.out.println(answer);
	}
}