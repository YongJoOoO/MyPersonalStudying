package to_0907_A;

import java.util.Scanner;

/*돌다리 건너기 - DP */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int[] dy = new int[N+2];//N+1까지 가야함 
		
		dy[1]=1;
		dy[2]=2;
		for(int i=3; i<=N+1; i++) {
			dy[i] = dy[i-1] + dy[i-2];
		}
		System.out.println(dy[N+1]);
	}
}