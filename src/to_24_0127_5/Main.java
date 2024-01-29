package to_24_0127_5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 3655번. 최종 순위 - 위상 정렬 문풀
 * @author MYLG
 *
 */
public class Main {
	static int TC;
	static int N;
	static int[] rank;
	static int[] indegree;
	static int M;
	
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		TC = kb.nextInt();
		for(int t=0;t<TC; t++) {
			N = kb.nextInt();
			indegree =new int[N+1];
			List<ArrayList<Integer>> graph = new ArrayList<>();
			for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
			
			rank = new int[N+1];
			for(int i=1; i<=N; i++) rank[i] = kb.nextInt();

			//그래프 세팅 
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					graph.get(rank[i]).add(rank[j]);
					indegree[rank[j]]++;
				}
			}
			
			M = kb.nextInt();
			
			for(int i=0; i<M; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				
				//b-a 등수 교체
				if(graph.get(a).contains(b)) {
					graph.get(a).remove( (Integer) b); //기존 간선 제거 
					graph.get(b).add(a);//방향 바꿔 삽입
					indegree[a]++;
					indegree[b]--;
				}else if(graph.get(b).contains(a)) {
					graph.get(b).remove((Integer) a); //기존 간선 제거 
					graph.get(a).add(b); // 방향 바꿔 삽입
					indegree[b]++;
					indegree[a]--;
				}
			}
			
			/**
			 * 위상 정렬 시작 
			 */
			Queue<Integer> Q = new LinkedList<>();
			for(int i=1; i<=N; i++) {
				if(indegree[i] == 0) Q.offer(i);
			}
			List<Integer> answer = new ArrayList<>();
			while(!Q.isEmpty()) {	
				if(Q.size() > 1) {
					System.out.println("?");
					break;
				}
				
				int cur = Q.poll();
				answer.add(cur);
				for(int nx : graph.get(cur)) {
					indegree[nx]--;
					if(indegree[nx]==0) Q.offer(nx);
				}
			}
			
			if(answer.size()!=N) {
				System.out.println("IMPOSSIBLE");
			}else {
				for(int x : answer) {
					System.out.print(x+" ");
				}
			}
			
		}
		
	}

}
