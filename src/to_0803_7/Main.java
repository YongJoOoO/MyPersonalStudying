package to_0803_7;

import java.util.Scanner;

//1389번. 케빈 베이컨의 6단계 법칙 
public class Main {
	static int[][] distance;//관계 거리 
	static final int INF = 1000001;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		distance = new int[n+1][n+1];//1번부터라서 
		
		//distance 초기화
		for(int i=1; i<=n; i++) {
			for(int j =1; j<=n; j++) {
				if(i==j) distance[i][j] = 0;
				else {
					distance[i][j] = INF;
				}
			}
		}
		
		//입력받기 
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			distance[a][b] = 1;//양방향 서로 친구이니까 
			distance[b][a] = 1;
		}
		
		//다익스트라 시작 
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		//각 학생의 베이컨 수 중 가장 작은 값을 갖는 애의 번호 출력 
		int min = Integer.MAX_VALUE;
		int ans_idx = 0;
		
		for(int i=1; i<=n; i++) {
			int tmp = 0;
			for(int j=1; j<=n; j++) {
				tmp += distance[i][j];//각 i행 합 구하고 
			}
			if(tmp < min) {
				min = tmp;
				ans_idx = i;
			}
		}		
		System.out.println(ans_idx);
	}
}