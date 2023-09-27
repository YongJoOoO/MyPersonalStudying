package to_0927_1;

import java.util.PriorityQueue;
import java.util.Scanner;

/*백준 13418번. 학교 탐방하기 - 최소스패닝트리 */
class Edge{
	int s, e, val;
	Edge(int s, int e, int val){
		this.s = s;
		this.e = e;
		this.val = val;
	}
}
public class Main {
	static int N, M;//입력 +1처리 해줘야 함
	static int[] parent;//부모노드 저장용 
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
	
	//mst 알고리즘 - 오르막길 0 이 나오는 횟수 카운팅하여 리턴
	static int MST(PriorityQueue<Edge> pQ) {
		
		//st에 대한 처리 
		int useEdge = 0;
		int useCost = 0;
		
	
		while(useEdge < N-1) {
			Edge cur = pQ.poll();//하나 뽑아서 
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				useEdge++;
				if(cur.val == 0) {
					useCost++;//오르막길 개수 ++처리 
				}
			}
		}
	
		return useCost;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		//입력값을 보면 0번부터 N번의 N+1개 정점이 들어온다.
		//도로는 총 M+1개 들어온다. 이 점을 유의해서 입력값보다 +1 처리 할 것 
		N = kb.nextInt() + 1;
		M = kb.nextInt() + 1;
		parent = new int[N];
		
		for(int i=0; i<N; i++) parent[i]= i;
		
		//1) 최악 = 0 (오름차순) 여러 개 나와야 함 - 즉, 최소비용이므로 오름차순 우선 -> a의 가중치 적은 거 우선 
		PriorityQueue<Edge> pQ1 = new PriorityQueue<>((a, b) -> a.val - b.val);
		
		//2) 최적 = 0 이 최대한 적고 1이 많이 나와야 함 즉. 최대비용이므로 내림차순 운선 
		PriorityQueue<Edge> pQ2 = new PriorityQueue<>((a, b)-> b.val - a.val);
				
		
		//데이터 pQ에 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			//두 개의 큐에 다 담기 
			pQ1.add(new Edge(a, b, val));
			pQ2.add(new Edge(a, b, val));
		}
		
		//1) 최악 경로 : 최소비용 	
		int ans1 = MST(pQ1);//0번으로 출발해야 하므로 
		
		//Re 초기화 
		parent = new int[N];
		for(int i=0; i<N; i++) parent[i]= i;
		
		//2) 최적 경로 : 최대 비용 
		int ans2 = MST(pQ2);	
		int answer = (int) (Math.pow(ans1, 2) - Math.pow(ans2, 2));
		
		System.out.println(answer);
	}
}