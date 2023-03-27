package to_0327;

import java.util.Scanner;

/* 8-9. 조합 구하기 | DFS | 외워버리기 */
public class Main2 {
	static int[] combi;
	static int n, m;
	//DFS
	public void DFS(int L, int s) {
		if(L==m) {
			for(int x: combi) System.out.print(x+ " ");
			System.out.println();
		}else {
			for(int i=s; i<=n; i++) {
				combi[L]=i;
				DFS(L+1, s+1);
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		combi = new int[m];
		T.DFS(0, 1); //0레벨 1부터 시작
	}
}