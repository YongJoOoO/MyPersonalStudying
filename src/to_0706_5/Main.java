package to_0706_5;

import java.util.PriorityQueue;
import java.util.Scanner;

/*1197번. 최소 스패닝 트리 - 최소비용신장트리 */
class Edge implements Comparable<Edge>{
	int s; 
	int e;
	int val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e = e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//가중치 값 기준 오름차순 정렬되도록 
	}
}

public class Main {
	static int V, E;
	static int[] parent;//유니온 파인드 위해 
	//find
	static int find(int v) {
		if(v == parent[v]) return v;
		else {
			return parent[v] = find(parent[v]);//계속 재귀로 부모==자기 자신 될 때까지 호출 
		}
	}
	
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!= b) {
			parent[b] = a;//부모를 a로 세팅 
		}
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		V = kb.nextInt();
		E = kb.nextInt();
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		parent = new int[V+1];
		//초기화
		for(int i=1; i<=V; i++) {
			parent[i] = i;//자기 자신으로 부모 초기화 
		}
		
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int v = kb.nextInt();
			pQ.add(new Edge(a, b, v));//자동 오름차순 정렬
		}
		//최소비용 신장 트리 알고리즘
		//오름차순 정렬된 가중치 순서대로 연결할 건데 만약 사이클 형성 하면 X
		int useEdgeNum = 0;
		int answer = 0;// 가중치 합 누적용 
		while(useEdgeNum < V-1) { //사용한 간선의 개수 N-1까지
			Edge cur = pQ.poll();//현재 가장 낮은 간선 뽑기
			if(find(cur.s) != find(cur.e)) { // 두 정점의 부모가 같지 않은 경우에만 (사이클X)
				union(cur.s, cur.e);//둘이 연결
				answer += cur.val;//연결한 비용 누적 
				useEdgeNum++;//간선 개수 ++
			}
		}	
		//정답 출력 
		System.out.println(answer);
	}
}