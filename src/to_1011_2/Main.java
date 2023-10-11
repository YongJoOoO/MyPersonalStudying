package to_1011_2;

import java.util.*;

/*15654번. N과 M (5) 백트래킹 */
public class Main {
	static int N, M;
	static int[] num;//최초 N개 담을 거임 
	static int[] arr;//여기에 뽑은 거 담을 거임
	static boolean[] visited;//방문체크
	//DFS
	static void DFS(int lv) {
		if(lv == M) {//M개 뽑았으면 
			for(int i=0; i<M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		//전체 순회하면서 
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[lv] = num[i];
				DFS(lv+1);
				visited[i] = false;//복귀 시 풀어주고 
			}	
			
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		
		num = new int[N];
		visited = new boolean[N];
		arr = new int[M];
		
		for(int i=0; i<N; i++) {
			num[i] = kb.nextInt();
		}
		//정렬
		Arrays.sort(num);
		
		//lv 0, 시작 0
		DFS(0);
	}
}