package to_0823_6;

import java.util.*;

//1005번. ACM Craft 문풀 - 위상 정렬 
public class Main {
	static int T;//테스트케이스
	static int N;//건물 개수 
	static int K;//간선 개수 
	static int[] time;//각 건물 짓는 시간
	static int[] indegree;//진입차수 
	static ArrayList<ArrayList<Integer>> graph;
	static int W;//타겟 건물 번호 
	static int[] dy;//얘로 시간 구할 거임 
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		T = kb.nextInt();//테스트케이스 
		for(int t=0; t<T; t++) {
			N= kb.nextInt();//정점
			K=kb.nextInt();//간선 
			//시간 받기 
			time = new int[N+1]; //각 작업별 걸리는 시간 
			for(int i=1; i<=N; i++) {
				time[i] = kb.nextInt();
			}
			indegree = new int[N+1];
			//그래프 생성 
			graph = new ArrayList<>();
			for(int i= 0; i<=N; i++) { //번호 N까지
				graph.add(new ArrayList<>());
			}
			
			//간선 개수만큼 입력받기 
			for(int i=0; i<K; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				//이 경우 a -> b 방향 그래프 이므로
				graph.get(a).add(b);//a->b 로 만든 뒤 
				indegree[b]++;//진입차수 ++ 처리 
			}
		
			//W 
			W = kb.nextInt();
			dy = new int[N+1];
			
			//dy[i] : i건물 짓기 위해 먼저 지을 건물까지 처리하여 모두 지은 상태의 시간 저장할 거임 
			
			//위상정렬 시작 
			Queue<Integer> Q = new LinkedList<>();
			
			for(int i=1; i<=N; i++) {
				
				dy[i] = time[i];//값 그대로 
				if(indegree[i] == 0) {
					Q.offer(i);
				}
			}
			
			while(!Q.isEmpty()) {
				int cur =  Q.poll();
				
				for(int nx : graph.get(cur)) { //다음 정점 처리 
					indegree[nx]--;
					
					//dy[i] 도 처리 
					dy[nx] = Math.max(dy[nx], dy[cur] + time[nx]);
					
					if(indegree[nx] == 0) {
						Q.offer(nx);
					}
				}
			}
			//정답 담기 
			answer.add(dy[W]);
		}	
		//정답 출력 
		for(int x : answer) {
			System.out.println(x);
		}
	}
}