package to_0904_2;

import java.util.Scanner;

/*1956번. 운동 - 플로이드 문풀 */
public class Main {
	static int V, E;
	static int[][] distance;
	static final int INF = 987654321;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		V = kb.nextInt();
		E = kb.nextInt();
		
		distance =new int[V+1][V+1];
		//인접 행렬 초기화 
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(i==j) distance[i][j] = 0;
				else distance[i][j] = INF;
			}
		}
		
		//간선 개수 만큼 입력받기 
		for(int i=0; i<E; i++) {
			int a= kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			//단방향 
			distance[a][b] = c;
		}
		
		//플로이드 시작 
		for(int k=1; k<=V; k++) { //걍유지 K 
			for(int i=1; i<=V; i++) {
				for(int j=1; j<=V; j++) {
					if(i==j) continue;
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];//갱신 
					}
				}
			}
		}
	
		int ans = INF;
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(i==j) continue;
				//서로 INF가 아닌 값들이 사이클 형성 된 상태인 것이다. 
				if(distance[i][j] != INF && distance[j][i] != INF) {
					ans = Math.min(ans, distance[i][j] + distance[j][i]);
				}
			}
		}
		
		if(ans == INF) System.out.println(-1);
		else System.out.println(ans);
	}
}