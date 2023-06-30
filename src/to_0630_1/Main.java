package to_0630_1;

import java.util.ArrayList;
import java.util.Scanner;

/*구간합 - 백준. 11659번. 구간 합 구하기 */
public class Main {
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb =new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		int[] arr =new int[N+1];
		int[] sum = new int[N+1];
		//미리 구간합을 구해놓고 
		for(int i=0; i<N; i++) {
			arr[i+1] = kb.nextInt();
			sum[i+1] = sum[i] + arr[i+1];
		}
		
		int answer[] = new int[M];
		for(int i=0; i<M; i++) {
			int k = kb.nextInt();
			int j = kb.nextInt();
			
			answer[i] = sum[j] - sum[k-1];
		}
		
		for(int x : answer) System.out.println(x);
		
	}

}
