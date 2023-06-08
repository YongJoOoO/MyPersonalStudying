package to_0608_3;
/*다시 풀어보기 */

import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] A;
	static boolean visited[];
	//DFS
	static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		for(int x : A[v]) {
			if(visited[x]==false) {
				DFS(x);
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		visited = new boolean[n+1];
		
		A = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			A[i] = new ArrayList<>();//각 공간 생성 
		}
		
		//입력받기 정보
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향 쌍으로 넣기
			A[a].add(b);
			A[b].add(a);
		}
		
		//전체 노드 순회하면서 DFS호출 
		int cnt = 0;
		for(int i=1; i<n+1; i++) {
			if(!visited[i]) {
				cnt++;
				DFS(i);
			}
		}
		
		System.out.println(cnt);
	}

}
