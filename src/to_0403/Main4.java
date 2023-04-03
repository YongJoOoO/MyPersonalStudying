package to_0403;

import java.util.Scanner;

/* 10-2. 돌다리 건너기 */
public class Main4 {
	static int[] dy;
	//solution
	public int solution(int n) {
		dy[1]=1;
		dy[2]=2;
		for(int i=3; i<=n+1; i++) {
			dy[i]= dy[i-2]+dy[i-1];
		}
		return dy[n+1];
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		dy= new int[n+2];
		System.out.println(T.solution(n));
	}
}