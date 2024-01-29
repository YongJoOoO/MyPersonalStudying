package to_24_0129_2;

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
	static int N, M;
	static int[] rank;//작년 등수 
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> graph;
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		TC = kb.nextInt();
		for(int t=0; t<TC; t++) {
			N = kb.nextInt();
			graph = new ArrayList<>();
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<>());
			}
			
			rank = new int[N+1];
			indegree =new int[N+1];
			
			for(int i=1; i<=N; i++) rank[i]= kb.nextInt();
			
			for(int i=1; i<=N; i++) {
				for(int j=i+1; j<=N; j++) {
					//rank[i] -> rank[j] 방향 그래프
					graph.get(rank[i]).add(rank[j]);
					indegree[rank[j]]++;
				}
			}
			//등수 바뀐 m개
			M = kb.nextInt();
			
			for(int i=0; i<M; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				
				if(graph.get(a).contains(b)) {//기존 a-> b 방향이었으면 반전시킴
					graph.get(a).remove((Integer)b);
					graph.get(b).add(a);
					indegree[b]--;
					indegree[a]++;
				}else if(graph.get(b).contains(a)) { //기존 b-> a 방향이었으면 반전시킴
					graph.get(b).remove((Integer)a);
					graph.get(a).add(b);
					indegree[a]--;
					indegree[b]++;
				}
			}
			
			//위상정렬 시작
			Queue<Integer> Q = new LinkedList<>();
			for(int i=1; i<=N; i++) {
				if(indegree[i] == 0) {
					Q.offer(i);
				}
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
					if(indegree[nx]==0) {
						Q.offer(nx);
					}
				}
			}
			
			if(answer.size() != N) {
				System.out.println("IMPOSSIBLE");
			}else {
				for(int x : answer) {
					System.out.print(x+" ");
				}
				System.out.println();
			}
		}
	}
}