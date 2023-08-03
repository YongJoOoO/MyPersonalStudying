package to_0803_A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//위상정렬 - 2252번. 줄세우기 복습 
public class Main {
	//진입차수용 
	static int[] indegree; 
	
	static ArrayList<ArrayList<Integer>> graph;
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();//노드 
		int M = kb.nextInt();//비교횟수 
		
		indegree = new int[N+1];//진입차수 
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//데이터 입력받기
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b=  kb.nextInt();
			//단방향 그래프임 a->b
			graph.get(a).add(b);
			indegree[b]++;//진입차수++ 
		}
		
		//위상정렬
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				Q.add(i);//담기  출발점이 될 애들임
			}
		}
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			//여기서 뽑느 게 경로임 - 순서 
			System.out.print(cur+" ");
			for(int nx : graph.get(cur)) {
				indegree[nx]--;//인접정점 진입차수 -- 빼버리고 
				if(indegree[nx] == 0) {
					//뺐더니 진입차수 0된 애들은 다시 Q에 담아서 출발점 되도록 설정 
					Q.add(nx);
				}
			}
		}
	}
}