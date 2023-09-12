package to_0912_4;

import java.util.PriorityQueue;
import java.util.Scanner;

class Point {
	int num;//자기 번호 
	int x, y;
	Point(int num, int x, int y){
		this.num= num;
		this.x = x;
		this.y = y;
	}
}
class Edge implements Comparable<Edge>{
	int s;
	int e;
	double val;//가중치는 double형
	
	Edge(int s, int e, double val2){
		this.s = s;
		this.e = e;
		this.val = val2;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if(this.val < o.val) { 
			return -1;
		}
		return 1;
	}
}
public class Main {
	static int N, M; 
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
	
	//실행ㅁ ㅔ인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt(); //이미 연결된 상간선 개수이고,
		parent= new int[N+1];
		for(int i=1; i<=N; i++) parent[i] = i;
		
		Point[] points = new Point[N+1];
		
		for(int i=1; i<=N; i++) {//각 정점별 x,y 좌표 받기 
			int x = kb.nextInt();
			int y = kb.nextInt();
			points[i]= new Point(i, x, y);
		}
		
		for(int i=0; i<M; i++) {
			//입력받은 두 정점을 이어야 함 
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			//union 처리
			union(a, b);//일단 담아둠 
		}
		//나머지 가능한 가중치들을 pQ에 담을 거임
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				Point a = points[i];
				Point b = points[j];
				double val = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y-b.y, 2));
				
				pQ.offer(new Edge(points[i].num, points[j].num, val));
			}
		}
		double useCost = 0;
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				useCost+=cur.val;
			}
		}
		
		System.out.println(String.format("%.2f", useCost));
	}
}