package to_0720_4;

import java.util.PriorityQueue;
import java.util.Scanner;

///최소 스패닝 트리 
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
		return this.val - o.val;//가중치 적은 애 우선 
	}
}
public class Main {
	static int V, E;
	static int[] parent;//유니온 파인드
	static PriorityQueue<Edge> pQ = new PriorityQueue<>();
	//find
	static int find(int a ) {
		if(a == parent[a]) return a;
		else {
			return parent[a] = find(parent[a]);
		}
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
		V = kb.nextInt();
		E = kb.nextInt();
		parent = new int[V+1];
		for(int i=1; i<=V; i++) parent[i] =i;//자기 자신을 세팅 
		
		for(int i=0; i<E; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			int val = kb.nextInt();
			pQ.add(new Edge(s, e, val));
		}
		
		//입력 끝났으니까 이제 최소비용 신장 트리 
		int useEdge =0;//얘까 노드-1 개수만큼마 ㄴ되도록 
		int result = 0;//가중치 합 
		
		while(useEdge < V-1) {
			//가장 작은 애 하나 뽑고
			Edge cur = pQ.poll();
			if(find(cur.s) != find(cur.e)) { //두 정점 부모 같지 않다면 사연결해도 사이클 안생김 
				result += cur.val;
				union(cur.s, cur.e);
				useEdge++;	
			}
		}
			//연결한 최소 가중치 출력 
		System.out.println(result);
	}

}
