package to_1118_D;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 2252번. 줄 세우기 - 위상정렬
 * @author MYLG
 *
 */
public class Main {
	
	static int N, M;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> graph;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		indegree = new int[N+1];
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			indegree[b]++;
			graph.get(a).add(b);//방향 
		}
		
		Queue<Integer> Q = new LinkedList<>();
		
		//아 ! 진입차수 
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				Q.offer(i);
			}
		}
		
		//위상 정렬 시작
		ArrayList<Integer> answer = new ArrayList<>();
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			answer.add(cur);
			for(int nx : graph.get(cur)) {
				indegree[nx]--;
				if(indegree[nx]==0) Q.offer(nx);
			}
		}
		//출력
		for(int x : answer) {
			System.out.print(x + " ");
		}
		
	}

}
