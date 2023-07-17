package to_0717_8;

import java.util.ArrayList;
import java.util.Scanner;

/*11724번. 연결 요소의 개수 */
public class Main {
	static int N, M;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	
	//dfs
	static void dfs(int v) {
		visited[v] = true;//현재 정점 방문 처리 
		
		for(int nx : graph.get(v)) { //얘의 인접 정점들에 대하여 
			if(!visited[nx]) {
				dfs(nx);//재귀 더 깊이 방문 
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		//초기화
		visited = new boolean[N+1];
		//공간 생성 
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			int a =kb.nextInt();
			int b = kb.nextInt();
			//양방향이므로 양쪽에 모두 저장 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		int answer =0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				dfs(i);//방문 안한 정점에 대하여 dfs 호출하면 
				answer++;//여기서 복귀하면 호출 후 복귀한 게 한 덩어리 단위임
			}
		}
		//정답 출력 
		System.out.println(answer);
	}
}