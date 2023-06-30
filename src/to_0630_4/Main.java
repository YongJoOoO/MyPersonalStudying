package to_0630_4;

import java.util.Arrays;
import java.util.Scanner;

/**/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();
		int[] arr = new int[N+1];
		
		int[] sum = new int[N+1];
		
		for(int i=0; i<N; i++) {
			arr[i+1] = kb.nextInt();
		}
		Arrays.sort(arr);
		sum[0] = arr[0];
		for(int i=1; i<N; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		int answer=  0;
		for(int i=0; i<=N; i++) {
			answer+=sum[i];
		}
	
		System.out.println(answer);
	}
}