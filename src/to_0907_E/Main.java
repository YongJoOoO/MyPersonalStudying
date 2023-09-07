package to_0907_E;

import java.util.Scanner;

/*최대 점수 구하기 - DP*/
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		int[] dy = new int[M+1];//시간 기준
		
		for(int i=0; i<N; i++) {
			int s = kb.nextInt();//점수 
			int t= kb.nextInt();//시간 
			
			for(int j=M; j>=t; j--) {
				//시간 역순으로 돌면서 입력으로 들어온 시간 뺀 dy값에 점수 s 를 더하는 행위를 반복하면서 그 최대값을 구한다. 
				dy[j] = Math.max(dy[j], dy[j-t]+s);
			}
		}
		//m분 동안 얻을 수 있는 최대 점수를 출력한다. 
		System.out.println(dy[M]);
	}

}
