package to_1002_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/*백준 23286번. 허들 넘기 - 다익스트라 문풀 */
class Edge implements Comparable<Edge> {
	int e, val;
	Edge(int e, int val){
		this.e =e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int N, M, T;
	static int[] parent;
	static ArrayList<ArrayList<Edge>> graph;
	
	//dijkstra()
	static int dijkstra(int st, int ed) {
		
		int answer = Integer.MAX_VALUE;
		parent = new int[N+1];
		
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		//시작점 초기화
		distance[st]= 0;
		pQ.offer(new Edge(st, 0));
		parent[st] = 0;
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			
			int max = Integer.MIN_VALUE;
			for(Edge nx : graph.get(cur.e)) {	
				if(distance[nx.e] > distance[cur.e] + nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
					
					parent[nx.e] = cur.e;//직전 방문 정점 담기 
				}
			}
		}
		
		if(distance[ed] ==Integer.MAX_VALUE) {
			//return -1;
		}
		
		Stack<Integer> stack = new Stack<>();
		int cur = ed;
		stack.push(cur);
		
		while(parent[cur] != 0) {//출발점 나오기 전까지 
			cur = parent[cur];
			stack.push(cur);
		}
		
		while(!stack.isEmpty()) {
			
		}
		
		return distance[ed];
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
			
		N = kb.nextInt();
		M = kb.nextInt();
		T = kb.nextInt();
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int val = kb.nextInt();
			//단방향 그래프 
			graph.get(a).add(new Edge(b, val));
		}
		ArrayList<Integer> arr =new ArrayList<>();
	
		//T개의 s, e 입력받기 
		for(int i=0; i<T; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
		
			int ans = dijkstra(s, e);
			
			arr.add(ans);
		}
		
		
		
	}

}
