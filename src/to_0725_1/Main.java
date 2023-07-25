package to_0725_1;

import java.util.Scanner;

/*배군 4781번. 사탕 가게 - 
 * 냅색(배낭) 문제 - 동전1, 동전2 , 평범한 배낭 등 
 *  D[i] 의 정의 : i원을 가지고 얻을 수 있는 최대 칼로리. 
 * */
public class Main{
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);		
		while(true) {
			int n = kb.nextInt();
			int m = (int) Math.round(kb.nextDouble() * 100);
			
			if(n == 0 && m==0) break;
			int[] D = new int[m+1];
			for(int i=0; i<n; i++) {
				int c = kb.nextInt();
				int p = (int) Math.round(kb.nextDouble() * 100);
				for(int j=p; j<=m; j++) { //각 p원부터 시작해서 m원까지 가며
					D[j] = Math.max(D[j], D[j-p] + c); //D[j], D[j-p] + c(칼로리) 비교하여 더 큰값 세팅 
				}
			}
			//m원으로 얻을 수 있는 최대 칼로리 
			System.out.println(D[m]);
		}	
	}
}