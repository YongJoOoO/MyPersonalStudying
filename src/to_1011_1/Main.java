package to_1011_1;

import java.util.*;

/*c번. N과 M - (4) 백트래킹 */
public class Main {
	static int N, M;
	static int[] num;
	
	//DFS
	static void DFS(int lv, int st) {
		if(lv==M) {
			for(int i=0; i<M; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=st; i<=N; i++) {
			num[lv] = i;
			DFS(lv+1, i);
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		//크기 M짜리 
		num = new int[M];
		
		DFS(0, 1);
	}
}