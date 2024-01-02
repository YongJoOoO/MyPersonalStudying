package to_24_0102_1;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1368번. 물대기 - MST
 * @author MYLG
 *
 */
class Edge implements Comparable<Edge>{
	int st, ed, val;
	
	Edge(int st, int ed, int val){
		this.st = st;
		this.ed =ed;
		this.val=val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//가중치 오름차순 정렬
	}
}
public class Main {
	static int N;
	static int[] w;
	static int[] parent;
	
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parent[b]= a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N= kb.nextInt();
		w = new int[N+1];
		
		//자기 자신으로 초기화 
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;
		
		for(int i=1; i<=N; i++) w[i] = kb.nextInt();
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		//간선 채우기 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int p = kb.nextInt();//연결 비용 
				if(i == j) {
					//자기 자신에 대해서는 직접 우물 파는 비용 담기 - 가상 노드 0에 잇기
					pQ.offer(new Edge(i, 0, w[i]));
				}else {
					pQ.offer(new Edge(i, j, p));
				}
			}
		}
		
		//크루스칼
		int useCost = 0;
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(find(cur.st) == find(cur.ed)) continue;
			
			union(cur.st, cur.ed);
			useCost+=cur.val;
		}
		
		System.out.println(useCost);
	}
}