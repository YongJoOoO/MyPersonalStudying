package to_24_0113_2;

import java.util.*;

/**
 * 11404번. 플로이드 문풀 - 플로이드 all-to-all
 * @author MYLG
 *
 */
public class Main {
	static final int INF = 10000001; //이거 주읭 
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		int[][] distance = new int[N+1][N+1];
		
		//초기화 		
		for(int i=1; i<=N; i++) {
			for(int j =1; j<=N; j++) {
				if(i == j) distance[i][j] = 0;
				else distance[i][j] = INF;
			}
		}
		
		//데이터 입력
		for(int i =0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			
			if(distance[a][b] < val) continue;
			distance[a][b] = val;//세팅 
		}
		
		//플로이드 적용 
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		//출력
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(distance[i][j] == INF) {
					System.out.print("0 ");
				}else {
					System.out.print(distance[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}