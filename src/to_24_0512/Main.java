package to_24_0512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, X;
	static int[] indegree;//진입차수 저장용 
	static List<List<Integer>> graph;
	
	static int[] parent;
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	//union
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		X = kb.nextInt();
		
		indegree = new int[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//a -> b
			graph.get(a).add(b);
			indegree[b]++;//진입도 ++처리 
		}
		
		Queue<Integer> Q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) Q.offer(i);//진입 0인 애들 담음 
		}
		
		Queue<Integer> twoQ = new LinkedList<>();
		if(Q.size() != 1) {
			for(int i=N; i >=1; i--) {
				if(indegree[i] == 0) twoQ.offer(i);
			}
		}
		
		List<Integer> route = new ArrayList<>();
		
		if(Q.size() == 1) {
			while(!Q.isEmpty()) {
				int cur = Q.poll();
				System.out.println(cur);
				for(int nx : graph.get(cur)) {
					indegree[nx]--;
					if(indegree[nx] == 0) {
						Q.offer(nx);
					}
				}
				route.add(cur);
			}
			
		}else {
			while(!twoQ.isEmpty()) {
				int cur = twoQ.poll();
				System.out.println(cur);
				for(int nx : graph.get(cur)) {
					indegree[nx]--;
					if(indegree[nx] == 0) {
						twoQ.offer(nx);
					}
				}
				route.add(cur);
			}
			
		}
	
		
	}

}
