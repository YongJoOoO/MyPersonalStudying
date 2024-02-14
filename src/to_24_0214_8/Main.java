package to_24_0214_8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 11437번. 최소공통조상구하기 1 - LCA 문풀 
 * @author MYLG
 *
 */
public class Main {
	static ArrayList<ArrayList<Integer>> tree;
	static int[] parent;
	static int[] depth;
	static boolean[] visited;
	//BFS
	private static void BFS(int root) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(root);
		visited[root] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int nx : tree.get(cur)) {
				if(!visited[nx]) {
					visited[nx] = true;
					Q.offer(nx);
					
					parent[nx] = cur;
					depth[nx] = depth[cur] + 1;
				}
			}
		}
	}
	//getLCA
	private static int getLCA(int a, int b) {
		//깊이 더 큰 애를 a에 담기 
		if(depth[a] < depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		//깊이 같아질 때까지 맞추기
		while(depth[a] != depth[b]) {
			a = parent[a];//계속 올림(더 깊이 높은 애를)
		}
		//맞춰서 탈출했으면 이제 동시에 올림
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		parent = new int[N+1];
		depth = new int[N+1];
		visited = new boolean[N+1];
		
		tree = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i=0; i<N-1; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향 간선 채우기
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		BFS(1);//정보 담기 
		
		//2) LCA 구하기
		int M = kb.nextInt();
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			System.out.println(getLCA(a, b));
		}
	}
}