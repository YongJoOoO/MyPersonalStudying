package to_1123_3;

import java.util.Scanner;

/**
 * 플로이드 문풀
 * @author MYLG
 *
 */
public class Main {
	static final int INF = 10000001;
	static int N, M;
	static int[][] map;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		//초기화
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i != j) {
					map[i][j] = INF;
				}
			}
		}
		
		//m개의 간선 정보 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int val = kb.nextInt();
			if(map[a][b] > val) {
				map[a][b] = val;
			}
		}
		
		//플로이드 철 
		for(int k =1; k<=N; k++) {
			//경유지 차례로 순회
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		//답 출력 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == INF) {
					System.out.print("0 ");
				}else {
					System.out.print(map[i][j] + " ");
				}
			}
			System.out.println();
		}		
	}
}