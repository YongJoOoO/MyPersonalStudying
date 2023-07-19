package to_0719_7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//컴퓨터 해킹 
public class Main {
	static int N, M;
	static boolean visited[];
	static int answer[];
	static ArrayList<ArrayList<Integer>> graph;
	//bfs
	static void BFS(int v) {
		//각 정점이 탐색하는 정점을 모두 구해야 하므로 방문 배열 다시 초기화 
		visited = new boolean[N+1];
		Queue<Integer> Q = new LinkedList<>();
		
		Q.add(v);
		visited[v] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int nx : graph.get(cur)) {
				if(!visited[nx]) {
					visited[nx] = true;
					Q.add(nx);
					answer[nx]++; //탐색 당한애들은 ++ 처리해주기 
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		answer = new int[N+1];
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//입력 데이터 세팅 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);//단방향 
		}
		
		//각각의 정점에 대한 각각의 탐색뱅려을 세팅 
		for(int i=1; i<=N; i++) {
			BFS(i);
		}
		int max = Integer.MIN_VALUE;
		//답 세팅할 건데 일단 Max값 찾기
		for(int i = 0; i<=N; i++) {
			if(answer[i] > max) {
				max = answer[i];//갱신 
			}
		}
		
		//이제 차례로 max값 갖는 애 오름차순 출력 
		for(int i=1; i<=N; i++) {
			if(answer[i] == max) {
				System.out.print(i + " ");
			}
		}		
	}
}