package to_1122_4;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static int target;
	static boolean flag;
	//DFS
	static void DFS(int L, int sum) {
		//이미 7개 담았으면 X or 
		if(L > N || sum > target) return; 
		
		if(sum == target) {
			flag = true;
			return;
		}else {
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					DFS(L+1, sum += arr[i]);
					visited[i] = false;
				}
			}
		}
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		arr = new int[N];
		
		target = 0;
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = kb.nextInt();
			target += arr[i];
		}
		
		flag = false;

		
		DFS(0, 0);
		
		if(flag == true) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}
}