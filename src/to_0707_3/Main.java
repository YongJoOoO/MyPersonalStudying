package to_0707_3;

import java.util.ArrayList;
import java.util.Scanner;

/*트리의 부모 찾기 */
public class Main {
	static int N;
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> graph;//그래프
	static int tree[];//부모노드 저장할 정답용 배열 
	
	//DFS
	static void DFS(int v) {
		visited[v] = true;
		for(int nv : graph.get(v)) { //인접 정점 가져와서 
			if(!visited[nv]) {
				tree[nv] = v;//nv의 부모는 직전 v정점으로 담기 
				DFS(nv); //재귀 호출 깊이 탐색 
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		
		visited = new boolean[N+1];
		tree = new int[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());//공간 생성 
		}
		//입력 데이터 세팅 
		for(int i=1; i<N; i++) { //간선 N-1개 
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향으로 생성 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		//DFS 루트 = 1 시작 
		DFS(1);
		
		for(int i=2; i<=N; i++) {
			System.out.println(tree[i]);
		}
	}
}