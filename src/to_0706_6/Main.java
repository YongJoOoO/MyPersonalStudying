package to_0706_6;

import java.util.Scanner;

/*플로이드 -1) 백준 11404번. 플로이드 문풀 -RE */
public class Main {
	static int n, m;
	static int[][] distance;
	static final int INF = 10000001;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		//초기화
		distance = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) distance[i][j] = 0;
				else distance[i][j]= INF;
			}
		}
		
		//데이터 값 정보 저장 
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int v = kb.nextInt();
			if(distance[a][b] > v) distance[a][b] = v;
		}
		
		//플로이드 최단 거리 만들기 
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];//최단거리 업데이트
					}
				}
			}
		}		
		//출력 - 못 가는 곳은 0 그 외는 최단 거리 출력 
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(distance[i][j] == INF) {
					System.out.print("0 ");
				}else {
					System.out.print(distance[i][j]+ " ");
				}
			}
			System.out.println();
		}
	}
}