package back_0328;

import java.util.Scanner;

/* 2407번. 조합  */
public class Main {
	static int[] combi;
	static int n, m;
	//DFS
	public void DFS(int L, int s) {
		if(L == m) {
			for(int x: combi) System.out.print(x+ " ");
			System.out.println();
		}else {
			for(int i=s; i<=m; i++) {
				combi[L] =i;
				DFS(L+1, s+1);
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		combi = new int[m];
		
		T.DFS(0,1);
	}

}
