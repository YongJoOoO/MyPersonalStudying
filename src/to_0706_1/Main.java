package to_0706_1;

import java.util.Scanner;

/* 11404번. 플로이드 */
public class Main {
	static int N, M;
	static int distance[][];
	static final int INF = 10000001; //간선 가중치 10^5 * shem 10^2 + 1
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N= kb.nextInt();
		M = kb.nextInt();
		
		distance = new int[N+1][N+1];
		
		//인접 행렬 초기화
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) distance[i][j]=0;
				else {
					distance[i][j] = INF;
				}
			}
		}
		
		//간선 개수만큼 데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int w = kb.nextInt();
			if(distance[a][b] > w) distance[a][b]=w;
		}
		
		//--> 플로이드 수행
		for(int k=1; k<=N; k++) { //경유지 K로 찍고 
			//인접행렬 i,j
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j]= distance[i][k]+distance[k][j];///경로 업데이트 
					}
				}
			}
		}		
		//답 출력 해야 하는데 만약 업데이트 전인 곳은 0 
		//그 외는 최소 비용 출력 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(distance[i][j] == INF) {
					System.out.print("0 ");
				}else {
					System.out.print(distance[i][j]+" ");
				}
			}
			System.out.println();//띄어쓰기
		}
	}
}