package to_0823_5;

import java.util.*;

/*2056번. 작업 - 문풀 */
public class Main {
	
	static int N;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] indegree;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		indegree = new int[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		int[] time = new int[N+1];
		//데이터 입력 - 세팅 
		for(int i=1; i<=N; i++) {
			int a = kb.nextInt(); //time
			int b = kb.nextInt(); //선행 개수 
			indegree[i] = b; //진입차수 세팅 
			time[i]=a;//각 시간 
			if(b != 0) {
				for(int j=0; j<b; j++) {
					int c = kb.nextInt();
					graph.get(c).add(i);
				}
			}
		}
		
		int[] result = new int[N+1];
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			result[i] = time[i];
			if(indegree[i] == 0) {
				Q.offer(i);
			}
		}
		ArrayList<Integer> arr = new ArrayList<>();
		
		//순서 정하기 
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			//정답 처리 
			arr.add(cur);
			
			for(int nx : graph.get(cur)) {
				indegree[nx] --;//cur이 지칭하는 정점 진입차수 -- 
				//이게 왜 그런 거냐면 nx 좌표의 시간값 = 현재 cur로 뽑은 시간 이후에 닿는 정점이기 때문에
				//그 시간 + nx의 time 값 합친 거 중에 큰 값 세팅 
				result[nx] = Math.max(result[nx], result[cur] + time[nx]);
				if(indegree[nx] == 0) {
					Q.offer(nx);
				}
			}
		}
		//모든 작업 완료하는데 걸리는 최소시간 
		int ans = 0;
		for(int i=1; i<=N; i++) {
			ans = Math.max(ans, result[i]);
		}
		System.out.println(ans);
	}
}