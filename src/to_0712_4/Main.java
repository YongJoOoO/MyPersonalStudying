package to_0712_4;

import java.util.Scanner;

/*백준 12852번. 1로 만들기 2 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		
		int[] D = new int[N+1];
		D[0] = D[1] = 0;
		
		for(int i=2; i<=N; i++) {
			D[i] = D[i-1] + 1; // 먼저 빼주고 
			if(i % 2 ==0 ) D[i] = Math.min(D[i], D[i/2] + 1);
			if(i % 3 == 0) D[i] = Math.min(D[i], D[i/3]+1);
		}
		
		
	}

}
