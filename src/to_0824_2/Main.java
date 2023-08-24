package to_0824_2;

import java.util.*;

/*2623번. 음악 프로그램- 순서 정하기 - 위상 정렬 */
public class Main {
	static int N, M;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> graph;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		indegree = new int[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int s = kb.nextInt();//사이즈
			
			int before = kb.nextInt();
			for(int j=1; j<s; j++) { //1번 덜 돌면서 
				int a = kb.nextInt();
				graph.get(before).add(a);//하나씩 이어주고
				indegree[a]++;//진입차수 처리 
				
				before = a;//넘겨주고 
			}
		}
		
		//위상정렬 시작 
		Queue<Integer> Q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) Q.offer(i);
		}
		ArrayList<Integer> answer = new ArrayList<>();
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			answer.add(cur);//현재 뽑는 애순서대로 담아
			for(int nx : graph.get(cur)) {
				indegree[nx]--;
				if(indegree[nx]==0) Q.offer(nx);
			}
		}
		//만약 순서 정하는 게 불가능하면 0 출력 해야 한다.
		if(answer.size() != N) {
			System.out.println("0");
		}else {
			for(int x :answer) {
				System.out.println(x);
			}	
		}
	}
}