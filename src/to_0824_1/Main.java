package to_0824_1;

import java.util.*;

/*14567번. 선수 과목 - 위상정렬 + 레벨 탐색  */

public class Main {
	static int N, M;
	static int[] indegree;
	static int[] dy;
	static ArrayList<ArrayList<Integer>> graph;
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		indegree = new int[N+1];
		dy = new int[N+1];
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//a -> b 순으로 수강
			graph.get(a).add(b);
			indegree[b]++;//진입차수 ++
		}
		
		int lv = 0;
		Queue<Integer> Q = new LinkedList<>();
		
		//진입차수 0 인애 싹 담기 
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				Q.offer(i);
			}
		}
		while(!Q.isEmpty()) {
			//레벨 탐색할 거라 
			lv++;
			int len = Q.size();
			for(int i=0; i<len ;i++) {//하나의 레벨에 대하여 
				int cur = Q.poll();
				dy[cur] = lv;//담기 
				for(int nx : graph.get(cur)) {//뽑은 현재 과목 다음 과목 처리 
					indegree[nx]--;
					if(indegree[nx] == 0) Q.offer(nx);
				}
			}
		}
		//정답 출력 
		for(int i=1; i<=N; i++) {
			System.out.print(dy[i] + " ");
		}
	}
}