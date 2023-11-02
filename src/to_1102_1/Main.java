package to_1102_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 2252번. 줄 세우기 - 위상정렬 문풀 
 * @author MYLG
 *
 */
public class Main {
	
	static int N, M;
	static int[] indegree;//진입차수 저장
	static ArrayList<ArrayList<Integer>> graph;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		indegree = new int[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int a= kb.nextInt();
			int b = kb.nextInt();
			//a->b 향해 가는 순섲니까
			graph.get(a).add(b);
			indegree[b]++;
		}
				
		//위상정렬 
		//1) 진입차수 0 인대들은 모두 Q에 담기 
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) Q.offer(i);
		}
		
		//2) 진입차수 0 인 애들 차례로 뽑아서 처리 후, 걔네가 진입하는 애들의 진입차수 --
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			System.out.print(cur + " ");
			for(int nx : graph.get(cur)) {
				indegree[nx]--;//cur이 가리키던 정점의 진입차수 --처리
				if(indegree[nx]==0) Q.offer(nx);
			}
		}
	}	
}