package to_0906_5;

import java.util.*;
import java.util.Scanner;

/*1753번. 최단경로 = 다익스트라 문풀 */
public class Main {
	static int V, E, K;
	static int distance[];
	static ArrayList<ArrayList<int[]>> graph;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		V= kb.nextInt();
		E = kb.nextInt();
		K = kb.nextInt();//시작정점 
		distance= new int[V+1];
		
		graph = new ArrayList<>();
		
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력 
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int x = kb.nextInt();
			graph.get(a).add(new int[] {b, x});
		}
		
		//가중치 적은 거 우선순위 
		PriorityQueue<int[]> pQ= new PriorityQueue<>((a, b) -> a[1]-b[1]);
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		//시작점 처리 
		distance[K] = 0;
		pQ.offer(new int[] {K, 0});
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			
			for(int[] nx : graph.get(cur[0])) {
				if(distance[nx[0]] > distance[cur[0]] + nx[1]) {
					distance[nx[0]] = distance[cur[0]] + nx[1];
					pQ.offer(new int[] {nx[0], distance[nx[0]]});
				}
			}
		}
		
		//출력 
		for(int i=1; i<=V; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
		
	}

}