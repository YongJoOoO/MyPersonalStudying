package to_0728_6;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();//문제 개수 
		int M = kb.nextInt(); //제한 시간 
			
		int[] dy = new int[M+1];//시간을 기준으로 
		for(int i=0; i<N; i++) {//문제 각각
			int S = kb.nextInt();//점수
			int T = kb.nextInt();//시간 
			
			for(int j=M; j>=T; j--) {//시간 역순으로 돌면서 
				dy[j] = Math.max(dy[j], dy[j-T] + S);//기존 시간 vs T시간과 조합한 점수 중 큰값 세팅 
			}
		}
		System.out.println(dy[M]);
	}
}