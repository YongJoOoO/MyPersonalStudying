package to_0829_2;
/*DFS로 풀기 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int N, M, X;
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
		
		//데이터 입력 받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//A-> B 방향 그래프이다.
			graph.get(a).add(b);
			indegree[b]++;//인접 정점 처리 
		}
		
		X = kb.nextInt();//타겟 - 우리는 최종 dy[X] 값을 출력해야 정답 나와야 한다.
		
		
		
		
		
	}
}
