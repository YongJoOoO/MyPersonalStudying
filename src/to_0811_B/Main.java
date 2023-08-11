package to_0811_B;

import java.util.*;
/*15649번. N과 M */
public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] arr;
	static int[] answer;
	
	//DFS
	static void DFS(int lv) {
		if(lv == M) {
			for(int x : answer) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;//여기서 복귀 
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;//방문체크
				answer[lv] = arr[i]; //i번쨰 값을 담고 
				DFS(lv+1);//다음 깊이로 
				visited[i] = false;
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();//1~N까지
		M = kb.nextInt();//M개 뽑을 건데 
		
		arr= new int[N];
		for(int i=0; i<N; i++) arr[i] = i+1;//1~N까지 값 담고 
	
		visited= new boolean[N];//방문 체크용 배열 
		answer = new int[M];//얘는 M개 뽑을 거라
		
		DFS(0);
		
	}
}