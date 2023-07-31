package to_0731_5;

import java.util.Arrays;
import java.util.Scanner;

//동전교환 냅색 알고리즘 
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		
		int M = kb.nextInt();
		int[] dy = new int[M+1];
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;
		
		for(int i=0; i<n; i++) {
			int cur = arr[i];
			for(int j= cur; j<=M; j++) {
				dy[j] = Math.min(dy[j], dy[j - cur] + 1);
			}
		}
		System.out.println(dy[M]);
	}
}