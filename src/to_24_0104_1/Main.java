package to_24_0104_1;

import java.util.Scanner;

/**
 *  1182번. 부분 수열의 합 - 백트래킹 
 * @author MYLG
 *
 */
public class Main {
	static int N, S;
	static int[] arr;
	static int count= 0;
	//DFS
	static void DFS(int lv, int sum) {
		if(lv == N) {
			if(sum == S) {
				count++;
			}
			return;
		}
		
		DFS(lv+1, sum + arr[lv]); //현재 원소 선택 O
		DFS(lv+1, sum ); //선택 X
		
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		S = kb.nextInt();//타겟 넘버
		
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = kb.nextInt();
		
		DFS(0, 0);
		//애초에 0으로 들어온 경우는 DFS 돌자마자 ++처리 되므로 
		if(S == 0) count--;
		
		System.out.println(count);
	}
}