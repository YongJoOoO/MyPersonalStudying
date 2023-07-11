package to_0711_2;

import java.util.Scanner;

//DP문제 1463번. 1로 만들기 
public class Main {
	static int N;
	static int[] D;
	//실해 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		D = new int[N+1];
		
		//초기화 
		D[1] = 0; //1은 더이상 연산할 필요 없는 숫자이므로 1초기화 
		for(int i=2; i<=N; i++) {
			D[i] = D[i-1] + 1;
			if(i%2 ==0) D[i] = Math.min(D[i] , D[i/2]+1);
			if(i%3 == 0) D[i] = Math.min(D[i], D[i/3]+1);
		}		
		//정답 출력 
		System.out.println(D[N]);
	}
}