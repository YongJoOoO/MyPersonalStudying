package to_0706_9;

import java.util.PriorityQueue;
import java.util.Scanner;

/*백준 - 최소 신장 트리 */
class Edge implements Comparable<Edge>{
	int s;
	int e;
	int val;
	Edge(int s, int e , int val){
		this.s = s;
		this.e = e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//가중치 오름차순 정렬
	}
}

public class Main {
	static int v, e;
	static int[] parent;
	
	//find
	static int find(int a) {
		if(a==parent[a]) return a;
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
		v= kb.nextInt();
		e = kb.nextInt();
		
		parent= new int[v+1];
		
		for(int i=1; i<=v; i++) {
			parent[i] = i; //자기 자신으로 초기화 
		}
		
		//자동 우선순위 튜
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		//데이터 입력받기
		for(int i=0; i<e; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			pQ.add(new Edge(a, b, val));
		}
		//최소신장트리
		int EdgeUseNum=0;
		int answer = 0;
		while(EdgeUseNum < v-1) {
			Edge cur = pQ.poll();
			if(find(cur.s) != find(cur.e)) { //사이클 안생기게
				union(cur.s, cur.e);
				answer += cur.val;//가중치 누적합
				EdgeUseNum++;
			}
		}
		System.out.println(answer);
	}
}