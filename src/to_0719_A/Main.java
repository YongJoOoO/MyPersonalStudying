package to_0719_A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//다익스트라 최단경로 구하기 
class Node implements Comparable<Node>{
	int v;
	int val;//가중치 
	Node(int v, int val){
		this.v= v;
		this.val = val;
	}
	@Override
	public int compareTo(Node o) {
		return this.val - o.val;//가중치 더 적은 거 기준 오름차순 정렬 
	}
}
public class Main {
	static int[] D;
	static int V, E, S;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph;
	static PriorityQueue<Node> pQ = new PriorityQueue<>();
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		V = kb.nextInt();
		E = kb.nextInt();
		S = kb.nextInt();
		
		D= new int[V+1];
		visited = new boolean[V+1];
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		//D배열은 Max값으로 채워두귀
		Arrays.fill(D, Integer.MAX_VALUE);
		
		//이제 입력 데이터 담기 
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			graph.get(a).add(new Node(b, val));
		}
		
		//시작점 세팅 
		pQ.add(new Node(S, 0));
		D[S] = 0;//시작점
		
		while(!pQ.isEmpty()) {
			Node cur = pQ.poll();
			int c_v = cur.v;
			int c_val= cur.val;
			if(visited[c_v]) continue;
			visited[c_v] = true;
			for(int i=0; i<graph.get(c_v).size(); i++) {
				Node tmp = graph.get(c_v).get(i);
				int nx_v = tmp.v;
				int nx_val =tmp.val;
				if(D[nx_v] > D[c_v]+nx_val) {
					D[nx_v] = D[c_v]+nx_val;
					pQ.add(new Node(nx_v, D[nx_v]));//담기 
				}
			}
		}		
		for(int i=1; i<=V; i++) {
			if(!visited[i]) {
				System.out.println("INF");
			}else {
				System.out.println(D[i]);
			}
		}	
	}
}