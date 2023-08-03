package to_0803_D;

import java.util.Scanner;

//백준 11404번, 플로이드 RE
public class Main {
	static int[][] distance;//2차원 배열로 s->e로 가는 최단 경로 저장
	static final int INF = 10000001;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();//도시
		int m = kb.nextInt();//버스 개수 
		
		//distance 초기화
		distance = new int[n+1][n+1];//도시 1번부터라

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) distance[i][j] = 0;//자기자신 0 세팅 
				else {
					distance[i][j] = INF;//제일 큰 값으로 초기확 
				}
			}
		}

		//입력 데이터 얻기
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int val = kb.nextInt();
			if(distance[a][b] > val) {
				distance[a][b]= val;
			}
		}
		//플로이드 알고리즘 시작 
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		//출력 갈수없는 경우는 INF 인 경우고 그 외에는 경로 출력 
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(distance[i][j] == INF) {
					System.out.print("0 ");
				}else {
					System.out.print(distance[i][j]+" ");
				}
			}
			System.out.println();//출력
		}
	}
}