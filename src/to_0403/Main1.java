package to_0403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 9=5. 다익스트라 알고리즘  */
class Edge implements Comparable<Edge>{
	public int vex;//정점
	public int cost;//가중치
	Edge(int vex, int cost){
		this.vex = vex;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost-o.cost; //비용 오름차순
	}
}
public class Main1 {
	static int n, m;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;
	//솔루션 함수
	public void solution(int v) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(v, 0)); 
		dis[v]=0;//첫번째 방문 v는 0으로 처리 (: 시작정점)
		while(!pQ.isEmpty()) {
			Edge tmp = pQ.poll();//오르마순이므로 비용 최소가 poll됨
			int now = tmp.vex;//현재 정점
			int nowCost = tmp.cost;//현재 비용 
			if(nowCost > dis[now]) continue;
			
			//현재 뽑은 now정점과 연결도니 그래프 엣지들 하나씩 뽑아서 돈다.
			for(Edge ob : graph.get(now)) {
				//기존 거리 > 현재 비용 + 새 비용  
				if(dis[ob.vex] > nowCost + ob.cost) {
					dis[ob.vex] = nowCost + ob.cost; //갱신
					pQ.offer(new Edge(ob.vex, nowCost+ob.cost));//새로운 edge 담음
				}
			}
		}
	}

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		
		graph = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		dis = new int[n+1];
		//dis 배열을 모두 Max값으로 초기화 
		Arrays.fill(dis, Integer.MAX_VALUE);
		for(int i=0; i<m; i++) {
			int a= kb.nextInt();
			int b= kb.nextInt();
			int c = kb.nextInt();
			//출발점 a에 연결될 정점 b와 비용 c를 담는다.
			graph.get(a).add(new Edge(b, c));
		}
		
		T.solution(1);
		for(int i=2; i<=n; i++) {
			if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
			else {
				System.out.println(i+ "impossible");
			}
		}
	}	
}