package to_0717_1;

import java.util.ArrayList;
import java.util.Scanner;

//11659번. 구간 합 구하기 4
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		int[] A = new int[N+1];
		int[] S = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			A[i] = kb.nextInt();
		}
		
		S[1] = A[1];
		for(int i=2; i<=N; i++) {
			S[i] = S[i-1] + A[i];// 구간 합 구해두고 
		}
		
		ArrayList<Integer > answer = new ArrayList<>();
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			answer.add(S[b] - S[a-1]);
		}
		//정답 출력 
		for(int x : answer ) System.out.println(x);
	}
}