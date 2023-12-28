package to_1228_2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 2887번. 행성 터널 - 최소비용신장트리 문풀 -> 정리하기 
 * @author MYLG
 *
 */
class Planet{
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
	int st, ed, val;
	Edge(int st, int ed, int val){
		this.st = st;
		this.ed = ed;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//가중치 적은 거 우선임
	}
}
public class Main {
	static int N;
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
		if(a!=b) {
			parent[b] = a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;//자기 자신으로 우선 초기화
		
		Planet[] pList = new Planet[N];
		for(int i=0; i<N; i++) {
			int x = kb.nextInt();
			int y = kb.nextInt();
			int z = kb.nextInt();
			pList[i] = new Planet(i, x, y, z);
		}
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		//x좌표 기준으로 정렬 
		Arrays.sort(pList, (p1, p2) -> Integer.compare(p1.x, p2.x));
		for(int i=1; i<N; i++) {
			int val = Math.abs(pList[i].x - pList[i-1].x);
			pQ.offer(new Edge(pList[i].num, pList[i-1].num, val));
		}
		
		//y좌표 기준으로 정렬 
		Arrays.sort(pList, (p1, p2) -> Integer.compare(p1.y, p2.y));
		for(int i=1; i<N; i++) {
			int val = Math.abs(pList[i].y - pList[i-1].y);
			pQ.offer(new Edge(pList[i].num, pList[i-1].num, val));
		}
		//z좌표 기준으로 정렬 
		Arrays.sort(pList, (p1, p2) -> Integer.compare(p1.z, p2.z));
		for(int i=1; i<N; i++) {
			int val = Math.abs(pList[i].z - pList[i-1].z);
			pQ.offer(new Edge(pList[i].num, pList[i-1].num, val));
		}
		
		int useEdge = 0, useCost=0;
		//mst
		while(useEdge != N-1) { //간선 N-1개 연결함
			Edge cur = pQ.poll();
			if(find(cur.st) != find(cur.ed)) {
				union(cur.st , cur.ed);
				useCost += cur.val;//가중치 합
				useEdge++;//간선 ++ 처리
			}
		}
		
		System.out.println(useCost);//최소비용	
	}
}