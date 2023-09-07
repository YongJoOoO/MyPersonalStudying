package to_0906_D;

import java.util.PriorityQueue;
import java.util.Scanner;

/*백준 21924번. 도시 건설- 최소 비용 신장 트리 */
class Edge implements Comparable<Edge>{
	int s, e, val;
	Edge(int s, int e, int val){
		this.s =s;
		this.e=e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int[] parent;
	static int N, M;
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
		M = kb.nextInt();
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		long total = 0;//전체 비용 합계
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			pQ.offer(new Edge(a, b, c));
			total += c;
		}
		boolean flag = false;
		//최소신장트리 로직 시작 
		int useEdge = 0;
		// 여기 데이터 크기가 다 개 크니까 long 타입으로 선언할 것 !!!!!!!!!!!!
		long useCost = 0;
		while(useEdge < N-1) {
			Edge cur = pQ.poll();
			//그런데 만약 N-1되기 전에 다음 정점이 존재하지 않는다면
			if(cur==null && useEdge < N-1) {
				flag = true;
				break;//탈출
			}
			
			if(find(cur.s) != find(cur.e)) { //사이클 형성 하지 않도록 
				union(cur.s, cur.e);
				useCost += cur.val;
				useEdge++;
			}
		}
		
		if(flag == true) System.out.println("-1");
		else System.out.println(total - useCost);
	}
}