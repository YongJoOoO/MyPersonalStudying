package to_1221_1;

import java.util.Scanner;

/**
 * 백트래킹 
 *
 *백준 1182번. 부분수열의 합 - DFS
 * @author MYLG
 *
 */
public class Main {
	static int answer;
	static int N, S;
	static int[] num;
	static boolean[] visited;
	//DFS
	static void DFS(int lv, int sum) {
		if(lv == N) {//그걸 N번
			if(sum == S)answer++;	
			return;
		}
		
		DFS(lv+1, sum + num[lv]); //현재 레벨의 원소 뽑은 경우
		DFS(lv+1, sum); //안뽑은 경우
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		S = kb.nextInt();
		
		num = new int[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) num[i]= kb.nextInt();
		answer = 0;
		DFS(0, 0);
		
		if(S == 0) answer--;
		
		System.out.println(answer);
	}
}