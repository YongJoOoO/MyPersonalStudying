package to_0928_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

/*백준 9694번. 무엇을 아느냐가 아니라 누구를 아느냐가 문제다 - 다익스트라 문풀 */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e = e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val; //최소비용 우선
	}
}
public class Main {
	static int TC;
	static int N, M;//N간선 M정점
	static int[] distance;//거리 배열 
	static boolean[] visited;//방문체크
	static int[] parent;//직전 정점 저장용 
	static ArrayList<ArrayList<Edge>> graph;
	
	//dijkstra
	static void dijkstra(){
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		ArrayList<Integer> answer = new ArrayList<>();
		visited = new boolean[M];
		parent = new int[M];
		distance= new int[M];//0~M-1 까지의 거리 
		Arrays.fill(distance, Integer.MAX_VALUE);
		//시작점 초기화 
		distance[0] = 0;//0이 항상 한신이거든 
		pQ.offer(new Edge(0, 0));//0->0 향하는 값은 0이다. 

		answer.add(0);//시작점 처리 
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			
			if(distance[cur.e] < cur.val) continue;
			
			if(cur.e == M-1) {
				break;//탈출 
			}
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) { //다음 정점에 대하여 
				if(distance[nx.e] > distance[cur.e] + nx.val) {
					
					distance[nx.e] = distance[cur.e] + nx.val;
					
					parent[nx.e] = cur.e;
					
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		TC = Integer.parseInt(st.nextToken());
		
		for(int t=0; t<TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for(int i=0; i<M; i++) {
				graph.add(new ArrayList<>());//공간은 M개 생성해두고 
			}
			
			//데이터 입력받기 
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				//간선 개수만큼 입력받되 
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				//양방향 간선 
				graph.get(a).add(new Edge(b, val));
				graph.get(b).add(new Edge(a, val));
			}
			
			//호출
			dijkstra();
			System.out.print("Case #"+(t+1)+ ": ");
			
			if(distance[M-1] == Integer.MAX_VALUE) {
				System.out.println(-1);
			}else {
				
				Stack<Integer> stack = new Stack<>();
				for(int i=(M-1); i>0; i--) {
					stack.push(i = parent[i]);
				}
				
				while(!stack.empty()) {
					System.out.print(stack.pop()+" ");
				}
				System.out.print(M-1 +" ");
				System.out.println();
			}
		}
	}
}