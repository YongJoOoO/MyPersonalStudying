package to_0829_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*21937번. 작업 */
public class Main {
	static int N, M, X;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] dy; //dy[i] 정의 : i를 짓기 전에 먼저 해야 하는 작업 개수 담기 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		indegree = new int[N+1];
		dy = new int[N+1];
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력 받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//A-> B 방향 그래프이다.
			graph.get(a).add(b);
			indegree[b]++;//인접 정점 처리 
		}
		
		X = kb.nextInt();//타겟 - 우리는 최종 dy[X] 값을 출력해야 정답 나와야 한다.
		
		//위상 정렬 시작 - 0인 애 먼저 담는다. 
		Queue<Integer> Q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] ==0) Q.offer(i);
		}
		
		//이제 하나씩 뽑아서 처리 
		while(!Q.isEmpty()) {
			int cur = Q.poll(); 
			for(int nx : graph.get(cur)) {
				//인접 정점들에 대하여 
				indegree[nx]--;//하나씩 제거해주고
			
				if(indegree[nx]==0) Q.offer(nx);//담고 
			}
		}
		
		//답 세팅 
		if(dy[X] == 0) System.out.println("0");
		else System.out.println(dy[X]);		
	}
}