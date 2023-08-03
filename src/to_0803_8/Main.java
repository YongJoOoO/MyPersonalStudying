package to_0803_8;

import java.util.PriorityQueue;
import java.util.Scanner;

//최소비용 신장트리 - 백준 1197번. 최소 스패닝 트리 
class Edge implements Comparable<Edge>{
	int s, e, val;
	Edge(int s, int e, int val){
		this.s =s;
		this.e =e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val; //가중치 오름차순 정렬 
	}
}
public class Main {
	static int[] parent;//부모 확인 
	//find
	static int find(int a) {
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
		int V = kb.nextInt();//정점 개수 
		int E = kb.nextInt();//간선 개수 
		
		parent = new int[V+1];
		for(int i=1; i<=V; i++) {
			parent[i] = i;//초기화
		}

		PriorityQueue<Edge> pQ= new PriorityQueue<>();
				
		//데이터 입력받기 
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			pQ.add(new Edge(a, b, c));
		}
		
		//최소비용 신장트리 알고리즘 
		int useEdge = 0;
		int answer = 0;
		
		while(useEdge < V-1) {
			Edge cur = pQ.poll();//현재 엣지 뽑고 
			
			if(find(cur.s) != find(cur.e)) {//사이클 일어나지 않을 경우 
				union(cur.s, cur.e);//둘이 합침
				answer += cur.val;//최소 비용 가중치 합 ++처리 
				useEdge++;
			}
		}		
		System.out.println(answer);	
	}
}