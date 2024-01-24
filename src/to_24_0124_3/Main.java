package to_24_0124_3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 2887번. 행성 터널 - MST 문풀 
 * @author MYLG
 *
 */
class Planet {
	int x, y, z;
	Planet(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
class Edge implements Comparable<Edge>{
	int s, e, val;
	Edge(int s, int e, int val){
		this.s= s;
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
	static int[] parent;
	//find
	static int find(int a) {
		if(a==parent[a]) return a;
		return parent[a] =find(parent[a]);
	}
	
	//union
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
		int N = kb.nextInt();
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] =i;
		
		List<Planet> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int x= kb.nextInt();
			int y = kb.nextInt();
			int z =kb.nextInt();
			list.add(new Planet(x, y, z));
		}
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			Planet cur = list.get(i);
			
			for(int j=i+1; j<N; j++) {
				Planet p = list.get(j);
				
				int min = Math.min(Math.abs(cur.x-p.x), Math.min(Math.abs(cur.y-p.y), Math.abs(cur.z-p.z)));
				pQ.offer(new Edge(i+1, j+1, min));
			}
		}
		int useEdge = 0;
		int useCost = 0;
		while(useEdge < N-1) {
			Edge cur = pQ.poll();
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				useCost += cur.val;
				useEdge++;
			}
		}
		System.out.println(useCost);
	}
}