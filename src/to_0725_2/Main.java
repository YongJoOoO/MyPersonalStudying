package to_0725_2;

import java.util.Scanner;

//RE 풀어보기 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		while(true) {
			int n = kb.nextInt();
			int m = (int) Math.round(kb.nextDouble() * 100);
			
			if(n==0 && m==0) break;
			
			int[] dy = new int[m+1];//m원까지 나와야 하므로
			for(int i=0; i<n; i++) {
				int c = kb.nextInt();
				int p = (int) Math.round(kb.nextDouble() * 100);
				for(int j=p; j<=m; j++) {
					dy[j] = Math.max(dy[j], dy[j-p] + c);
				}
			}
			//정답 출력 
			System.out.println(dy[m]);
		}
	}
}