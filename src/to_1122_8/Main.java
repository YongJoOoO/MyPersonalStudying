package to_1122_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 백준 15835번. Explorace - 최소 스패닝 트리
 * @author MYLG
 *
 */
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
		return this.val - o.val;
	}
}
public class Main {
	static int TC;
	static int N, M;
	static int[] parent;
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
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
		
		TC = kb.nextInt();
		
		for(int t= 0; t<TC; t++) {
			N = kb.nextInt();
			M = kb.nextInt();
			
			List<Edge> edges = new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				int val = kb.nextInt();
				
				edges.add(new Edge(a, b, val));
			}
			Collections.sort(edges);
			parent = new int[N+1];
			for(int i=1; i<=N; i++) parent[i] = i;
			
			int useEdge = 0;
			int useCost = 0;
			
            for(Edge edge : edges){
                if(useEdge == N - 1) break;
                
                if(find(edge.s) != find(edge.e)){
                    union(edge.s, edge.e);
                    useCost += edge.val;
                    useEdge++;
                }
            }
			System.out.println("사례 #"+ (t+1) +": "+ useCost + "미터");
		}
	}
}