package to_0907_9;

import java.util.Scanner;

/*계단 오르기 - DP*/
public class Main {
	static int N;
	static int[] dy;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		//올라야 하는 계단의 수 	
		N = kb.nextInt();
		
		dy = new int[N+1];//dy[i]: i번째 계단을(1 or 2)계단의 조합으로 오를 수 있는 경우의 수 
	
		//초기화
		dy[1]= 1;
		dy[2] = 2;
		for(int i=3; i<=N; i++) {
			dy[i] = dy[i-1] + dy[i-2];//앞의 두 값의 합 
		}
		System.out.println(dy[N]);
		
	}	

}
