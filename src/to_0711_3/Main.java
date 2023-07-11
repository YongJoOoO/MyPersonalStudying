package to_0711_3;

import java.util.Scanner;

/*14501번. 퇴사 */
public class Main {
	static int N;
	static int[] T, P, D;//시간, 금액, DP
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		//퇴사일은 N+1이다.
		
		//초기화
		T = new int[N+1];
		P = new int[N+1];
		
		//D[i] 정의 : i일부터 퇴사 전까지 최대 수익 
		D = new int[N+2];//1~N+1까지의 수익 구해야 해서 
		
		for(int i=1; i<=N; i++) {
			T[i] = kb.nextInt(); //시간
			P[i] = kb.nextInt(); //금액 
		}
		
		//퇴사일 전까지 최댓값 세팅 
		for(int i=N; i>0; i--) { //역순 정렬 
			if(N+1 < i+ T[i]) { //i일부터의 근로가 퇴사일 넘어가면 
				D[i] = D[i+1];//오늘 제외하고, i+1일부터 퇴사전까지의 최댓값을 옮겨옴
			}else{
					//D[i]일 넘기고 i+1일부터 한 거 vs D[i]일의 근로한 거 
				D[i] = Math.max(D[i+1], D[i + T[i]] + P[i]);
			}
		}
		
		System.out.println(D[1]);
	}
}