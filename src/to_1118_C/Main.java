package to_1118_C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1916번. 최소비용 구하기 = 다익스트라 문풀ㄴ
 * @author MYLG
 *
 */
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
	static int N, M;
	static int[] distance;
	static ArrayList<ArrayList<Edge>> graph;
	static int S, E;
	static PriorityQueue<int[]> pQ;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		distance= new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력받기 방향 그래프임
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			graph.get(a).add(new Edge(b, val));
		}
		
		S = kb.nextInt();
		E = kb.nextInt();
		//다익스트라 시작 
		
		pQ = new PriorityQueue<>((a, b)-> a[2]-b[2]);
		
		//시작점 처리
		distance[S] = 0;
		pQ.offer(new int[] {S, S, 0});//S에서 S 자신은 거리 0
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			if(cur[2] > distance[cur[1]]) continue;
			
			for(Edge nx : graph.get(cur[1])) {
				if(distance[nx.e] > distance[cur[1]] + nx.val) {
					distance[nx.e] = distance[cur[1]] + nx.val;
					pQ.offer(new int[] {cur[1], nx.e, distance[nx.e]});
				}
			}
		}
		System.out.println(distance[E]);	
	}
}