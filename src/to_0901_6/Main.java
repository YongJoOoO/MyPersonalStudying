package to_0901_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*22865번. 가장 먼 곳 - 다익스트라 */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e = e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int N, A, B, C, M;
	
	static ArrayList<ArrayList<Edge>> graph;
	//다익스트라 함수 
	static int[] dijkstra(int st) {
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Edge > pQ = new PriorityQueue<>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		//시작점 초기화
		dist[st] =0;
		pQ.offer(new Edge(st, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) {
				if(!visited[nx.e] && dist[nx.e] > dist[cur.e] + nx.val) {
					dist[nx.e] = dist[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, dist[nx.e]));
				}
			}
		}
		
		
		return dist;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		A = kb.nextInt();
		B = kb.nextInt();
		C = kb.nextInt();
		M = kb.nextInt();
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력 
		for(int i=0; i<M; i++) {
			int a=  kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}
		
		//다익스트라 호출 
		int[] dist1 = dijkstra(A);
		int[] dist2 = dijkstra(B);
		int[] dist3 = dijkstra(C);
		
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=1; i<= N; i++) {
			
			int min = Integer.MAX_VALUE;
			min = Math.min(Math.min(dist1[i], dist2[i]), dist3[i]);
			
			answer.add(min);
		}
		
		int Max = Integer.MIN_VALUE;
		for(int x : answer) {
			if(x != 0) {
				Max = Math.max(Max, x); //가장 작은 애들끼리 모은 거 중에서 최댓값 구하기
			}
		}
	
		for(int i=0; i<answer.size(); i++) {
			if(Max == answer.get(i)) {
				System.out.println(i+1);
				break;
			}
		}
	}

}