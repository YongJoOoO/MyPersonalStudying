package to_1128_B;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1967번. 트리의 지름 - DFS
 * @author MYLG
 *
 */
class Edge{
	int e, val;
	Edge(int e, int val){
		this.e = e;
		this.val =val;
	}
}
public class Main {
	static int N;
	static ArrayList<ArrayList<Edge>> graph;
	static boolean[] visited;
	
	static int max = 0;
	static int max_idx = 0;
	//DFS
	static void DFS(int idx, int dist) {
		if(max < dist) {
			max = dist;
			max_idx = idx;
		}
		
		for(Edge nx : graph.get(idx)) {
			if(!visited[nx.e] ){
				visited[nx.e] = true;
				DFS(nx.e, dist + nx.val);
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();

		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력받기
		for(int i=0; i<N-1; i++) { //N-1번 반복 하면서 
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			//양방향
			graph.get(a).add(new Edge(b, val));
			graph.get(b).add(new Edge(a, val));
		}
		
		
		visited = new boolean[N+1];
		//1루트 기준 가장 큰 값 갖는 노드 찾기 
		visited[1] = true;
		DFS(1, 0);
	
		//여기서 찾은 최대삭ㅄ 갖는 max_idx값 노드를 기준으로 다시 돌기 
		visited = new boolean[N+1];
		visited[max_idx] = true;
		
		DFS(max_idx, 0);
		
		System.out.println(max);
	}
}