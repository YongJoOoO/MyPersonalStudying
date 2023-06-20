package to_0620_5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*18352번. 특정 거리의 도시찾기 
 * */
public class Main {
	static int N, M, K, S;
	//방문 배열 - 거리 측정용 
	static int visited[];
	//그래프 표현 
	static ArrayList<ArrayList<Integer>> graph;
	
	//정답 세팅용 
	static ArrayList<Integer> answer = new ArrayList<>();
	
	//BFS
	static void BFS(int n) {
		int cnt = 1;
		Queue<Integer> Q = new LinkedList<>();
		Q.add(n);
		visited[n] = cnt;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			if(cnt == K) {
				answer.add(cur);
			}
			for(int x : graph.get(cur)) {
				if(visited[x] != 0) {//아직 방문 안한 인접 정점에 대하여 
					Q.add(x);//큐에 삽입시키고 
					visited[x] = visited[cur] + 1;
					cnt++;
				}
			}
			
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt(); //노드개수
		M = kb.nextInt(); //엣지개수 
		
		K = kb.nextInt();//거리 
		S = kb.nextInt();//출발 노드 
		
		//공간 생성 
		visited = new int[N+1];
		graph = new ArrayList<>();
		
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//M번 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);//단방향이라 하나만 저장함
		}
		
		//호출
		BFS(S);
		
		//정답 출력
		if(answer.size() == 0) {
			System.out.println(-1);//정답 없으므로 
		}else {
			for(int x: answer) {
				System.out.println(x);
			}
		}
		
	}

}
