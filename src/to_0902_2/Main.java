package to_0902_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*12834번. 주간 미팅 - 다익스트라 */
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
	static int N, V, E; //팀원, 정점 , 간선 
	static int A, B; //Kist, 씨아푸드 위치
	static int[] team;//N명의 팀원들 위치 
	static ArrayList<ArrayList<Edge>> graph;
	//다익스트라 
	static int dijkstra(int st, int e) { //시작점과 끝점에 대한 최단거리 리턴 
		boolean[] visited= new boolean[V+1];
		int[] distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		//시작점 초기화
		distance[st] = 0;
		pQ.offer(new Edge(st, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			//도착점 발견하면 
			if(cur.e == e) return distance[cur.e];//여기서 리턴
			
			for(Edge nx : graph.get(cur.e)) {
				if(!visited[nx.e] && distance[nx.e] > distance[cur.e] + nx.val ) {
					distance[nx.e] = distance[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, distance[nx.e]));
				}
			}
		}
		return distance[e];//도착점 좌표 보낼 건데 
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		V = kb.nextInt();
		E = kb.nextInt();
		
		A = kb.nextInt();
		B = kb.nextInt();
		
		team = new int[N];
		for(int i=0; i<N; i++) {
			team[i] = kb.nextInt();//팀원 집 위치 
		}
		
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {//정점은 V개 
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력
		for(int i=0; i<E; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			//양방향 
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}
		
		int sum =0;
		//호출 -> 각 팀원별
		for(int i=0; i<N; i++) {
			//현재 팀원 -> kist 위치 
			int a = dijkstra(team[i], A);
			//현재 팀원 - 씨앗 푸드 거리 
			int b = dijkstra(team[i] , B);
			
			if(a==Integer.MAX_VALUE) {
				a = -1;//고쳐주고
			}else if(b == Integer.MAX_VALUE) {
				b = -1;
			}
			
			sum += (a+b);//각각의 팀원별 거리 합 구하기
		}
		
		System.out.println(sum);
		
	}
}