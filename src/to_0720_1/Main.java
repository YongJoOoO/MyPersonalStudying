package to_0720_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//다익스트라 
class Node implements Comparable<Node>{
	int v; //다음 정점
	int val;//가중치
	Node(int v, int val){
		this.v = v;
		this.val =val;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//가중치 오름차순 (즉, 작은 값 우선) 다익스트라는 계속 가장 작은 값 선택함 
	}
}
public class Main {
	static int V, E,K;
	static int[] distance;
	static ArrayList<ArrayList<Node>> graph;
	static boolean visited[];
	//다익스트라 
	static void Dijkstra(int K) { //출발 노드 받기 
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		//시작점 설정 
		distance[K] = 0;
		pQ.add(new Node(K, 0)); //K에대한 거리는 0
		
		while(!pQ.isEmpty()) {
			Node cur = pQ.poll();
			int c_v = cur.v;
			int c_val = cur.val;
			if(visited[c_v]) continue;//이미 방문한 정점인 경우 큐에 다시 넣지 않음 
			//방문 처리 
			visited[c_v] = true;
			//해당 정점의 인접 정점에 대하여 
			for(Node nx : graph.get(c_v)) {
				int n_v = nx.v;
				int n_val = nx.val;
				if(distance[n_v] > distance[c_v]+n_val) {
					distance[n_v] = distance[c_v] + n_val;
					pQ.add(new Node(n_v, distance[n_v]));
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		V = kb.nextInt();
		E = kb.nextInt();
		K = kb.nextInt();
		//초기화
		distance= new int[V+1];
		visited = new boolean[V+1];
		
		//거리 배열 무한대 초기화
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		//입력 데이터 얻기 
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int w = kb.nextInt();
			graph.get(a).add(new Node(b, w));
		}
		
		Dijkstra(K);//출발점 K에 대하여 
		
		//방문한 적 있는 애만 출력 아니면 INF 출력 
		for(int i=1; i<=V; i++) {
			if(visited[i]) {
				System.out.println(distance[i]);
			}else {
				System.out.println("INF");
			}
		}
	}

}
