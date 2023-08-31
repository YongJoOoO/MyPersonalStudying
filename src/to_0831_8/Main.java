package to_0831_8;
import java.util.*;
import java.util.Scanner;

/*18223번. 민준이와 마산 그리고 건우 - 다익스트라 문풀 
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
	static int V, E, P;
	static int[] distance;// 거리 저장용 
	static boolean[] visited;//체크용 
	static ArrayList<ArrayList<Edge>> graph;
	
	static int dijkstra(int s, int e) {//시작 점과 끝점만 알면 됨 
		//다익스트라 시작 
		Arrays.fill(distance, Integer.MAX_VALUE);//초기화 시켜놓고 
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		distance[s]= 0;//시작점은 고정 1이니까.
		pQ.offer(new Edge(s, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) {
				if(!visited[nx.e] && distance[nx.e] > distance[cur.e] + nx.val) {
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
		return distance[e];//끝점까지의 길이 구하면 되고 
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		V = kb.nextInt();
		E = kb.nextInt();
		P = kb.nextInt();
	
		distance = new int[V+1];
		visited = new boolean[V+1];//초기화 안했었구나
		
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int val = kb.nextInt();
			//양방향 
			graph.get(a).add(new Edge(b, val));
			graph.get(b).add(new Edge(a, val));
		}
		//1-> V 길이 : 그냥 직진 길이 
		int len1 = dijkstra(1, V);
		System.out.println(len1);
		//1-> P 길이 
		//P-> V 길이
		int len2 = dijkstra(1, P) + dijkstra(P, V);
		System.out.println(len2);
		
	}
}