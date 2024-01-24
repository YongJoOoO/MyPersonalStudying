package to_24_0124_2;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 백준 1647번. 도시 분할 계획 - MST (크루스칼) 문풀 
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
	static int N, M;
	static int[] parent;
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		parent = new int[N+1];
		
		for(int i=1; i<=N; i++) parent[i]= i;
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			pQ.offer(new Edge(a, b, val));
		}
		
		int useEdge = 0;
		int useCost = 0;
		
		int maxCost = 0;
		
		while(useEdge<N-1) {
			Edge cur = pQ.poll();
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				useCost += cur.val;
				System.out.println(cur.s + " "+ cur.e + " " + cur.val);
				maxCost = cur.val;//가장 마지막에 연결될 값이 가장 큼
				useEdge++;
			}
		}
		System.out.println(useCost - maxCost);
	}
}