package to_1122_A;

import java.util.Scanner;

/**
 * 중복순열 구하기 - DFS
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static int pm[];
	//DFS
	static void DFS(int L, int val) {
		if(L == M) {
			for(int x : pm) {
				System.out.print(x + " ");
			}
			System.out.println();
		}else {
			for(int i=1; i<=N; i++) {
				pm[L] = i;
				DFS(L+1, i);
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		
		pm = new int[M];
		
		DFS(0, 0);
	}
}
