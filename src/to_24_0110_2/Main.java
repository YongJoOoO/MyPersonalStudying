package to_24_0110_2;

import java.util.Scanner;

/**
 * RE
 * @author MYLG
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int[] arr = new int[N];
		int[] dy = new int[N];
		
		for(int i=0; i<N; i++) arr[i] = kb.nextInt();
		
		dy[0] = 1;
		
		int answer = dy[0]; //answer= 0으로 세팅하면 틀리고 
		
		for(int i=1; i<N; i++) {
			int mx = 0;
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					mx = Math.max(mx, dy[j]);
				}
			}
			dy[i] = mx+1;
			answer = Math.max(answer, dy[i]);
		}
		
		System.out.println(answer);
	}

}
