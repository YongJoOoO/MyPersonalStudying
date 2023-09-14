package to_0913_2;

import java.util.Scanner;

/**/
public class Main {
	static int N, M;
	static int[][] distance;//최단거리 담기 
	static int[][] stopover;//경유지 담기 
	
	//실햄 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		//인접 행렬로 세팅
		distance= new int[N+1][N+1];
		stopover = new int[N+1][N+1];
		
		//초기화
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j)  {
					distance[i][j] = 0;
				}
				else {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a= kb.nextInt();
			int b=kb.nextInt();
			int c = kb.nextInt();
			if(distance[a][b] > c ) {
				distance[a][b]= c;//가중치 담기 
				//기본 경유지 세팅 
				stopover[a][b] = b;
			}
		}
		
		//플로이드 수행 
		for(int k=1; k <=N; k++) {//경유지 k
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					//특정 k경유 해서 더 최단거리 나온다면 갱신
					if(i != j && distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
						stopover[i][j] = stopover[i][k];//k를 향해 갔던. 최초의 경유지를 담음 
					}
				}
			}
		}
		
		//정답 출력하기 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) System.out.print("- ");
				else System.out.print(stopover[i][j] + " ");
			}
			System.out.println();
		}
	}
}