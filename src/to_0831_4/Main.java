package to_0831_4;

import java.util.*;

/*5972번. 택배 배송 - 다익스트라 문풀 */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e= e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;//가중치 적은 거 우선 
	}
}
public class Main {
	static int N, M;
	static int[] distance;
	static boolean[] visited;//양방향 간선이라 중복 없이 처리 위함
	static ArrayList <ArrayList<Edge>> graph;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
	
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		distance = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b=  kb.nextInt();
			int s = kb.nextInt();
			
			//양방향 간선 
			graph.get(a).add(new Edge(b, s));
			graph.get(b).add(new Edge(a, s));
		}
		
		//다익스트라 시작 
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		//시작점 처리 
		distance[1] = 0;//1은 고정 시작 
		pQ.offer(new Edge(1, 0));//1->1 자기 자신 가중치 0 
		
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;//방문한 거면 넘어감 
			visited[cur.e] = true;//poll한 애는 처리 완료 된거니까 방문처리함 
			
			for(Edge nx : graph.get(cur.e)) {
				//인접 정점에 대하여 
				if(!visited[nx.e] && distance[nx.e] > distance[cur.e] + nx.val) { 
				 	distance[nx.e] = distance[cur.e] + nx.val;
				 	pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
		
		//최소 여물은 distance[N] 에 담긴 값임
		System.out.println(distance[N]);
		
	}
}