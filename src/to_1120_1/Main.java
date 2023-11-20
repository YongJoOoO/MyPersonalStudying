package to_1120_1;

import java.util.Scanner;

/**
 * 중복순열 구하기 - DFS
 * @author MYLG
 *
 */
public class Main {
	static int N,M;
	static int[] num;//여기에 뽑은 애들 담기?
	
	//DFS
	static void DFS(int lv) {
		if(lv == M) {
			//여기서 출력 
			for(int x : num) {
				System.out.print(x + " ");
			}
			System.out.println();
		}else {
			for(int i=1; i<=N; i++) {
				num[lv] = i;
				DFS(lv+1);
			}
		}
	}

	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		num = new int[M];//lv만틈
		
		DFS(0);
	}

}
