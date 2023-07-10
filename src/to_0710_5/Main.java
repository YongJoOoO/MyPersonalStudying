package to_0710_5;

import java.util.Scanner;

/*2407번. 조합 */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n =kb.nextInt();
		int m = kb.nextInt();
		int[][] D = new int[101][101]; //여기서 자료형을 변형해야 한다. 
		//왜냐면 숫자가 너무 커지기 때문
		
		//초기화
		for(int i=0; i<=100; i++) {
			D[i][0] = 1;
			D[i][1] = i;
			D[i][i] = 1;
		}		
		//점화식으로 데이터 확장하기
		for(int i=2; i<=100; i++) {
			for(int j=1; j<i; j++) {
				D[i][j] = D[i-1][j] + D[i-1][j-1];
			}
		}
		//정답 출력
		System.out.println(D[n][m]);
	}
}