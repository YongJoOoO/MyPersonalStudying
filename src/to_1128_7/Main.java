package to_1128_7;

import java.util.Scanner;

/**
 * 피보나치 수열 - 
 * @author MYLG
 *
 */
public class Main {
	static int N;
	static int[] arr;
	//DFS
	static void DFS(int lv) {
		if(lv == N + 1) return;
		else {
			arr[lv] = arr[lv-1] + arr[lv-2];
			DFS(lv+1);
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		//총 항의 수 
		arr = new int[N + 1];
		arr[1] = 1;
		arr[2] = 1;
		DFS(3);
		
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i] +  " ");
		}
	}
}