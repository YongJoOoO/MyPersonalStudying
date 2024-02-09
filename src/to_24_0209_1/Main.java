package to_24_0209_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 11725번. 트리의 부모 찾기 
 * @author MYLG
 *
 */
public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> tree;
	static boolean[] visited;
	static int[] answer;
	//DFS
	static void DFS(int v) {
		
		for(int nx : tree.get(v)) {
			if(!visited[nx]) {
				visited[nx] = true;
				answer[nx] = v;//nx의 부모를 직전으로 세팅해줌
				DFS(nx);
				visited[nx] = false;
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		visited = new boolean[N+1];
		answer = new int[N+1];
		
		tree = new ArrayList<>();
		//초기화
		for(int i=0; i<=N; i++) {
			tree.add(new ArrayList<>());
		}
		
		//데이터 입력 
		for(int i=0; i<N-1; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향 간선 추가 
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		
		visited[1] = true;
		//무조건 1로 싲가 
		DFS(1);
		
		for(int i=2; i<=N; i++) {
			System.out.println(answer[i]);
		}	
	}
}