package to_0928_7;

import java.util.HashMap;
import java.util.Scanner;

/*2224번. 명제 증명 - 플로이드 문풀 */
public class Main {
	static int N;
	static int[][] map;
	static char[] ch;//문자 담을 용도 
	static final int INF = Integer.MAX_VALUE;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();

		
		map = new int[N][N];
		//초기화 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i!=j) {
					map[i][j] = INF;
				}
			}
		}
		
	}

}