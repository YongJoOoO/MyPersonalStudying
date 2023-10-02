package to_1002_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*17270번. 연예인은 힘들어 - 다익스트라 문풀 */
class Edge implements Comparable<Edge> {
	int e, val;
	Edge(int e, int val){
		this.e = e;
		this.val = val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val-o.val;
	}
}
public class Main {
	static int V, M;
	static int J ,S;
	static ArrayList<ArrayList<Edge>> graph;
	
	//dijkstra
	static int[] dijkstra(int st) {
		//시작점에 따른 결과 보내주기 
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		//가중치 값은 10000이하의 자연수 이므로, 
		Arrays.fill(distance, 10000);
		//시작값 세팅 
		distance[st] = 0;
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(st, 0));//자기 자신을 향하는 값은 0 으로 세팅 
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			if(distance[cur.e] < cur.val) continue;
			
			for(Edge nx : graph.get(cur.e)) {
				if(distance[nx.e] > distance[cur.e] + nx.val) {
					//현재값 거쳐가는 가중치가 더 작다면 
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
		return distance;
	} 
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		V = kb.nextInt();
		M = kb.nextInt();
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) graph.add(new ArrayList<>());
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int v = kb.nextInt();
			//양방향 담기 
			graph.get(a).add(new Edge(b, v));
			graph.get(b).add(new Edge(a, v));
		}
		//출발점 : J 지헌, S 성하
		J = kb.nextInt();
		S = kb.nextInt();
		
		//다익스트라 호출해서 받은 값들을 저장해서 더하기 
		int[] result = new int[V+1];
		
		int[] dist1 = dijkstra(J);
		int[] dist2 = dijkstra(S);
		
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<=V; i++) {
			result[i] = dist1[i] + dist2[i];
			
			//합을 모두 구하고 
			min = Math.min(min, result[i]);//가장 최소값은 여기에 저장해두고 
		}
		
		//최종 정답용 세팅 
		//1) min값을 가지면서 dist1의 값이 dist2의값보다 작을 경우에만 PQ에 담아
		
		PriorityQueue<Integer> answer = new PriorityQueue<>();
		
		for(int i=1; i<=V; i++) {
			if(i==J || i==S ) continue;
			
			if(result[i] == min) { //min값을 가지면서 
				if(dist1[i] <= dist2[i]) {
					answer.offer(i);
				}
			}
		}
		
		
		if(answer.size() == 0) System.out.println(-1);
		else System.out.println(answer.poll());
	}
}