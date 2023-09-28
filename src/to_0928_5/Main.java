package to_0928_5;

import java.util.*;
import java.util.Scanner;

/*백준 14950번. 정복자 - 최소비용 신장트리 문풀 */

class Edge implements Comparable<Edge> {
	int s, e, val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e =e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val- o.val;
	}
}
public class Main {
	static int N, M, T;
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
		if(a!=b) {
			parent[b]= a;
		}
	}
	
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		T = kb.nextInt();
		
		parent= new int[N+1];//N+1개
		for(int i=1; i<=N; i++) parent[i]=i;

		
		PriorityQueue<Edge > pQ = new PriorityQueue<>();
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a= kb.nextInt();
			int b = kb.nextInt();
			int v = kb.nextInt();
			pQ.offer(new Edge(a, b, v));
		}
		
		//MST 
		int useEdge = 0;
		int useCost = 0;
		
		while(useEdge <N-1) {
			Edge cur = pQ.poll();
			
			if(find(cur.s ) != find(cur.e)) {
				union(cur.s, cur.e);
				useCost += (useEdge * T) + cur.val;
				useEdge++;
			}
		}
		System.out.println(useCost);		
	}
}