package to_24_0124_1;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1197번. 최소 스패닝 트리 - MST(크루스칼) 문풀
 * @author MYLG
 *
 */
class Edge implements Comparable<Edge>{
	int s, e, val;
	Edge(int s, int e, int val){
		this.s = s;
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
	static int V, E;
	static int[] parent;
	//find
	static int find(int a) {
		if( a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		V = kb.nextInt();
		E = kb.nextInt();
		//사이클 유무 판단용 
		parent = new int[V+1];
		for(int i=1; i<=V; i++) parent[i]= i;
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int v = kb.nextInt();
			pQ.offer(new Edge(a, b, v));
		}
		
		int useEdge = 0;
		int useCost = 0;
		
		while(useEdge < V-1) {
			Edge cur = pQ.poll();
			if(cur == null) break;
			//사이클 형성 안하도록 
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e); //합치고 
				useCost += cur.val;//가중치 ++ 
				useEdge++;//사용 간선 ++
			}
		}
		System.out.println(useCost);
	}
}