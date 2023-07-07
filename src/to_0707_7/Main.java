package to_0707_7;

import java.util.PriorityQueue;
import java.util.Scanner;

/*1647번. 도시 분할 계획 : 최소비용 신장 트리  */
class Edge implements Comparable<Edge>{
	int s;
	int e;
	int val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e = e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//최소비용 오르맛누 
	}
}
public class Main {
	static int N, M;
	static int[] parent;
	static PriorityQueue<Edge> pQ;
	//find
	static int find(int a) {
		if(a==parent[a]) return a;
		else {
			return parent[a] = find(parent[a]);
		}
	}
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
		}
	}
	
	//실행 메인 ㄴ
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		pQ = new PriorityQueue<Edge>();
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] =i ;
		}
		
		//데이터 입력 저장 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int w = kb.nextInt();
			pQ.add(new Edge(a, b, w));
		}		
		//최소비용 시작 
		int useEdge =0 ;
		int minVal=0;//최소비용 누적하기
		int max = Integer.MIN_VALUE;
		while(useEdge < N-1) { 
			Edge cur = pQ.poll(); 
			if(find(cur.s) != find(cur.e)) { 
				union(cur.s, cur.e);
				if(max < cur.val) {
					max = cur.val;
				}
				minVal += cur.val; 
				useEdge++; 
			} 
		} 
		System.out.println(useEdge-max);
	}
}