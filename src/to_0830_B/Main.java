package to_0830_B;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*백준 1238번. 파티 - 다익스트라 문풀 */
public class Main {
	static int N, M, X;
	static int[] input;//가는 방향 
	static int[] output;//오는 방향 
	
	//그래프 2개
	static ArrayList<ArrayList<int[]>> A; //정방향 
	static ArrayList<ArrayList<int[]>> B; //역방향 
	
	//다익스트라 함수 
	static int[] dijkstra(ArrayList<ArrayList<int[]>> graph) {
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2]- b[2]);
		
		//시적점은 X 무조건 처리
		dist[X] = 0;
		pQ.offer(new int[] {X, X, 0});//X로 향하는 가중치 0
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			
		}
		
		return dist;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		M = kb.nextInt();
		X = kb.nextInt();
		
		//초기화
		input = new int[N+1];
		output = new int[N+1];
		
		A = new ArrayList<>();
		B = new ArrayList<>();
		
		//공간 생성 
		for(int i=0; i<=N; i++) {
			A.add(new ArrayList<>());
			B.add(new ArrayList<>());
		}
		
		//데이터 입력받기 
		for(int i=0; i<M; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			int c = kb.nextInt();
			//정방
			A.get(s).add(new int[] {e, c});
			//역방
			B.get(e).add(new int[] {s, c});
		}
		
	
		
		input = dijkstra(A);
		output = dijkstra(B);
		
		//결과 출력 
		
	}

}
