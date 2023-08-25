package to_0825_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*1865번. 웜홀 - 벨만포드 (음수 사이클 확인용 ) */
class Edge {
	int e;
	int val;
	Edge(int e, int val){
		this.e=e;
		this.val =val;
	}
}
public class Main {
	static int T;
	static int N, M, W;
	static int[] distance;//거리배열 
	static ArrayList<Edge> graph[];
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		T = kb.nextInt();
		//정답 세팅용 
		ArrayList<String> arr = new ArrayList<>();
		for(int t = 0; t<T; t++) {
			N = kb.nextInt();
			M = kb.nextInt();
			W = kb.nextInt(); //웜홀 개수 
			
			distance = new int[N+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			
			graph = new ArrayList[N+1];
			
			for(int i=0; i<=N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			//데이터 입력받기 
			for(int i=0; i<M; i++) {
				int s = kb.nextInt();
				int e= kb.nextInt();
				int val = kb.nextInt();
				//도로는 양방향 
				graph[s].add(new Edge(e, val));
				graph[e].add(new Edge(s, val));
			}
			
			//웜홀 받기 
			for(int i=0; i<W; i++) {
				int s = kb.nextInt();
				int e = kb.nextInt();
				int val = kb.nextInt();
				//단방향 웜홀 그래프
				graph[s].add(new Edge(e, -val));
			}
			
			//벨만포드 - 
			distance[1]= 0;
			//1) N-1번 반복 
			for(int i=1; i<N; i++) {
				for(int j=1; j<graph.length; j++) {
					
					for(Edge ed : graph[j]) {
						//시작점은 j이다.
						if(distance[ed.e] > distance[j] + ed.val) {
							distance[ed.e] = distance[j] + ed.val;//값 갱신 
						}
					}
				}
			}
			//2) 1번 더 반복 
			boolean flag = false;
			
			for(int i=0; i<graph.length; i++) {
				for(Edge ed : graph[i]) {
					if(distance[ed.e] > distance[i] + ed.val) {
						//값이 또 갱신된다면 
						flag = true;
					}
				}
			}
			
			//이제 이 TC 의 flag 값에 따라 값 세팅 
			if(!flag) arr.add("NO");
			else arr.add("YES");
		}	
		for(String x : arr) System.out.println(x);
	}
}