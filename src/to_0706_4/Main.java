package to_0706_4;

import java.util.ArrayList;
import java.util.Scanner;

/* 2660번. 회장 뽑기 문제 
 * */
public class Main {
	//static
	static int N;
	static int[][] distance;
	static final int INF = 100;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		distance = new int[N+1][N+1];
		
		//초기화 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j ) distance[i][j]= 0;
				else {
					distance[i][j]= INF;
				}
			}
		}
		
		//입력 데이터 저장 
		while(true) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			if(a == -1 && b == -1) {
				break;
			}
			//친구 사이 = 양방향 
			distance[a][b] = 1;
			distance[b][a] = 1;
		}
		
		//플로이드 워샬 
		for(int k=1; k<=N; k++) {
			for(int i = 1; i<=N; i++) {
				for(int j =1; j<=N; j++) {
					if(distance[i][j] > distance[i][k]+ distance[k][j]) {
						distance[i][j]= distance[i][k]+distance[k][j];
					}
				}
			}
		}
		
		
		
		
	}

}
