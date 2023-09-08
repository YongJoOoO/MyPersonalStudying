package to_0908_G;

import java.util.ArrayList;
import java.util.Scanner;

/*11659번. 구간 합 구하기 4 */
public class Main {
	
	//실행메인 
	public static void main(String[] args) {
		// T	ODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N =kb.nextInt();
		
		int M = kb.nextInt();
		int[] arr = new int[N+1];
		
		int[] sum = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = kb.nextInt();
		}
		sum[1] = arr[1];
		for(int i=2; i<=N; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		ArrayList<Integer> answer = new ArrayList<>();
		//이제 M개 답
		for(int i=0; i<M; i++) {
			int a= kb.nextInt();
			int b = kb.nextInt();
			answer.add(sum[b] - sum[a-1]);
		}
		
		for(int x : answer) {
			System.out.println(x);
		}
	}
}