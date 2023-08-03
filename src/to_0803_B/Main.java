package to_0803_B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//다익스트라 - 최단경로 1753번. 복습 - 노드 중심 인접 리스트 표현 
//cf. 엣지 리스트는 벨만포드와 최소스패닝트리 뿐이다. 

class Node implements Comparable<Node>{
	int v;
	int val;
	Node(int v, int val){
		this.v = v;
		this.val =val;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.val - o.val; //가중치 적은 거 우선 
	}
}
public class Main {
	static int[] distance;//거리 배열 
	static ArrayList<ArrayList<Node>> graph;
	static boolean[] visited;//방문체크용 배열 
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int V = kb.nextInt();//정점
		int E = kb.nextInt();//간선
		
		int K = kb.nextInt();//시작점
		
		//초기화
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE); //해놔야 반드시 !!!!!!!!!!!!!!! 최단경로로 갱신이 됨
		graph = new ArrayList<>();
		
		visited = new boolean[V+1];
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력받기 
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int v = kb.nextInt();
			graph.get(a).add(new Node(b, v));
		}
		
		//시작점 처리 
		PriorityQueue<Node > pQ = new PriorityQueue<>();
		distance[K] = 0;//자기 자신
		pQ.add(new Node(K, 0));//자기 자신에 대한 거리는 0
		
		while(!pQ.isEmpty()) {
			Node cur = pQ.poll();//하나 뽑고 
			int cur_v = cur.v;
			int cur_val =cur.val;
			if(!visited[cur_v]) {
				visited[cur_v] = true;//방문처리 
				
				for(Node nx : graph.get(cur_v)) {
					//인접정점 순회하면서 
					int nx_v = nx.v;
					int nx_val = nx.val;
					if(!visited[nx_v] && distance[nx_v] > distance[cur_v] + nx_val) {
						distance[nx_v] = distance[cur_v] + nx_val;
						pQ.add(new Node(nx_v, distance[nx_v]));
					}
				}
			}
		}
		//경로 안존재하면 -1 출력하고, 	
		for(int i=1; i<=V; i++) {
			if(!visited[i]) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}
}