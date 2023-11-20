package to_1120_4;

import java.util.Scanner;

/**
 * 중복없이 뽑기 : 조합 구하기 - DFS
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static int[] combi;
	//DFS
	static void DFS(int lv, int st) {
		if(lv == M) {
			for(int x : combi) {
				System.out.print(x+" ");
			}
			System.out.println();
		}else {
			for(int i=st; i<=N; i++) {
				combi[lv] = i;
				DFS(lv+1, i+1);
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		combi = new int[M];
		
		DFS(0, 1);
	}

}
