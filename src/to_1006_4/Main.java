package to_1006_4;
import java.util.*;

/*백준 2798번. 블랙잭 - 브루투포스 문풀 */
public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;///기존 값 
	//DFS
	static void DFS(int lv, int sum) {
		if(lv==3) {
			if(sum <= M) {
				max = Math.max(max, sum);
			}
			return; //무조건 복귀 
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(lv+1, sum + arr[i]);
				visited[i] = false;
			}
		}
		
		
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = kb.nextInt();
		
		visited = new boolean[N];
		
		DFS(0, 0);
		
		System.out.println(max);
	}	
}