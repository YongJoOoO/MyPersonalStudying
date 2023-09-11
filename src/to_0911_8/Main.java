package to_0911_8;

import java.util.PriorityQueue;
import java.util.Scanner;

/*14621번. 나만 안되는 연애 - 최소 스패닝 트리 문풀 */
class Edge implements Comparable<Edge>{ 
	int s;
	int e;//끝점
	int val;//가중치
	Edge(int s, int e, int val){
		this.s= s;
		this.e= e;
		this.val= val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//가중치 낮은 거 우선 순위 
	}
}
public class Main {
	static int N, M;//정점과 간선 개수 
	static int[] parent;
	//find
	static int find(int a) {
		if(a==parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	//union
	static void union(int a, int b) {
		a= find(a);
		b =find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		String[] team = new String[N+1];
		for(int i=1; i<=N; i++) {
			team[i] = kb.next();
		}
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) parent[i]=i;
		
		//가중치 적은 거 운선 정렬
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		for(int i=0; i<M; i++) {
			int a =kb.nextInt();//얘로 자기 팀 확인하고 
			int b= kb.nextInt();
			int x = kb.nextInt();
			pQ.offer(new Edge(a, b, x));//담고 
		}
		
		int useEdge = 0;
		int useCost = 0;
		boolean flag = true;//이거로 연결 상태 
		
		while(useEdge <N-1){
			//가장 낮은 가중치를 뽑고 
			Edge cur = pQ.poll();
			if(cur == null && useEdge < N-1) { 
				flag = false;//연결 끊김 다음 연결할 정점이 X
				break;
			}
			//둘이 서로 사이클 형성 X && 두 정점의 학교 W , M이 다른 경우에 한해서 union
			if(find(cur.s) != find(cur.e)) {
				//팀도 다른 팀일 경우에만 
				if(!team[cur.s].equals(team[cur.e])){
					union(cur.s, cur.e);
					useCost += cur.val;//가중치 합치고 
					useEdge++;
				}
			}
		}
		
		if(!flag) {
			//연결 끊긴 상태라면 
			System.out.println("-1");
		}else System.out.println(useCost);
	}
}