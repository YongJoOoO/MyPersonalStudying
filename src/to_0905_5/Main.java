package to_0905_5;

import java.util.Scanner;

// 10159번. 저울 - 플로이드 문풀 
public class Main {
	
	static int N, M;
	static boolean[][] chk;
	
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
		for(int k=1; k<=N; k++) { //k를 거쳐서 
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(chk[i][k] && chk[k][j]) {
						chk[i][j] = true;//이렇게도 연결처리  
					}
				}
			}
		}
		//역순으로도 들어오는 건 다 연결점이라고 생각해야 함 
		int[] cnt = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(chk[i][j] || chk[j][i]) {//정방향 또는 역방향이 연결되어 있으면 두 정점은 연결된 것으로 본다. 
					cnt[i]++;
				}
			}
			
		}
		//정답 출력 
		for(int i=1; i<=N; i++) {
			//모든 정점에 연결된 것은 자기 자신 제외 N-1개를 갖고 있을 것이고,
			//따라서, N-1 - cnt값을 빼야 알수 "없는" 개수를 알게 되는 것. 
			System.out.println(N-1-cnt[i]);
		}
	}
}