package to_0324;

import java.util.Scanner;
/* 8-7. 조합의 경우수 (메모이제이션) */
public class Main3 {
	//메모이제이션 사용 
	int[][]dy = new int[35][35];
	//DFS
	public int DFS(int n, int r) {
		if(dy[n][r] > 0) return dy[n][r];
		if(n==r || r==0) return 1;
		else {
			return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
		}
	}
	//실행 메인  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Main3 T = new Main3();
		 Scanner kb =new Scanner(System.in);
		 int n = kb.nextInt();
		 int r = kb.nextInt();
		 System.out.println(T.DFS(n, r));
	}
}