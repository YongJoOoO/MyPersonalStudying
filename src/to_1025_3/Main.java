package to_1025_3;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 16947번. 서울 지하철 2호선 문풀 
 * @author MYLG
 *
 */
class Edge implements Comparable<Edge>{
	int s, e;
	Edge(int s, int e){
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.s - o.s;
	}
}
public class Main {
	static int N;
	static int[] arr;//지하철 개수 
	static int[] parent;
	static PriorityQueue<Edge> pQ;
	
	//find
	static int find(int a ) { //사이클 확인용 
		if(a==parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	//uinon
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b]= a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		arr = new int[N+1];
		parent= new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;
		
		pQ = new PriorityQueue<>();
		
		//입력
		for(int i=0; i<N; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			
			pQ.offer(new Edge(a, b));
			
			union(a, b);
		}
		boolean[] isCycle = new boolean[N+1];
		
		//판별
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(find(cur.s) == find(cur.e)) {
				//사이클 존재한 경우 
				isCycle[cur.s] = true;
				isCycle[cur.e] = true;
			}
		}
		
	}

}
