package to_0718_3;

import java.util.ArrayList;
import java.util.Scanner;

/*13023번 친구관계파악 */
public class Main {
	static int N, M;
	static boolean visited[];
	static boolean arrive;//e도착여부 
	static ArrayList<ArrayList<Integer>> graph;
	
	//dfs
	static void dfs(int v, int lv) {
		if(lv == 5 || arrive) {
			arrive = true;
			return;//여기서 복귀 
		}
		visited[v] = true;
		for(int nx : graph.get(v)) {
			if(!visited[nx]) {
				dfs(nx, lv+1);///더 깊이 탐색 
			}
		}
		//복귀 후 다시 방문 이전으로
		visited[v] = false;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		visited = new boolean[N];
		arrive= false;
		
		graph  = new ArrayList<>();
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//입력 데이터 처리 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//양방향 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		//노드 전체 순회하면서 친구 관계파악 하기 
		for(int i=0; i<N; i++) {
			dfs(i, 1);
			if(arrive) break;//복귀했는데 하나라도 ㅇ깊이 탐색 됐으면 그냥 여기서 탈출 
		}
		
		if(arrive) System.out.println("1");
		else System.out.println("0");	
	}
}