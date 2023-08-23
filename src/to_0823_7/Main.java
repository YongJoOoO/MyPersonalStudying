package to_0823_7;

import java.util.*;

/*1516번. 게임 개발 - 위상정렬 + DP 문풀 */
public class Main {
	static int N;//건물
	static int[] time;//각 건물 짓는데 시간 
	static int[] dy;//각 건물까지 짓기 전 + 건물 짓는 시간 
	static int[] indegree;//진입차수 
	static ArrayList<ArrayList<Integer>> graph;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		time = new int[N+1];
		dy = new int[N+1];
		indegree = new int[N+1];
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력받을 건데 
		for(int i=1; i<=N; i++) {
			int a = kb.nextInt();
			time[i] = a;//시간 세팅
			
			while(true) { 
				int b = kb.nextInt();
				if(b == -1) break;
				//b먼저 하고 i를 지어야 한다. 
				graph.get(b).add(i);
				indegree[i]++;
			}
		}
		
		//위상정렬 세팅 
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			dy[i] = time[i];
			if(indegree[i]==0) {
				Q.offer(i);
			}
		}
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			
			for(int nx : graph.get(cur)) {
				//기존 시간보다 더 큰 dy[cur]+time[nx] 나타나면 갱신한다.
				dy[nx] = Math.max(dy[nx], dy[cur] + time[nx]);
				indegree[nx]--;
				if(indegree[nx]==0) Q.offer(nx);
			}
		}
		//각 건물 짓는 최소 시간 출ㄹ력 
		for(int i=1; i<=N; i++) {	
			System.out.println(dy[i]);
		}	
	}
}