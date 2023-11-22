package to_1122_B;

import java.util.Scanner;

/**
 * 순열 구하기 - DFS
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static int[] pm;
	//DFS
	static void DFS(int L) {
		if(L == M) {
			for(int x : pm) {
				System.out.print(x + " ");
			}
			System.out.println();
		}else {
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					pm[L] = arr[i];
					DFS(L+1);
					visited[i] = false;
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N  = kb.nextInt();
		M = kb.nextInt();
		visited= new boolean[N];
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = kb.nextInt();
		}
		
		pm = new int[M];
		
		
		DFS(0);
	}
}