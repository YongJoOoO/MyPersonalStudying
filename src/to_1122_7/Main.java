package to_1122_7;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 7044번. 나쁜 소트랙터들 = 최소 스패닝 트리 문풀 
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
		return o.val - this.val;//내림차순 정렬 되도록 
	}
}
public class Main {
	static int N, M;
	static int[] parent;
	static PriorityQueue<Edge> pQ;
	
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
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;//자기 자신으로 초기화
		
		pQ = new PriorityQueue<>();
		
		for(int i =0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			pQ.offer(new Edge(a, b, val));
		}
		
		int useEdge = 0;
		int useCost = 0;
		
		boolean flag = false;
		while(useEdge != N-1) {
			Edge cur = pQ.poll();
			if(cur == null) {
				flag = true;
				break;
			}
			
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				useCost += cur.val;
				useEdge++;
			}
		}
		
		if(flag == true) {
			System.out.println(-1);
		}else {
			System.out.println(useCost);
		}	
	}
}