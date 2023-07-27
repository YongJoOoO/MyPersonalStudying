package to_0727_1;

import java.util.Scanner;

//4781번. 사탕 가게 문제 복습 
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		while(true) {
			int n = kb.nextInt();
			int m = (int) Math.round(kb.nextDouble() * 100);
			
			if(n == 0 && m ==0) break;
			
			int[] dy = new int[m+1];
			for(int i=0; i<n; i++) {
				//사탕 칼로리, 가격 입력받기 
				int c = kb.nextInt(); //얘가 칼로리 
				int p = (int) Math.round(kb.nextDouble() * 100); //얘가 돈
				
				for(int j =p; j<=m; j++) {
					dy[j] = Math.max(dy[j], dy[j-p] + c);
						//그냥 j원으로 살 때 vs j-p원+p원 조합으로 살때 중 더 큰 칼로리로 세팅한다.
				}
			}
			System.out.println(dy[m]);//m원으로 살 수 있는 애 
		}
	}
}