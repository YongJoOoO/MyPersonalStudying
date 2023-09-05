package to_0905_2;

import java.util.*;

/*2458번. 키 순서 - 플로이드 문풀 */
public class Main {
	static int N, M;
	static boolean[][] chk; //연결 여부 체크용 배열 
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		boolean[][] chk = new boolean[N+1][N+1];//학생별 연결 여부 체크 
		
		//입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			//a->b 로 연결되어 있음
			chk[a][b] = true;
		}
		
		//플로이드 
		for(int k=1; k<=N; k++) { //거점 경유지 
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(chk[i][k] && chk[k][j]) { //틀정 K를 거점으로 경유가능한 연결점은 
						chk[i][j] = true;//true로 연결된 상태를 체킹한다. 
					}
				}
			}
		}
		
		//이제 전체 정점들 중에서, 자기 제외 모든 정점과 연결된 애 == 등수 알 수 있는 애로서 확인할 거다. 
		int[] cnt= new int[N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(chk[i][j] || chk[j][i]) { //i를 기준으로 체킹 
					cnt[i]++;//
				}
			}
		}
		
		for(int i=1; i<=N; i++) System.out.print(cnt[i] + " ");
	
	

	
	}
	
}
