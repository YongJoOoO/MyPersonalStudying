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
			chk[b][a] = true;
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
		
		int[] cnt = new int[N+1];		
		//연결지점 = 진입 + 진출 합침 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(chk[i][j] || chk[j][i]) {
					cnt[i] ++;//연결점 다 출력 
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, cnt[i]);
		}
		int answer= 0;
		for(int i=1; i<=N; i++) {
			if(max == cnt[i]) answer++;
		}
		System.out.println(answer);
	}
}
