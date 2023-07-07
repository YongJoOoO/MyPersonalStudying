package to_0707_6;

import java.util.PriorityQueue;
import java.util.Scanner;

/*1922번. 네트워크 연결 | 최소비용 신장 트리 문제 */
class Edge implements Comparable<Edge>{
	int s;
	int e;
	int val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e= e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}

public class Main {
	static int N, M;//컴퓨터 수, 간선 수
	static int[] parent;
	static PriorityQueue<Edge> pQ = new PriorityQueue<>();
	
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
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
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb =new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		//초기화
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] =i;//자기 자신으로 초기화
		
		//자료 저장
		for(int i=0; i<M ; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int w = kb.nextInt();
			pQ.add(new Edge(a, b, w));
		}
		
		//최소비용 알고리즘
		int useEdge = 0;
		int minPrice=0;//최소비용 누적용 
		
		while(useEdge < N-1) { //모든 연결 못하는 경우는 없대니까 
			Edge cur = pQ.poll();
			if(find(cur.s) != find(cur.e)) {//사이클 형성 하지 않는 
				union(cur.s, cur.e);//결합 시키기 
				minPrice += cur.val;//비용 누적
				useEdge++;
			}
		}		
		System.out.println(minPrice);//최소비용 
	}
}