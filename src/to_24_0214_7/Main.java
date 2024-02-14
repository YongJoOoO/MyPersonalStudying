package to_24_0214_7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 11437번. LCA - LCA 문풀
 * @author MYLG
 *
 */
public class Main {
	static ArrayList<ArrayList<Integer>> tree;
	static int[] depth;//각 i별 깊이 
	static int[] parent;//각 i별 부모노드 
	static boolean[] visited;
	
	 // BFS구현
	  private static void BFS(int node) { 
	    Queue<Integer> Q = new LinkedList<Integer>();
	    Q.add(node);
	    visited[node] = true;    
	    while (!Q.isEmpty()) {
	      int now_node = Q.poll();
	      for (int next : tree.get(now_node)) {
	        if (!visited[next]) {
	          visited[next] = true;
	          Q.add(next);
	          parent[next] = now_node;  //부모 노드 저장
	          depth[next] = depth[now_node] + 1;
	        }
	      }
	    }
	  }
	  
	//getLCA
	private static int getLCA(int a, int b) {
		if(depth[a] < depth[b]) {//더 깊은 노드를 a기준으로 swap
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while(depth[a] != depth[b]) {//두 노드 깊이 맞추기 위함
			a = parent[a]; //더 깊은 노드를 계속 한칸씩 거슬러올림 
		}
		
		while(a != b) { //같은 조상 나올 때까지 동시에 한칸씩 올림 
			a = parent[a];
			b = parent[b];
		}
		//같아져서 탈출한 상황 -> LCA 리턴
		return a;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		
		tree = new ArrayList<>();
		for(int i=0; i<=N; i++) tree.add(new ArrayList<>());
		
		depth = new int[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		
		//1) 데이터 세팅 
		for(int i=0; i<N-1; i++) {//N개 노드에 대한 간선 정보는 N-1개 들어옴
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향 이어주기
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		// 2) BFS로 정보 세팅 
		BFS(1);
		
		//질의 개수 구하기 
		int M = kb.nextInt();
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//a,b의 LCA구하기 
			int LCA = getLCA(a, b);
			System.out.println(LCA);
		}
	}
}