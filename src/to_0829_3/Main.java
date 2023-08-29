package to_0829_3;

import java.util.ArrayList;
import java.util.Scanner;

/*18126번. 너구리 구구 문풀 -long 타입으로 답 풀어야 한다. */
class Node {
	int v;
	long val;
	Node(int v, long val){
		this.v = v;
		this.val =val;
	}
}
public class Main {
	static int N;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph;
	static long[] length; //여기에 각 1부터 정점까지의 거리 담기 S
	//DFS
	static void DFS(int v, long len) {
		visited[v] = true;
		
		for(Node nx : graph.get(v)) {
			int nx_v = nx.v;
			long nx_val = nx.val;
			//v의 인접 정점에 대하여 
			if(!visited[nx_v]) {
				length[nx_v] = len + nx_val;
				DFS(nx_v, length[nx_v]);
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		visited = new boolean[N+1];
		length = new long[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력받기 
		for(int i=0; i<N-1; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			
			//양방향이므로 
			graph.get(a).add(new Node(b, val));
			graph.get(b).add(new Node(a, val));
		}
		
		DFS(1, 0);
		
		long max=0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, length[i]);
		}
		System.out.println(max);
	}
}