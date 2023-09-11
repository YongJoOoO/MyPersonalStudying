package to_0911_9;

import java.util.PriorityQueue;
import java.util.Scanner;

/*4386번. 별자리 만들기 - 최소 비용 신장 트리 문풀*/
class Point {
	int num;
	double x;
	double y;
	
	Point(int num, double x, double y){
		this.num = num;
		this.x= x;
		this.y = y;
	}
}

class Edge implements Comparable<Edge>{
	int s, e;
	double val;
	
	Edge(int s, int e, double val){
		this.s = s;
		this.e = e;
		this.val = val;
	}
	public int compareTo(Edge o) {
		if(this.val < o.val) {
			return -1;
		}
		return 1;
	};
}
public class Main {
	static int N;
	static int[] parent;
	
	//find
	static int find(int a) {
		if(a == parent[a] ) return a;
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
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		//데이터 입력받을 때,
		Point[] points = new Point[N];
		for(int i=0; i<N; i++) {
			double x = kb.nextDouble();
			double y = kb.nextDouble();
			
			points[i] = new Point(i, x, y);//담기 
		}
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		//이중 for문 돌며넛 만들 수 있는 모든 간선 정보를 PQ에 담기 
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				//두 좌표 간 가중치 담아야 함 
				Point a = points[i];
				Point b = points[j];
				double val = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
				
				pQ.offer(new Edge(points[i].num, points[j].num, val));
			}
		}
		
		parent = new int[N];
		for(int i=0; i<N; i++) parent[i] = i;
		
		int useEdge = 0;
		double useCost = 0;
		
		while(useEdge< N-1) {
			Edge cur = pQ.poll();
			
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				useCost += cur.val;
				useEdge++;
			}
		}
		System.out.println(useCost);
	}

}