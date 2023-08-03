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
		
		distance[S] = 0;
		pQ.add(new Node(S, 0));
		
		while(!pQ.isEmpty())	{
			Node cur = pQ.poll();
			int c_v = cur.v;
			int c_val = cur.val;
			if(!visited[c_v]) {
				visited[c_v] = true;
				for(Node nx : graph.get(c_v)) {
					int nx_v = nx.v;
					int nx_val = nx.val;
					if(!visited[nx_v] && distance[nx_v]> distance[c_v]+ nx_val){
						distance[nx_v]  = distance[c_v] + nx_val;
						pQ.add(new Node(nx_v, distance[nx_v]));
					}
				}

			}
		}

	}
}