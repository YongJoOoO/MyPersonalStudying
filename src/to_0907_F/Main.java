package to_0907_F;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*13905번. 세부 - 최소신장트리*/
class Edge implements Comparable<Edge>{
	int e, val;
	Edge( int e, int val){
		this.e=e;
		this.val= val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return o.val - this.val;
	}
}
public class Main {
	static int N, M, S, E;
	static int[] parent;
	
	//find
	static int find(int a) {
		if(a==parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
		}
	}
	
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		S = kb.nextInt();
		E = kb.nextInt();
		
		parent= new int[N+1];
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			//양방향 
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}
		
		boolean[] visited = new boolean[N+1];//방문체트용 
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(S, 0));
		int answer = Integer.MAX_VALUE;
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			System.out.print(cur.e + " ");
			
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			for(Edge nx : graph.get(cur.e)) {
				if(!visited[nx.e]) {
					answer = Math.min(answer, nx.val);
				}
			}	
		}
		//System.out.println(answer);
		
	}

}
