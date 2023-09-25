package to_0925_4;

import java.util.*;
import java.util.Scanner;

/*13905번. 세부 - 최소 스패닝 트리 문풀 */
class Edge implements Comparable<Edge>{
	int s, e , val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e = e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return o.val - this.val;//가중치큰 순 내림차순 정렬 
	}
}
public class Main {
	static int N, M;
	static int S, E;
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
		if(a != b) {
			parent[b] = a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		S = kb.nextInt();
		E = kb.nextInt();
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i]= i;
	
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			//도로 개수만틈 입력받기 
			//양방향 간선임 
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			pQ.add(new Edge(a, b, val));
		}
		int useEdge = 0;
		int useCost = 0;
		
        while (!pQ.isEmpty()) {
        	//내림차순 가중치 높은 순으로 차례대로 연결하다가 
            Edge edge = pQ.poll();
            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                //문제에서 주어진 시작점 S와 E의 부모가 같다 = 둘 사이의 경로가 존재 : 이어졌다는 것 
                if(find(S) == find(E)){
                	//어차피 가중치 큰 순으로 하나씩 뽑아 이었기 때문에 
                    useCost = edge.val;//이때의 값이 최대임 
                    break;//탈출 
                }
            }
        }
 
		
		System.out.println(useCost);
	}

}