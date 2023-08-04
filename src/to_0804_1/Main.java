package to_0804_1;
//11659번. 구간 합 구하기 4
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		int[] arr = new int[N+1];//데이터 배열 
		int[] S = new int[N+1];//합 배열 
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			arr[i] = kb.nextInt();
			S[i] = S[i-1] + arr[i];
		}
		for(int i=0; i<M; i++) {
			int a =kb.nextInt();
			int b = kb.nextInt();
			answer.add(S[b] - S[a-1]);
		}
		//데이터 출력 
		for(int x : answer) {
			System.out.println(x);
		}
	}
}