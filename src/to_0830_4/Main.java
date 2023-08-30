package to_0830_4;

import java.util.*;
import java.util.Scanner;

/*1167번. 트리의 지름 - BFS 로 풀긴 할거지만 응용*/
class Edge{
	int e;
	int val;
	Edge(int e, int val){
		this.e = e;
		this.val= val;
	}
}
public class Main {
	static int V;
	static int[] distance;//거리
	static boolean[] visited;
	static ArrayList<ArrayList<Edge>> graph;
	//BFS
	static void BFS(int v) {
		Queue<Integer> Q= new LinkedList<>();
		Q.offer(v);
		visited[v] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(Edge nx : graph.get(cur)) {
				int nx_e= nx.e;
				int nx_val = nx.val;
				
				if(!visited[nx_e]) {
					visited[nx_e]= true;
					Q.offer(nx_e);
					distance[nx_e] = distance[cur] + nx_val;//직전값+val
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		V = kb.nextInt();//정점 개수
		
		distance = new int[V+1];
		visited = new boolean[V+1];
		
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) graph.add(new ArrayList<>());
		
		//데이터 입력받을 건데 
		for(int i=1; i<=V; i++) {
			int s = kb.nextInt();//시작 정점 
			while(true) {
				int e= kb.nextInt();
				if(e == -1) break;
				int val = kb.nextInt();
				//양방향인데
				graph.get(s).add(new Edge(e, val));
		
			}
		}
		
		//시작점은 최초에 1로 철 
		BFS(1);
		
		//이제 1 뒤에 가장 max 값 갖는 애부터 시작점 설정하여 BFS 
		int max = 1;
		for(int i=2; i<=V; i++) {
			if(distance[max] < distance[i]) max = i;
		}
		
		distance = new int[V+1];
		visited = new boolean[V+1];
		
		BFS(max); //max값 갖던 애로 다시 BFS 순회하고 나서 나온 값중 
		
		Arrays.sort(distance);//정렬 후 
		System.out.println(distance[V]); //가장 최댓값 출력
	}
}