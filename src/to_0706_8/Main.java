package to_0706_8;

import java.util.Scanner;

/*플로이드 - 케빈 베이컨 6단계 법칙 RE*/
public class Main {
	static int n, m;
	static int[][] distance;
	static final int INF = 1000001;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();
		
		distance = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) distance[i][j] = 0;
				else distance[i][j] = INF;
			}
		}
		
		//입력 데이터 받기 
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			distance[a][b] = distance[b][a] = 1;
			
		}
		
		//플로이드 워샬
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(distance[i][j]>distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		int[] person = new int[n+1];
		int min = INF;
		//정답 세팅
		for(int i=1; i<=n; i++) {
			int tmp = 0;
			for(int j=1; j<=n; j++) {
				tmp+= distance[i][j];
			}
			person[i] = tmp;
			min = Math.min(min, person[i]); //가장 작은 값 세팅 
		}
		
		for(int i=1; i<=n; i++) {
			if(min == person[i]) {
				System.out.println(i);
				break;
			}
		}
	}
}