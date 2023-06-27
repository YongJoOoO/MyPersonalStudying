package to_0627_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 백준. 1707번. 이분 그래프 판별 문제 
 *  */
public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] chk;
	static boolean[] visited;
	static boolean IsEven;//이분 탐색 여부
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//static
	static void DFS(int v) {
		visited[v] = true;
		for(int x : graph.get(v)) {
			if(!visited[x]) {//방문 안한 인접 정점인 경우 다른 집합 소속 
				chk[x] = (chk[v] + 1) % 2; //2개로만 나누면 되니까 
				DFS(x);//더 깊이 탐색
			}
			else if(chk[v] == chk[x]) { //이미 방문한 직전 노드가 현재 노드와 동일 집함== 사이클 형성 시  
				IsEven= false; //이분 그래프 불가능 
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<String > answer = new ArrayList<>();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String[] s = br.readLine().split(" ");//공백 기준 나누고
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			
			graph = new ArrayList<>();
			visited = new boolean[V+1];
			chk = new int[V+1];
			IsEven = true;
			for(int i=0; i<=V; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<E; i++) {
				s = br.readLine().split(" ");
				int St= Integer.parseInt(s[0]);
				int Ed =Integer.parseInt(s[1]);
				
				graph.get(St).add(Ed);
				graph.get(Ed).add(St);
			}
			
			for(int i=1; i<=V; i++) {
				if(IsEven) {
					DFS(i);
				}else {
					break;
				}
			}
			
			if(IsEven) {
				answer.add("YES");
			}else {
				answer.add("NO");
			}
		}
		
		//정답 출력 
		for(String a : answer) {
			System.out.println(a);
		}
		
	}
}