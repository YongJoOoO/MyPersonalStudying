package to_0823_8;

import java.util.*;
import java.util.PriorityQueue;

/*1766번. 문제집 - 위상정렬 & pQ 문풀 */
public class Main {
	static int N, M;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> graph;
	static PriorityQueue<Integer> pQ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
	
		indegree= new int[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b=  kb.nextInt();
			//a먼저 풀고 b를 풀어야 함 a->b
			graph.get(a).add(b);
			indegree[b]++;//진입차수 
		}
		
		//위상 정렬 처리 
		//그 전에 난이도 적은 문제도 우선이라 했으니까 - Q대신 PQ에 담기 
		//자동오름차순 
		pQ = new PriorityQueue<>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i] ==0) {
				pQ.offer(i);
			}
		}
		//정답 세팅용 
		ArrayList<Integer> arr = new ArrayList<>();
		
		while(!pQ.isEmpty()) {
			int cur = pQ.poll();
			//여기서 정답 순서대로 담는다.
			arr.add(cur);
			for(int nx : graph.get(cur)) {
				indegree[nx]--;
				if(indegree[nx]==0) pQ.offer(nx);
			}
		}
		//정답 출력처리 
		for(int x : arr) {
			System.out.print(x+ " ");
		}
	}
	
	
	
}