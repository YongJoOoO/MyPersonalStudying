package to_0608_7;

import java.util.ArrayList;
import java.util.Scanner;

/*21937번. 작업 RE 풀것 */
public class Main {
	//정적
	static ArrayList<Integer>[] A;
	static boolean visited[];
	
	static int k; //찾는 수 
	static int answer; //정답 횟수 
	//DFS
	static void DFS(int v, int lv) {
		if(visited[v]) {
			return;
		}
		
		visited[v] = true;//방문 처리 
		
		for(int x : A[v]) {
			if(!visited[x] && x != k) {
				DFS(x, lv+1);
			}else if(!visited[x] && x == k) {
				DFS(x, lv+1);
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();//정점
		int m = kb.nextInt();//간선
		
		visited = new boolean[n+1]; //n 1부터 
		A = new ArrayList[n+1];//담을 용도 
		
		for(int i=1; i<n+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		//간선 개수만큼 입력받기
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			A[a].add(b); //얘는 순서가 있어서 한쪽만 담을 거임 
		}
		
		//할 작업은 
		k = kb.nextInt();//얘가 꼭 해야하는 작업이고
		
		for(int i=1; i<n+1; i++) {//간선 차례로 순회할 건데 
			DFS(i,0);
		}
		
		//출력 필요
		System.out.println(answer);

	}
}