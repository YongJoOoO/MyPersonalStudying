package to_0906_B;

import java.util.*;

/*6497번. 전력난 - 최소 신장 트리 문풀  */
class Edge implements Comparable<Edge>{
	int s, e, val;
	Edge(int s, int e, int val) {
		this.s=  s;
		this.e= e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int[] parent;
	//find 
	static int find(int a) {
		if(a==parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b]= a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		while(true) {//만약에 0 0 입력될 경우 종료 할 거임 
			int m = kb.nextInt();
			int n = kb.nextInt();
			if(m == 0 && n == 0) break;
			
			parent = new int[m];
			for(int i=0; i<m; i++) parent[i] = i;
			
			int sum = 0;//전체 가중치 합을 담을 용도임 
			PriorityQueue<Edge > pQ = new PriorityQueue<>();
			//우선순위 큐에 입력될 애들 담을 거임 
			for(int i=0; i<n; i++) {//길이 n개다
				int a=  kb.nextInt();
				int b= kb.nextInt();
				int c = kb.nextInt();
				pQ.offer(new Edge(a, b, c));
				sum += c;//가중치 합 치기 
			}
			
			int useEdge = 0;//사용 간선 
			int useCost = 0;//연결 최소 가중치 합 담을 용도 
			
			while(useEdge < m-1) { //사용 간선 m-1개 보다 작은 동안 반복 
				Edge cur = pQ.poll();
				//합쳐도 사이클 형성 안되 경우만 합침 - 최소로 
				if(find(cur.s) != find(cur.e)) {
					union(cur.s, cur.e);
					useCost += cur.val;
					useEdge++;//하나씩 ++ 처리 -> N-1개되면 바로 탈출되겠지 
				}
			}
			
			//이제 최종 절약최대 비용은 전체 - 최소가중치합 
			
			System.out.println(sum - useCost);
		}
	}

}