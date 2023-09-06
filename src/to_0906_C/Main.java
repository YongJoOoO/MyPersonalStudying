package to_0906_C;

import java.util.PriorityQueue;
import java.util.Scanner;

/*16398번. 행성 연결- 최소비용신장트리 문풀 */
class Edge implements Comparable<Edge> {
	int s, e, val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e =e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int N;
	static int[][] map;
	static int[] parent;
	//find
	static int find(int a ) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
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
		N = kb.nextInt();
		//행렬에 입력 받을 건데 
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i]= i;//자기 자신으로 세팅 
		
		//얘네들 중 i>j 인 값에 대하여서만 간선으로 담기 
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = kb.nextInt();
				if(i<j) pQ.offer(new Edge(i, j, map[i][j]));
			}
		}
		//최소비용 신장트리 시작 
		int useEdge= 0;
		//##############주의 데이터 크기 크니까 답은 long타입으로 선언해서 써야 한다. !!!!!
		long useCost = 0; // 100,000,000 이므로 long형
		while(useEdge<N-1) {
			Edge cur = pQ.poll();
			//사이클 형성하지 않는 애만 이어붙임 
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				useCost += cur.val;
				useEdge++;
			}
		}
		System.out.println(useCost);
	}
}