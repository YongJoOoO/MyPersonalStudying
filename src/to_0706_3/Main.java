package to_0706_3;

import java.util.Scanner;

/*1389번. 케빈 베이컨의 6단계 법칙 */
public class Main {
	static int N, M;
	static int [][] distance;
	static final int INF = 1000001;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		distance = new int[N+1][N+1];
		
		//초기화 
		for(int i = 1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) distance[i][j]=0;
				else {
					distance[i][j]=INF;
				}
			}
		}
		
		//입력 데이터 받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향 
			distance[a][b] = 1;
			distance[b][a] = 1;
		}
		
		//플로이드 워샬로 최단 거리 즉, 친구 관계 경유 되는지 
		//경유 된다면 그 친구 깊이? 단계 를 업데이트 
		for(int k=1; k<=N; k++) {
			for(int i =1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j] ) { //발견되면 
						distance[i][j] = distance[i][k]+distance[k][j];//깊이 업데이트 
					}
				}
			}
		}
				
		int min = Integer.MAX_VALUE;
		int answer = -1;
		
		for(int i=1; i<=N; i++) {
			int tmp =0;
			for(int j=1; j<=N; j++) {
				tmp+=distance[i][j];
			}
			if(tmp < min) {
				min = tmp;
				answer =i;
			}
		}
		System.out.println(answer);
	}
}