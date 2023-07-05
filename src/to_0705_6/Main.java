package to_0705_6;

import java.util.Scanner;

/*11404번. 플로이드 */
public class Main {
	static int N, M;
	static int[][] distance;
	static final int INF = 10000001;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		//1) 초기화 
		N = kb.nextInt();
		M = kb.nextInt();
		distance = new int[N+1][N+1];
 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) distance[i][j]= 0;
				else {
					distance[i][j] = INF;
				}
			}
		}
		//2) 데이터 저장
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			if(distance[a][b] > c) distance[a][b]= c;
		}
		
		//3) 업데이트 - 플로이드 워셜 수행 
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		//4) 출력
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(distance[i][j] == INF) System.out.println("0");
				else System.out.print(distance[i][j]+" ");
			}
			System.out.println();
		}
	}
}