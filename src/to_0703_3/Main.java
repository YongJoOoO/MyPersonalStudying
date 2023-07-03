package to_0703_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*백준 1916. 최소비용 구하기 */
class Node implements Comparable<Node>{
	int v;
	int val;
	Node(int v, int val){
		this.v = v;
		this.val = val;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		
		return this.val - o.val; //오름차순 정렬 
	}
}
public class Main {
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int E = kb.nextInt();
		
		distance= new int[N+1];
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) graph.add(new ArrayList<Node>());
		
		//distance 거리 배열 값 ㅈㄴ 큰 값으로 초기화
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<E; i++) {
			int st = kb.nextInt();
			int ed = kb.nextInt();
			int w = kb.nextInt();
			graph.get(st).add(new Node(ed,w));
		}
		
		int S = kb.nextInt();
		int Ed = kb.nextInt();
		//----> 여기서부터 다익스트라 알고리즘 적용-기본 오름차순 
		PriorityQueue<Node> Q = new PriorityQueue<>();
		distance[S] = 0;
		Q.add(new Node(S, 0));
		
		while(!Q.isEmpty()) {
			//현재 노드 정보 뽑기
			Node cur = Q.poll();
			int c_v = cur.v;
			int c_val = cur.val;
			if(!visited[c_v]) {//아직 방문 안한 정점에 대하여 
				visited[c_v] = true;//방문처리 
				for(Node nx : graph.get(c_v)) {
					int nx_v = nx.v;
					int nx_val = nx.val;
					if(!visited[nx_v] && distance[nx_v] > distance[c_v]+nx_val) {
						distance[nx_v] = distance[c_v] + nx_val;//다음 정점 거리 = 현재 정점 + 다음 가중치
						Q.add(new Node(nx_v, distance[nx_v]));
					}
				}
			}
		}
		//도착지 최단거리출력 
		System.out.println(distance[Ed]);
		
	}
}