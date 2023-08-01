package to_0801_6;

import java.util.Scanner;

//14916번. 거스름돈 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int[] coin = new int[2];
		coin[0] = 2;
		coin[1] = 5;
		
		int[] dy = new int[n+1];
		
		dy[0] = 0;
		dy[1] = 0;
		dy[2] = 1;
		
		for(int i=0; i<2; i++) {
			int cur = coin[i];
			for(int j=3; j<=n; j++) {
				if(dy[j-cur] == 0) continue;
				dy[j] = Math.min(dy[j] , dy[j-cur] + 1);	
			}
		}
		
		if(dy[n] == 0) System.out.println("-1");
		else {
			System.out.println(dy[n]);
		}		
	}

}
