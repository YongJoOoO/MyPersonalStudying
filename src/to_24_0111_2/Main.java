package to_24_0111_2;

import java.util.Scanner;

/**
 * 1890번. 점프 - DP 문풀 
 * @author MYLG
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();
		int[][] arr =new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		/**
		 * DP[i][j] 정의 : 1,1 에서 i,j까지 올수 있는 경로의 개수 담기 
		 */
		long[][] DP = new long[N+1][N+1]; //제발 쫌 !!! 담길 수 있는 경로 개수 최대 2^63 이다. long 개빡치넨 
		
		DP[1][1] = 1;//출발지 세팅
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int nx = arr[i][j];//이만큼 점프 가능 
				if(nx == 0) break;//도착점이면 탈출 
				//현재 좌표 i,j에서 오른쪽으로 (i+nx) 가던가, 아래로 (j+nx) 가던가로 갈림
				
				if(i+nx <= N) {//오른쪽 이동 
					DP[i+nx][j] += DP[i][j];//기존 경로 누적 
				}
				if(j+nx <= N) { //아래쪽 이동 
					DP[i][j+nx] += DP[i][j];
				}
			}
		}
		System.out.println(DP[N][N]);//마지막에 담긴 값 출력함
		
	}
}