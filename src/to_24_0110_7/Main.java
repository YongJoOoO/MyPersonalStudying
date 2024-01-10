package to_24_0110_7;

import java.util.Scanner;

/**
 * 1890번. 점프 - DP 문풀 
 * @author MYLG
 *
 */
public class Main {

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		
		int[][] arr = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				arr[i][j]= kb.nextInt();
			}
		}
		
		//DP 배열 - 경로 개수 2 ^63 이므로 
		long[][] DP = new long[N+1][N+1];
		DP[1][1] = 1; // 1,1
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int nx = arr[i][j];
				if(nx == 0) break;//도착
				
				//오른쪽으로 +nx
				if(i+nx <= N) {
					DP[i+nx][j] += DP[i][j];//현재값에서 
				}
				//아래로 +nx
				if(j+nx <= N) {
					DP[i][j+nx] += DP[i][j];
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				System.out.print(DP[i][j] + " ");
			}
			System.out.println();
		}
		
		//System.out.println(DP[N][N]);
	}

}
