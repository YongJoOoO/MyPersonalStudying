package to_0803_F;

import java.util.PriorityQueue;
import java.util.Scanner;

//최소비용 신장 트리 RE 
class Edge implements Comparable<Edge>{
	int s, e, v;
	Edge(int s, int e, int v){
		this.s = s;
		this.e = e;
		this.v = v;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.v - o.v;
	}
}
public class Main {
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
			parent[b]=a;
		}
	}
	//실행메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int v = kb.nextInt();
		int E = kb.nextInt();
		//초기화
		parent = new int[v+1];
		for(int i=1; i<=v; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			pQ.add(new Edge(a, b, c));
		}
		
		int useEdge =0;
		int answer = 0;
		
		while(useEdge < v-1) {
			Edge cur = pQ.poll();//현재 엣지 뽑고 
			if(find(cur.s) != find(cur.e)) {//사이클 일어나지 않을 경우 
				union(cur.s, cur.e);//둘이 합침
				answer += cur.v;//최소 비용 가중치 합 ++처리 
				useEdge++;
			}
		}		
		System.out.println(answer);	
	}
}