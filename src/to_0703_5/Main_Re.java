package to_0703_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 최소비용 다시RE
 * */
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
	static int distance[];
	static boolean visited[];
	static ArrayList<ArrayList<Node>> graph;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int V = kb.nextInt();
		int E = kb.nextInt();
		//초기화
		visited = new boolean[V+1];
		distance = new int[V+1];
		graph = new ArrayList<>();
		
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<Node>());
		}
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int w = kb.nextInt();
			graph.get(a).add(new Node(b, w));
		}
		
		int st = kb.nextInt();
		int ed = kb.nextInt();
		
		//시작점 세팅
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		distance[st] = 0;
		pQ.add(new Node(st, 0));
		
		while(!pQ.isEmpty()) {
			//현재
			Node cur = pQ.poll();
			int c_v = cur.v;
			int c_val = cur.val;
			if(!visited[c_v]) {
				visited[c_v] = true;
				for(Node nx : graph.get(c_v)) {
					int nx_v = nx.v;
					int nx_val = nx.val;
					if(!visited[nx_v] && distance[nx_v]> distance[c_v] + nx_val) {
						distance[nx_v] = distance[c_v]+nx_val;
						pQ.add(new Node(nx_v, distance[nx_v]));
					}
				}
			}
		}
		
		//끝 지점까지의 최단거리
		System.out.println(distance[ed]);
	}
}