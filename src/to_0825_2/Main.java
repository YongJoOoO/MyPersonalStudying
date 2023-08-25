package to_0825_2;

import java.util.*;

/*2611번. 자동차 경주 - 문풀 */
class Node{
	int target;
	int val;
	Node(int target, int val){
		this.target = target;
		this.val = val;
	}
}
public class Main {
	static int N, M;
	static ArrayList<ArrayList<Node>> graph;
	static int[] dy;//얘에 경로 담을 거고 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		dy = new int[N+1];
		
		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		int[] indegree = new int[N+1];
		//데이터 입력받기
		for(int i=0; i<M; i++) {
			int p = kb.nextInt();
			int q = kb.nextInt();
			int r = kb.nextInt();
			//정방
			graph.get(p).add(new Node(q, r));
			indegree[q]++;
		}
		
		//처리를 할건데 - 다익스트라로 할까 생각 중임
		//시작점 처리 
		Queue<Integer> Q = new LinkedList<>();
		
		Q.offer(1);
		dy[1] = 0;
		//출발점 -> 도착점
		boolean[] visited = new boolean[N+1];
		int[] parent = new int[N+1];
		visited[1] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(Node nx : graph.get(cur)) {
				//더 큰 값으로 값 갱신 
				int val = dy[cur] + nx.val;
				if(val > dy[nx.target]) {
					dy[nx.target] = val;
					//부모 처리 
					parent[nx.target] = cur;//얘의 부모
				}
				indegree[nx.target]--;
				
				if(indegree[nx.target] ==0) { //0이 될 때만 방문처리 
					visited[nx.target]= true;
					Q.offer(nx.target);
				}
			}
		}
		System.out.println(dy[1]);
		
		//경로는 역순으로 가야할듯 
		//경로 
		ArrayList<Integer> answer = new ArrayList<>();
		int s = parent[1];
		
		while(s!=1) {
			answer.add(s);
			s = parent[s];
		}
		
		System.out.print(1+" ");
		for(int i=answer.size()-1 ; i>=0; i--) {
			System.out.print(answer.get(i)+" ");
		}
		System.out.println("1");
	}
}