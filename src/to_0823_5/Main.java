package to_0823_5;

import java.util.*;

/*2056번. 작업 - 문풀 */
class Node{
	int n;
	int time;
	Node(int n, int time){
		this.n= n;
		this.time =time;
	}
}
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
				indegree[nx] --;//cur이 지칭하는 정점 진입차수 -- 처리 
									//기존 nx 시간 vs 현재cur 값 + time[nx] 중 큰 값 
				result[nx] = Math.max(result[nx], result[cur] + time[nx]);
				if(indegree[nx] == 0) {
					Q.offer(nx);
				}
			}
		}
		
		//정답 세팅이 어렵다.
		int ans = 0;
		for(int i=1; i<=N; i++) {
			System.out.print(result[i] + " ");
			ans = Math.max(ans, result[i]);
		}
		
		//System.out.println(ans);
	}

}