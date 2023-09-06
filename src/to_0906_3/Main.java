package to_0906_3;

import java.util.*;

/*2252번. 줄 세우기-  위상정렬 문풀 */
public class Main {
	static  int N, M;
	static int[] indegree; //진입차수 
	static ArrayList<ArrayList<Integer>> graph;
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		indegree =new int[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			int a= kb.nextInt();
			int b= kb.nextInt();
			//방향 그래프 
			graph.get(a).add(b);
			//진입차수도 ++
			indegree[b]++;//b를 향하므로 
		}
		
		//위상정렬 시작할 게요 0인애부터 담을게요 
		Queue<Integer> Q = new LinkedList<>();
		for(int i=1;i<=N; i++) {
			if(indegree[i] == 0) Q.offer(i);
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		//이제 whileㅈ돌면서
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			answer.add(cur);//뽑는 애는 처리 완료 된 거니까 뽑아 담고 
			
			for(int nx : graph.get(cur)) {//향하고 있는 정점 처리핡할 건데 
				indegree[nx]--;
				if(indegree[nx] == 0) {
					Q.offer(nx);//다시 담기 
				}
			}
		}
		
		//답 출력 
		for(int x : answer) System.out.print(x+" ");
	}
}