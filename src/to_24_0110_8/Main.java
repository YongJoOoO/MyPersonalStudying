package to_24_0110_8;

import java.util.Scanner;

public class Main {

	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N=  kb.nextInt();
		int[][] arr  = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		
		/**
		 * dy[i][j] : (1,1)에서 (i,j)까지 규칙에 맞게 이동 가능한 경로의 개수 
		 */
		long[][] dy = new long[N+1][N+1]; //2^63까지 가능 
		dy[1][1] = 1;
		
		//무조건 오른쪾, 아래쪽 두 방향만 가능
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int nx = arr[i][j];//다음 이동 점프
				if(nx == 0) break;//목적지 도착
				
				if(i + nx <= N) {
					dy[i+nx][j] += dy[i][j];//직전 경로 ++ 처리 
				}
				if(j+nx <=N) {
					dy[i][j+nx] += dy[i][j];
				}
			}
		}		
		System.out.println(dy[N][N]);//마지막 칸 	
	}
}