package to_0621_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 백준 18352번. 특정 거리의 도시 찾기 */
public class Main {
	static int N, M, K, S;
	//방문여부
	static int visited[];//여기에 인접 거리 저장할 거라
	static ArrayList<ArrayList<Integer>> graph;
	
	//BFS
	static void BFS(int n) {
		Queue<Integer> Q = new LinkedList<>();
		visited[n] = 1;
		Q.add(n);
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int nx : graph.get(cur)) {
				if(visited[nx] == 0) { //방문 안한 인접 정점에 대하여 
					Q.add(nx);
					visited[nx] = visited[cur] + 1;//이전 정점 + 1 거리 처리 
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
		
		//공간 생성 
		visited = new int[N+1];
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//입력받기
		for(int i=0; i<M; i++){
			int a= kb.nextInt();
			int b= kb.nextInt();
			
			graph.get(a).add(b);
		}
		
		//호출
		BFS(S);//시작점은 S
		
		ArrayList<Integer> answer = new ArrayList<>();
		//정답 출력 K+1 과 값이 같은 애가 정답임
		for(int i=1; i<=N; i++) {
			if(K+1 == visited[i]) {
				answer.add(i); //그 인덱스 출력 
			}
		}
		//만약에 그 값이 없었다면 
		if(answer.size() == 0) {
			System.out.println(-1);
		}else {
			for(int x : answer) {
				System.out.println(x);
			}
		}
	}
}