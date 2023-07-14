package to_0714_5;

import java.util.Scanner;

/*1915번. 가장 큰 정사각형 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[][] DP = new long[1001][1001];//가장 max값으로 세팅 
		
		Scanner kb= new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		long max = 0;//최대 변 길이 저장용 
		
		for(int i=0; i<n; i++) {
			//라인 단위로 입력받고 세팅 
			String tmp = kb.next();
			
			for(int j =0; j<m; j++) {
				//라인 단위로 받은 애를 j값으로 하나씩 찍으면서 Long타입으로 변환시킨다음에 저장시켜야 함 
				DP[i][j] = Long.parseLong(String.valueOf(tmp.charAt(j)));//char로 뽑은 애를 String으로 변환한 뒤 다시 Long타입 변환 
				if(DP[i][j] == 1 && i >0 && j>0 ) {
					DP[i][j] = Math.min(DP[i-1][j-1], Math.min(DP[i-1][j], DP[i][j-1])) + DP[i][j];
				}
				if(max < DP[i][j]) max = DP[i][j];
			}		
		}		
		//최종 넓이 출력 
		System.out.println(max * max);
	}
}