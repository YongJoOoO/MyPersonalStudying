package to_0831_7;

import java.util.*;
import java.util.Scanner;

/*18223번. 민준이와 마산 그리고 건우 - 다익스트라 문풀 
 * 아 건우한테가는 경로와 비교했을 때 같은 길이인지만 확인하면 되는 문제  */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e = e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}

public class Main {
	static int V, E, P;
	static int[] parent;//직전 정점 담는 용도 
	static int[] distance;// 거리 저장용 
	static boolean[] visited;//체크용 
	static ArrayList<ArrayList<Edge>> graph;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		V = kb.nextInt();
		E = kb.nextInt();
		P = kb.nextInt();
		
		parent= new int[V+1];//1번 부터니까 
		distance = new int[V+1];
		visited = new boolean[V+1];//초기화 안했었구나
		
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		Arrays.fill(distance, Integer.MAX_VALUE);//초기화 시켜놓고 
		
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int val = kb.nextInt();
			//양방향 
			graph.get(a).add(new Edge(b, val));
			graph.get(b).add(new Edge(a, val));
		}
		
		//다익스트라 시작 
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		distance[1]= 0;//시작점은 고정1 
		pQ.offer(new Edge(1, 0));
		parent[1] = 0;
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) {
				if(!visited[nx.e] && distance[nx.e] > distance[cur.e] + nx.val) {
					//부모도 저장해주기 
					parent[nx.e] = cur.e;//직전 정점 담기 
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
		
		//parent에 직전 정점은 담겨져 있고,
		Stack<Integer> stack = new Stack<>();
		//경로 역추적 로직 중요하다. 
		int cur = V;//1) 도착지점을 cur로 설정 
		stack.push(cur);//2) 우선 담아둔다 
		
		while(parent[cur] != 0) { //cur의 부모가 0이 아닌동안 반복하면서
			cur = parent[cur];//부모로 거슬러올라가고/
			stack.push(cur);//스택에 담는다.//->부모가 0되면 탈출 
		}
		
		boolean flag = false; //안존재 
		//경로 안에 P가 존재하면 
		while(!stack.isEmpty()) { //빈 상태 될 때까지 반복해야 경로가 나옴
			System.out.print(stack.pop()+ " ");
		}
	}
}