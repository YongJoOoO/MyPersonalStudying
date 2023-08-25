package to_0825_1;

import java.util.*;

/*2948번. 임계경로 구하기 */
class Node{
	int target;
	int value;
	Node(int target, int value){
		this.target = target;
		this.value = value;
	}
}
public class Main {
	static int N, M;
	static int[] indegree;
	//정방향 그래프 
	static ArrayList<ArrayList<Node>> A;
	//역방향 그래프
	static ArrayList<ArrayList<Node>> reverseA;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		indegree = new int[N+1];
		
		A = new ArrayList<>();
		reverseA = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			A.add(new ArrayList<>());
			reverseA.add(new ArrayList<>());
		}
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int val = kb.nextInt();
			//정방 입력 
			A.get(a).add(new Node(b, val));
			//역방 입력
			reverseA.get(b).add(new Node(a, val));
			
			//진입차수 
			indegree[b]++;//찐 진입차수 ++ 처리 
		}
		
		//출발도시 도착도시 입력 
		int start = kb.nextInt();
		int end = kb.nextInt();
		
		//위상정렬 알고리즘 시작 =====> 
		Queue<Integer> Q = new LinkedList<>();
		
		//시작점 처리
		Q.offer(start);
		//가장 긴 임계경로 구하기 위해 각 도시로 가는 정점 - 다익스트라로 풀기 
		int[] result = new int[N+1];
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(Node nx : A.get(cur)) {
				int target = nx.target;
				int val = nx.value;
				//기존 값 vs cur정점 거쳐가는 값 중 큰 값으로 세팅 
				result[target] = Math.max(result[target], result[cur]+val);
				indegree[target	]--;
				
				if(indegree[target]==0) {
					Q.offer(target);
				}
			}
		}
		
		//역방향 위상정렬 처리 
		int resultCnt = 0;//도시 개수 
		boolean[] visited = new boolean[N+1];
		Q = new LinkedList<>();
		
		Q.offer(end);//도착점부터 역으로 거쳐가기
		visited[end] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(Node nx : reverseA.get(cur)) {
				//하나씩 역순으로 가면서 체킹
				if(result[nx.target] + nx.value == result[cur]) {
					resultCnt++;
					//중복 카운팅 방지 위하여 이미 방문한 곳은 체킹
					if(visited[nx.target]== false) {
						visited[nx.target] = true;
						Q.offer(nx.target);
					}
				}
			}
		}
		
		//정답 세팅 
		System.out.println(result[end]);//가장 긴 임계경로 시간 
		System.out.println(resultCnt);//그 도시 개수 
	}
}