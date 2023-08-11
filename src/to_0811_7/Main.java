package to_0811_7;

import java.util.Scanner;

/*14248번. 점프 점프 */
public class Main {
	static int n;
	static boolean[] visited;
	static int[] A;//가능수
	static int s;//출발점 
	static int answer;
	//dfs
	static void DFS(int v) {
		if(visited[v]== true) return;//복귀
		
		visited[v]= true;
		
		int L = v - A[v];
		int R = v + A[v];
		
		if(L > 0 && L <= n) DFS(L);
		
		if(R >0 && R <= n) DFS(R);
	}
	
	//main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		n = kb.nextInt();//돌다리 개수 
		A = new int[n+1];
		visited = new boolean[n+1];
	
		for(int i=1; i<=n; i++) A[i]=  kb.nextInt();
		
		s = kb.nextInt(); //출발점 
		answer = 0;
		DFS(s);
		
		//정답 출력 
		for(int i=1; i<=n; i++) {
			if(visited[i] == true) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}
}