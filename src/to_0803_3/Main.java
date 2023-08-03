package to_0803_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//최단경로 : 플로이드 - 백준 1753번. 최단 경로 문풀 
class Node implements Comparable<Node>{
	int v;//노드
	int val;//가중치
	Node(int v, int val){
		this.v = v;
		this.val = val;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//가중치 오름차순  
	}
}

public class Main {
	static int V, E , S;
	static int[] distance;//거리
	static boolean[] visited;//방문체크
	static ArrayList<ArrayList<Node>> graph; 
	
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		V = kb.nextInt();
		E = kb.nextInt();
		S = kb.nextInt();
		
		//초기화
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		visited = new boolean[V+1];
		distance = new int[V+1];
		
		//distance 초기화
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int w= kb.nextInt();
			graph.get(a).add(new Node(b, w));
		}
		
		//시작점 초기화 
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		
		//시작 정점 처리하고 
		distance[S] = 0;
		pQ.add(new Node(S, 0));
		
		while(!pQ.isEmpty()){ // 큐 비지 않은 동안 반복 
			Node cur = pQ.poll(); //현재 정점 poll 시키고 
			int c_v = cur.v;
			int c_val = cur.val;
			if(!visited[c_v]) { //현재 정점이 방문 전인 애면 
				visited[c_v] = true;//방문처리 후 
				for(Node nx : graph.get(c_v)) { //해당 정점의 인접 정점들 순회하며 
					int nx_v = nx.v;
					int nx_val = nx.val;
					//만약 nx 정점이 방문 전이면서, 기존 nx 거리보다 현재 cv정점 거쳐가는 거리가 더 짧을 경우 
					if(!visited[nx_v] && distance[nx_v]> distance[c_v]+ nx_val){ 
						distance[nx_v]  = distance[c_v] + nx_val; //거리 갱신 
						pQ.add(new Node(nx_v, distance[nx_v]));//pQ에 갱신된 거리 함께 Node 삽입 
					}
				}

			}
		}

	}
}