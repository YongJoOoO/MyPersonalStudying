package to_0831_5;

import java.util.*;
import java.util.Scanner;

/*17396번. 백도어 - 다익스트라 문풀 */
class Edge implements Comparable<Edge>{
	int e;
	long val;
	Edge(int e, long distance){
		this.e = e;
		this.val = distance;
	}
	@Override
	public int compareTo(Edge o) {
		 if(this.val - o.val > 0) return 1;
         else return -1; 
	}
}
public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] view;
	//경로저장용 배열을 int가 아닌 long으로 해줘야 정답이 맞다. 
	//이유 : N이 10만 M이 30만이다. 둘을 곱하면 이미 10억이 넘는다. 
	// N이 최대 100000, t이 최대 100000 이기 때문에 N * t = 10000000000 이므로 int 범위를 벗어난다. long으로 ㄱㄱ	 
	static long[] distance;
	static ArrayList<ArrayList<Edge>> graph;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		view = new int[N];
		visited =new boolean[N];
		distance = new long[N];
		// distance가 long타입이니까 fill로 채울 떄도 Long타입으로 채울 것 
		Arrays.fill(distance, Long.MAX_VALUE);
		
		graph = new ArrayList<>();
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력 - view 
		for(int i=0; i<N; i++) {
			view[i] = kb.nextInt();
		}
		//마지막 말고 그 전의 1인 값에 대해서는 visited 방묺앴따고 처리할 거 
		for(int i=0; i<N-1; i++) {
			if(view[i] == 1) {
				visited[i] = true;//방문 처리 
			}
		}
		
		//데이터 입력 - 그래프
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			long v = kb.nextInt();
			//양방향 
			graph.get(a).add(new Edge(b, v));
			graph.get(b).add(new Edge(a, v));
		}
		//다익스트라 시작 
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		distance[0]=0;
		pQ.offer(new Edge(0, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;//이미 방문한 곳은 제끼기
			visited[cur.e] = true;//방문처리 
			
			for(Edge nx : graph.get(cur.e)) {
				if( distance[nx.e] > distance[cur.e] + nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
		//정답 출력 
		if(distance[N-1] == Long.MAX_VALUE) { //long 타입 
			//방문이 안됐다는 거니까 
			System.out.println("-1");
		}else {
			System.out.println(distance[N-1]);
		}	
	}
}