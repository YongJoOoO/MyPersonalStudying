package to_1023_1;

import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] sum;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		
		arr = new int[N+1];
		sum = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = kb.nextInt();
		}
		
		//sum세팅
		for(int i=1; i<=N; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		
		int[] result = new int[M];
		for(int i=0; i<M; i++) {
			//구간 합 구하기 
			int a = kb.nextInt();
			int b = kb.nextInt();
			result[i] = sum[b] - sum[a-1];
		}
		
		for(int x : result) {
			System.out.println(x);
		}
	}

}