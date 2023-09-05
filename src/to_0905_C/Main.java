package to_0905_C;

import java.util.*;

/*호석이 두마리 차칸 - 플로이드 문풀  */
public class Main {
	static int N, M;
	static int[][] distance;
	static final int INF = 1000001;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		//초기화
		distance = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				else distance[i][j] = INF;
			}
		}
		
		//입력 받기 
		for(int i=0; i<M; i++) {
			int a= kb.nextInt();
			int b = kb.nextInt();
			//양방향 도로 
			distance[a][b] = 1; 
			distance[b][a] = 1;
		}

		//플로이드 
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		//그대로 출력
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(distance[i][j] == INF) System.out.print("0 ");
				else System.out.print(distance[i][j]+" ");
			}
			System.out.println();
		}
	}

}
