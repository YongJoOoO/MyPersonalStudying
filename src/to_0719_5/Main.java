package to_0719_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//18352번. 특정 거리의 도시 찾기 
public class Main {
	static int N, M, K, S;
	static int[] visited;//방문 여기에 최단 경로 담을 겨
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<Integer> answer;
	//bfs
	static void bfs(int a) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(a);
		visited[a] = 0;//자기 자신은 0
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int nx : graph.get(cur)) {
				if(visited[nx]==-1) {
					Q.add(nx);
					visited[nx] = visited[cur]+1;
				}
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		K = kb.nextInt();
		S = kb.nextInt();
		visited = new int[N+1];
		//없으면 -1출력해야 하니까 -1 세팅
		Arrays.fill(visited, -1);
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력 받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//단방향이므로 
			graph.get(a).add(b);
		}
		
		//시작 데이터 
		bfs(S); //S정점으로 시작함 
		answer = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			if(visited[i] == K) {
				answer.add(i);//ㅇㅇ
			}
		}
		
		//했는데 하나도 안담기면 -1 출력 
		if(answer.isEmpty()) {
			System.out.println(-1);
		}else {
			for(int x : answer ) {
				System.out.println(x);
			}
		}
	}
}