package to_0928_9;


import java.util.*;

/*1719번. 택배 - 플로이드 문풀 */
public class Main {
	static int N, M;
	
	static int[][] board;
	static int[][] gyeongU;//경유지 담기 
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
	
		N = kb.nextInt();
		M = kb.nextInt();
		
		board = new int[N+1][N+1];
		gyeongU = new int[N+1][N+1];
		
		//초기화
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i!=j) {
					board[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int v = kb.nextInt();
			//간선은 양방향으로 담을 거고 
			board[a][b] = v;
			board[b][a] = v;
			
			//경유지 세팅은 
			gyeongU[a][b]= b;
			gyeongU[b][a]= a;
		}
		
		//플로이드 시작 
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					if(board[i][j] > board[i][k]+ board[k][j]) {
						//k경유해서 더 최단 거리 가능하다면 !! 갱신 
						board[i][j] = board[i][k] + board[k][j];
						//경유지를 담아야 함 
						gyeongU[i][j] = gyeongU[i][k];
					}
				}
			}
		}

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) System.out.print("- ");
				else System.out.print(gyeongU[i][j] +" ");
			}
			System.out.println();
			
		}

		
	}

}
