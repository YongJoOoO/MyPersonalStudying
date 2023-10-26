package to_1026_2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 2606번. 바이러스 - DFS, BFS 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	
	//BFS
	static int BFS(int st) {
		int answer = 0;
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(st);
		visited[st] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int nx : graph.get(cur)) {
				if(!visited[nx]) {
					answer++;
					Q.offer(nx);
					visited[nx] = true;
				}
			}
		}
		
		return answer;
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		visited= new boolean[N+1];
		
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//간선 입력받기
		for(int i=0; i<M; i++) {
			int a= kb.nextInt();
			int b = kb.nextInt();
			//양방향 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		System.out.println(BFS(1));
	}
}