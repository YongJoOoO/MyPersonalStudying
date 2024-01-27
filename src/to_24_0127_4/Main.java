package to_24_0127_4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1766번. 문제집 - 위상 정렬 문풀
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static int[] indegree;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		indegree = new int[N+1];
		
		List<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) pQ.offer(i);
		}
		
		List<Integer> answer = new ArrayList<>();
		while(!pQ.isEmpty()) {
			int cur = pQ.poll();
			answer.add(cur);
			for(int nx : graph.get(cur)) {
				indegree[nx]--;
				if(indegree[nx] == 0) pQ.offer(nx);
			}
		}		
		for(int x : answer) System.out.print(x+ " ");
	}
}