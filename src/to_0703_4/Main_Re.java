package to_0703_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*최단 경로 다시 풀이 */
class Node implements Comparable<Node>{
	int v;
	int val;
	Node(int v, int val){
		this.v = v;
		this.val = val;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}

public class Main_Re {
	//방문체크용
	static boolean visited[];
	//최단거리용
	static int[] distance;
	//그래프표현용
	static ArrayList<ArrayList<Node>> graph;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int V = kb.nextInt();
		int E = kb.nextInt();
		int S = kb.nextInt();
		//초기화
		graph = new ArrayList<>();
		for(int i = 0; i<=V; i++) {
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
		//pQ 기본 오르마순 정렬 
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		distance[S] = 0;//0으로 세팅
		pQ.add(new Node(S, 0));
		
		while(!pQ.isEmpty()) {
			//현재 정점
			Node cur = pQ.poll();
			int c_v = cur.v;
			int c_val = cur.val;
			if(!visited[c_v]) {
				visited[c_v] = true;
				for(Node nx : graph.get(c_v)) {
					int nx_v = nx.v;
					int nx_val = nx.val;
					if(!visited[nx_v] && distance[nx_v]> distance[c_v]+nx_val) {
						distance[nx_v] = distance[c_v]+nx_val;
						pQ.add(new Node(nx_v, distance[nx_v]));
					}
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(visited[i]) System.out.println(distance[i]);
			else System.out.println("INF");
		}	
	}
}