package to_0906_A;

import java.util.PriorityQueue;
import java.util.Scanner;

/*1197번. 최소 스패닝 트리 - 최소비용 신장 트리 
 * */

class Edge implements Comparable<Edge>{
	int a, b, val;
	Edge(int a, int b, int val){
		this.a = a;
		this.b =b;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//적은 가중치 우선으로 함 
	}
}
public class Main {
	static int V, E;
	static int[] parent;//부모노드 
	static PriorityQueue<Edge> pQ = new PriorityQueue<>();
	//find
	static int find(int a) {
		if(a==parent[a]) return a;
		else return parent[a] = find(parent[a]);
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
		Scanner kb= new Scanner(System.in);
		V = kb.nextInt();
		E = kb.nextInt();
		
		parent = new int[V+1];
		for(int i=1; i<=V; i++) parent[i] = i;//자기 자신으로 세팅해놓고 
		
		for(int i=0; i<E; i++) {
			int a= kb.nextInt();
			int b = kb.nextInt();
			int x = kb.nextInt();
			pQ.offer(new Edge(a, b, x));
		}
		
		int useEdge = 0;
		int result = 0;//가중치 합 출력할 거임 
		//간선 N-1개 만 사용 
		
		while(useEdge <V-1) {
			Edge cur = pQ.poll();
			//둘이 연결해도 사이클 안생길 경우 ! 둘을 연결한다. 
			if(find(cur.a) != find(cur.b)) { //둘이 다르면 
				union(cur.a, cur.b);//합치고 
				result += cur.val;//가중치 누적 
				useEdge++;
			}
		}
		System.out.println(result);
	}
}