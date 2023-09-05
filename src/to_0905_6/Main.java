package to_0905_6;

import java.util.Scanner;

public class Main {
	static int N, M;
	static boolean[][] chk;//연결 점
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		chk = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			chk[a][b] = true;
		}
		
		//플로이드
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(chk[i][k] && chk[k][j]) {
						chk[i][j] = true;//경유지 거쳐서 갈 수 있는 지점은 true처리 
					}
				}
			}
		}


	}
}
