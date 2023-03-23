package to_0323;

import java.util.Scanner;
/* 8-3. 최대 점수 구하기 DFS   
 * */
public class Main3 {
	static int answer = Integer.MIN_VALUE;
	static int n, m;
	boolean flag = false;
	//DFS
	public void DFS(int L, int sum, int time, int[]ps, int[]pt) {
		//제한 시간 넘어갈 경우 return;
		if(time > m) return;
		if(L == n) {
			answer = Math.max(answer, sum);
		}else {
			//문제 푼다
			DFS(L+1, sum+ps[L], time+pt[L], ps, pt);
			//문제 안푼다.
			DFS(L+1, sum, time, ps, pt);
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); //문제수
		m = kb.nextInt(); //제한 시간 
		int[] ps = new int[n];
		int[] pt = new int[n];
		//입력받기 
		for(int i=0; i<n; i++) {
			ps[i] = kb.nextInt();
			pt[i] = kb.nextInt();
		}
		T.DFS(0, 0, 0, ps, pt);
		//출력
		System.out.println(answer);
	}
}