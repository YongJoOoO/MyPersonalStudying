package to_1227_5;

import java.util.Scanner;

/**
 * 9466번. 텀 프로젝트 - DFS -> 사이클 확인해야 함
 * -> RE 다시 풀어보기 ㅠㅠ 
 */
public class Main {
	static int TC;
	static int N;
	static int[] arr;
	static boolean[] visited;
	static boolean[] done;
	static int count;
	//DFS
	static void DFS(int n) {
		if(visited[n]) {
			done[n] = true;
			count++;
		}else {
			visited[n] = true;
		}
		if(!done[arr[n]]) {
			DFS(arr[n]);
		}
		
		visited[n] = false;
		done[n] = true;
	}

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		TC = kb.nextInt();
		for(int t= 0; t<TC; t++) {
			N = kb.nextInt();
			arr =new int[N+1];
			done = new boolean[N+1];
			visited = new boolean[N+1];
			
			count = 0;
			for(int i=1; i<=N; i++) arr[i] = kb.nextInt();
			
			for(int i=1; i<=N; i++) { //완료되지 않은 애에 대해서 깊이 탐색 
				if(!done[i]) {
					DFS(i);
				}
			}
			System.out.println((N-count) );
		}
	}
}