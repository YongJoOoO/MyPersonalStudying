package to_24_0116_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 5719번. 거의 최단 경로 - 다익스트라 
 * @author MYLG
 *
 */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e = e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int N, M, S, E;
	static int[] distance;
	static ArrayList<ArrayList<Edge>> graph;
	static List<Integer> list = new ArrayList<>();
	//다익스트라
	static void dijkstra() {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		Arrays.fill(distance, Integer.MAX_VALUE);
		//시작점 초기화
		distance[S] = 0;
		pQ.offer(new Edge(S, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			for(Edge nx : graph.get(cur.e)) {
				if(distance[nx.e] > distance[cur.e] + nx.val){
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
					if(nx.e == E) {
						//끝점이 E인 경우에 한해서 
						list.add(distance[nx.e]);
					}
				}
			}
		}
		
	}
	
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		while(true) {
			N = kb.nextInt();
			M = kb.nextInt();
			if(N==0 && M == 0) break;
			
			S = kb.nextInt();
			E = kb.nextInt();
			
			distance = new int[N];
			
			graph = new ArrayList<>();
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<>());
			}
			
			//데이터 입력
			for(int i=0; i<M; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				int val = kb.nextInt();
				//방향 그래프
				graph.get(a).add(new Edge(b, val));
			}
			
			//다익스트라 
			dijkstra();
			
			for(int x : list) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

}
