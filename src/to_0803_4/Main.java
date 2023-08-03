package to_0803_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//다익스트라 - 최단경로 1753번. 
class Node implements Comparable<Node>{
	int v;//정점
	int val; //가중치 
	
	Node(int v, int val){
		this.v = v;
		this.val = val;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//가중치 적은 애 우선 
	}
}

public class Main {
	static int[] distance;//거리 배열 
	static boolean[] visited;//방문체크용 
	static ArrayList<ArrayList<Node>> graph; 
	
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int V= kb.nextInt();
		int E = kb.nextInt();
		int K = kb.nextInt();
		
		//초기화
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		visited = new boolean[V+1];
		graph = new ArrayList<>();
		
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		//데이터 입력받기
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int w = kb.nextInt();
			graph.get(a).add(new Node(b, w));//방향 그래프
		}
		
		
		//다익스트라 시작 
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		
		//1) 시작점 처리
		distance[K] = 0;
		pQ.add(new Node(K, 0));//자기 자신까지의 거리는 0으로 세팅
		
		//2) 현재 정점 poll시켜서 방문터리하고 nx 정점 찾아서 최단 경로 갱신 
		while(!pQ.isEmpty()) {
			Node cur = pQ.poll();
			int c_v = cur.v;
			int c_val = cur.val;
			if(!visited[c_v]) { //꺼낸 애가 아직 방문 전인 애면 
				visited[c_v] = true;//방문처리하고 
				
				for(Node nx : graph.get(c_v)) {//그 인접정점에 대하여 
					int nx_v = nx.v;
					int nx_val = nx.val;
					if(!visited[nx_v] && distance[nx_v] > distance[c_v] + nx_val) {
						distance[nx_v] = distance[c_v] + nx_val;
						pQ.add(new Node(nx_v, distance[nx_v]));
					}
				}
			}
		}
		//3) 출력할 정답 처리 
		for(int i=1; i<=V; i++) {
			if(distance[i] == Integer.MAX_VALUE || !visited[i]) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}
}