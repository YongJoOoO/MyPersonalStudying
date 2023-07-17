package to_0717_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		int[][] A = new int[N+1][N+1];
		//입력 데이터 세팅 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				A[i][j] = kb.nextInt();
			}
		}
		
		//구간 합 구해놓기 1행 1열 초기화 
		int[][] D = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				//구간 합 초기화 
				//왼쪽 + 위쪽 - 대각선쪽 + 현재값
				D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j];
			}
		}
		
		//이제 각 구간별 질의 대답 정하기 
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			int x1 = kb.nextInt();
			int y1 = kb.nextInt();
			int x2 = kb.nextInt();
			int y2 = kb.nextInt();
			
			int tmp = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
			answer.add(tmp);
		}
		//정답 출력 
		for(int x : answer) System.out.println(x);
	}
}