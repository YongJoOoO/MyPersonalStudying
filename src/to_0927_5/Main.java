package to_0927_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*백준 20168번 골목대장 호석 - 다익스트라 문풀 */
class Edge {
	int e, val;
	Edge(int e, int val){
		this.e =e;
		this.val = val;
	}
}
public class Main {
	static int N, M, A, B, C;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Edge>> graph;
	
	//다익스트라 함수 
	static int dijkstra(PriorityQueue<Edge> pQ, int st) {
		
		distance= new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		visited = new boolean[N+1];
		
		//시작점 초기화
		distance[A] =0 ;
		pQ.offer(new Edge(A, 0 ));
		
		int max = Integer.MIN_VALUE;
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(cur.e == B) break;
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) {
				if(distance[nx.e] > distance[cur.e] + nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					max = Math.max(max, nx.val);//max값 갱신 가는 경로 기준으로 
					pQ.offer(new Edge(nx.e, distance[nx.e]));
					
				}
			}
		}
		
		if(distance[B] <= C) {//문제의 비용이하로 갈 수 있는 경로라면 
			return max; //가는 도중의 max 가중치를 리턴함
		}else { //못가는 거면 -1
			return -1;//못가면 -1
		}
		
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		A = kb.nextInt();
		B = kb.nextInt();
		C = kb.nextInt();
		
		graph = new ArrayList<>();
	
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			int a= kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			//양방향 이니까 
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}
		//1)pQ 하나는 오름차순 : 가중치 적은 거 우선함 
		PriorityQueue<Edge> pQ1 = new PriorityQueue<>((a, b) -> a.val - b.val);
		int ans1 = dijkstra(pQ1, A);
		
		//2)pQ 하나는 오름차순 : 가중치 적은 거 우선함 
		PriorityQueue<Edge> pQ2 = new PriorityQueue<>((a, b) -> b.val - a.val);
		int ans2 = dijkstra(pQ2, A);
		
		int min = Integer.MAX_VALUE;
		if(ans1 != -1 && ans2 != -1) {
			min = Math.min(ans1, ans2);
			System.out.println(min);
		}else if (ans1 == -1 && ans2 == -1) {
			System.out.println("-1");
		}else {
			min = Math.max(ans1, ans2);//더 큰 값으로 
			System.out.println(min);
		}
	}

}