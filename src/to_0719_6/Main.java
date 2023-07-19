package to_0719_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//RE
public class Main {
	static int N, M, K, S;
	static int visited[];//얘로 방문 거리 측정용 
	static ArrayList<ArrayList<Integer>> graph;
	//BFS
	static void BFS(int S) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(S);
		visited[S]= 0;//시작 정점 이고 자기 자신은 거리 0
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int nx : graph.get(cur)) {
				if(visited[nx] == -1) { //방문 전인 인접 정점에 대하여
					Q.add(nx);
					visited[nx] = visited[cur] + 1;//직전 정점 거리의 +1처리 
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N =kb.nextInt();
		M = kb.nextInt();
		K = kb.nextInt();
		S = kb.nextInt();
		
		visited= new int[N+1];
		Arrays.fill(visited, -1);
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//입력 데이터 받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
		}
		//시작 정점으로 BFS 호출
		BFS(S);		
		//정답 세팅
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			if(visited[i] == K ) {
				//거리가 K인 노드 발견 시 
				answer.add(i);//해당 도시정점을 담고 
			}
		}
		//다 담았는데 만약 answer 크기 0인 경우 없다는 거니 -1 출력 
		if(answer.isEmpty()) {
			System.out.println(-1);
		}else {
			for(int x : answer) {
				System.out.println(x);
			}
		}		
	}
}