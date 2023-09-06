package to_0906_4;

import java.util.*;

/*1516번. 게임 개발 -위상정렬 문풀 */
public class Main {
	static int N;
	static int[] cost;//각자 건물 짓는 기본 시간 
	static int[] indegree;//진입차수 
	static int[] dy; //시간 누적용 DP
	static ArrayList<ArrayList<Integer>> graph;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		cost = new int[N+1];
		indegree = new int[N+1];
		dy = new int[N+1];
		
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++ ) graph.add(new ArrayList<>());
		
		//데이터 입력받기 
		for(int i=1; i<=N; i++) {
			int a=  kb.nextInt();
			cost[i] = a;//각 건물 짓는 비용 담기 
			
			while(true) {
				int b = kb.nextInt();//직전에 짓는 건물 번호 담기 i
				
				if(b == -1) break;
				
				//아니면 
				graph.get(b).add(i);//b먼저 짓고 i를 지어야 한다.
				//진입차수는
				indegree[i]++;//현재 i를 기준으로 ++처리 
			}
		}
		
		//위상정렬 처리 
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			dy[i] = cost[i];//여기서 미리 담아두기 자기 건물 짓는 시간 
			if(indegree[i] == 0) Q.offer(i);//담기 
		}
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			
			for(int nx : graph.get(cur)) {
				indegree[nx]--;
				//여기서 시간 : 직전 건물 시간 + 현재 건물 짓는 시간으로  갱신 
				dy[nx] = Math.max(dy[nx], dy[cur] + cost[nx]);
				
				if(indegree[nx]==0) Q.offer(nx);
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(dy[i]);
		}
		
	}
}