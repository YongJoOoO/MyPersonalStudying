package to_24_0124_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 2887번. 행성 터널 - MST 문풀 
 * @author MYLG
 *
 */
class Planet {
	int num;
	int x, y, z;
	Planet(int num, int x, int y, int z){
		this.num = num;
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
		
		List<Planet> pList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int x= kb.nextInt();
			int y = kb.nextInt();
			int z =kb.nextInt();
			pList.add(new Planet(i+1, x, y, z))	;
		}
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		Collections.sort(pList, (p1, p2) -> Integer.compare(p1.x, p2.x));
		for(int i=1; i<N; i++) {
			int val = Math.abs(pList.get(i).x - pList.get(i-1).x);
			pQ.offer(new Edge(pList.get(i).num, pList.get(i-1).num, val));
		}
		
		Collections.sort(pList, (p1, p2) -> Integer.compare(p1.y, p2.y));
		for(int i=1; i<N; i++) {
			int val = Math.abs(pList.get(i).y - pList.get(i-1).y);
			pQ.offer(new Edge(pList.get(i).num, pList.get(i-1).num, val));
		}
		
		Collections.sort(pList, (p1, p2) -> Integer.compare(p1.z, p2.z));
		for(int i=1; i<N; i++) {
			int val = Math.abs(pList.get(i).z - pList.get(i-1).z);
			pQ.offer(new Edge(pList.get(i).num, pList.get(i-1).num, val));
		}
		
		int useEdge= 0;
		int useCost = 0;
		
		while(useEdge < N-1) {
			Edge edge = pQ.poll();
			if(find(edge.s) != find(edge.e)) {
				union(edge.s, edge.e);
				useCost += edge.val;
				useEdge++;
			}
		}
		System.out.println(useCost);
	}
}