package to_0925_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*백준  위상정렬 */
public class Main {
	static int N;
	static int[] indegree;
	
	//실행 메인 
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		indegree = new int[N+1];//1번부터니까 

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력받기 
		for(int i=1; i<=N; i++) {
			//한쪽 방향 현재i번째 정점이 a, b 로 방향 쏘는 거임 
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(i).add(a);
			graph.get(i).add(b);
			
			//진입차수도 ++처리
			indegree[a]++;
			indegree[b]++;
		}
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		//이제 진입차수가 2보다 작은 애들은 다 담기 
		for(int i=1; i<=N; i++) {
			if(indegree[i] < 2) { //선물 2개씩은 줘야하니까. 2개 안되는 애들은 다담기 
				pQ.add(i);
			}
		}
		
		boolean[] visited = new boolean[N+1];
		while(!pQ.isEmpty()) {
			int cur = pQ.poll();
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for(int nx : graph.get(cur)) {
				indegree[nx]--;
				if(indegree[nx]<2) {
					pQ.add(nx);
				}
			}
		}
		
		
		int cnt = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		//이제 서눔ㄹ 2개씨인 애들 담기 
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 2) {
				cnt++;
				arr.add(i);
			}
		}
		System.out.println(cnt);
		for(int x : arr) {
			System.out.print(x + " ");
		}
		
	}	
}