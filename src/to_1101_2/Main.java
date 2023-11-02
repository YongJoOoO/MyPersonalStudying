package to_1101_2;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 3803번. Networking - 최소비용 신장트리 문풀 
 * @author MYLG
 *
 */
class Edge implements Comparable<Edge>{
	int s, e, val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e= e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int P, R;
	static int[] parent;
	static PriorityQueue<Edge> pQ;
	
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	//union
	static void union(int a, int b) {
		a= find(a);
		b = find(b);
		if(a != b) {
			parent[b] =a;
		}
	}
	
	//mst
	static int MST(PriorityQueue<Edge> pQ) {
		int useEdge = 0;
		int useCost = 0;
		while(useEdge<P-1) {
			Edge cur = pQ.poll();
			
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				useCost += cur.val;
				useEdge ++;
			}
		}
		return useCost;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			P = kb.nextInt();
			if(P == 0) break;
			R = kb.nextInt();
			
			parent = new int[P+1];
			for(int i=1; i<=P; i++) parent[i] =i;
			
			pQ = new PriorityQueue<>();
				
			for(int i=0; i<R; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				int c = kb.nextInt();
				pQ.offer(new Edge(a, b, c));
			}
			//결과 출력
			System.out.println(MST(pQ));
		}
	}
}