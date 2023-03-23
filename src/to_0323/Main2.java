package to_0323;

import java.util.Scanner;

/* 8-2. 바둑이 승차(DFS)
[입력]
첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
둘째 줄부터 N마리 바둑이의 무게가 주어진다.
[출력]
*/
public class Main2 {
	static int c, n, answer=Integer.MIN_VALUE;
	boolean flag = false;
	//DFS
	public void DFS(int L, int sum, int[]arr ) {
		//트럭 용량 C 넘어가면 그냥 리턴
		if(sum > c) return;
		if(L == n) {
			//마지막 레벨딴 까지 오면 기존 answer와 들어온 sum 중에 더 큰 값으로 answer 세팅
			answer = Math.max(answer, sum);
		}else {
			//사용O
			DFS(L+1, sum+arr[L], arr);
			//사용X
			DFS(L+1, sum, arr);
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		c = kb.nextInt();
		n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		
		T.DFS(0, 0, arr);
		System.out.println(answer);
	}
}