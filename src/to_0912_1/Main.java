package to_0912_1;

import java.util.ArrayList;
import java.util.Scanner;

/*1967번. 트리의 지름 - DFS*/
//루트노드 1기준으로 가장 먼 노드 찾기 
//가장 먼 노드로부터 다시 가장 먼 노드 찾기 
class Node{
	int e, val;
	Node(int e, int val){
		this.e= e;
		this.val =val;
	}
}
public class Main {
	static int N;
	static int max;
	static int answer;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph;
	//DFS
	static void DFS(int x, int cost) {//방문 정점, 누적 비용 
		visited[x] = true;
		
		for(Node nx : graph.get(x)) {
			if(!visited[nx.e] && nx!=null) {
				DFS(nx.e, cost+=nx.val);//누적시켜서 가기 
			}
		}
		
		max = Math.max(max, cost);
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		
		for(int i=0; i<N-1; i++) {
			// N-1개이 간선 정보 입력됨 
			
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			//양방향 간선 
			graph.get(a).add(new Node(b, val));
			graph.get(b).add(new Node(a, val));
		}
		max = 0;
		//1) 1부터 가장 먼 노드 찾기 
		DFS(1, 0);//루트노드에서 시작
		
	
		//2) 가장 먼 노드에서 가장 먼 노드 찾기 
		DFS(max, 0);
		
		System.out.println(max);
	}

}
