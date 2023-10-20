package to_1020_1;

import java.util.PriorityQueue;
import java.util.Scanner;

/*10423번. 전기가 부족해 = 최소비용 신장트리 문풀 */
class Edge implements Comparable<Edge>{
	int s, e, val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e = e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//오름차순 정렬 
	}
}
public class Main {
	static int N, M, K;
	static int[] parent;
	static boolean[] isElect;//전기 통하는지 여부
	
	//find
	static int find(int a) {
		if(a==parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			if(!isElect[a]) {
				parent[b] = a;
			}else if(!isElect[b]) {
				parent[a]= b;
			}else {
				if(!isElect[a] && !isElect[b]) {
					return;
				}else {
					parent[b] = a;
				}
			}
		}
	}
	
	//모든 애들 true된 경우 바로 탈출 
	static boolean isChk(boolean[] isElect) {
		for(int i=1; i<=N; i++) {
			if(!isElect[i]) {
				return false;//아직 연결안된 도시 존재 
			}
		}
		return true;//모두 연결된 상태
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
			
		N = kb.nextInt();
		M = kb.nextInt();
		K = kb.nextInt();
		
		parent = new int[N+1];
		isElect = new boolean[N+1];
		
		for(int i=0; i<K; i++) {
			int a = kb.nextInt();
			isElect[a] = true;//세 개의 전기 발전소 도시 처리 
		}
		
		for(int i=1; i<=N; i++) {
			parent[i]= i;
		}
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			pQ.offer(new Edge(a, b, val));
		}
		
		int useCost = 0;
		//자동 오름차순 정렬된 상태일텐데 
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(cur==null)break;
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				useCost += cur.val;
				isElect[cur.s] = true;
				isElect[cur.e] = true;
				
				//모든 도시 연결된 경우
				if(isChk(isElect)) {
					break;
				}
			}
		}
		System.out.println(useCost);
	}
}
