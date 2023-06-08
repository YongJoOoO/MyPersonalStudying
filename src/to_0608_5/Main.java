package to_0608_5;

import java.util.ArrayList;
import java.util.Scanner;

/* 13023번. 친구 관계 파악하기 
 * */
public class Main {
	static ArrayList<Integer> [] A;
	static boolean visited[];
	static boolean arrive;
	
	//DFS()
	static void DFS(int v, int lv) {
		if(lv == 5 || arrive ) {
			arrive = true;
			return;
		}
		
		visited[v] = true;
		for(int i : A[v]) {
			if(!visited[i]) {
				DFS(i, lv+1);
			}
		}
		//여기서 false 주는 이유 
		//다시 복귀할 때, 다른 뿌리로 lv 깊이 탐색 해야 하기 때문에 다 탐색한 뒤엔 false 준 뒤 복귀할 것.
		visited[v] = false;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		visited = new boolean[n];
		A = new ArrayList[n];
		
		for(int i=0; i<n; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m ; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			A[a].add(b);
			A[b].add(a);
		}
		//brak 걸어줄 용도 임
		arrive = false;
		
		for(int i=0; i<n; i++) {
			DFS(i, 1);
			
			if(arrive) break;
		}
		
		if(arrive == true) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
		
	}

}
