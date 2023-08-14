package to_0814_A;

import java.util.Scanner;

//중복 순열 구하기 
public class Main {
	static int N, M;
	static int[] arr;
	//DFS
	static void DFS(int lv) {
		if(lv == M) {
			for(int x : arr) {
				System.out.print(x+ " ");
			}
			System.out.println();
		}else {
			for(int i=1; i<=N; i++) {
				arr[lv] = i;
				DFS(lv+1);
			}
		}
	}
	
	//main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		arr = new int[M];//M개 뽑기 
		
		DFS(0);
		
	}

}
