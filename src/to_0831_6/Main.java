package to_0831_6;

import java.util.*;
import java.util.Scanner;

/*13424번. 비밀 모임- 다익스트라 문풀 */
class Edge implements Comparable<Edge>{
	int e, val;
	Edge(int e, int val){
		this.e= e;
		this.val =val;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}
public class Main {
	static int T;
	static int N;//방개수 
	static int M;//간선 개수 
	static ArrayList<ArrayList<Edge>> graph;
	
	//다익스트라 
	static int[] dijkstra(int st) {//시작정점 따라서 
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);//초기화 
		boolean[] visited = new boolean[N+1]; //초기화 했는ㄷ
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		//시작점 처리 
		dist[st] = 0;
		pQ.offer(new Edge(st, 0));
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			
			for(Edge nx : graph.get(cur.e)) {
				if(!visited[nx.e] && dist[nx.e] > dist[cur.e] + nx.val ) {
					dist[nx.e] = dist[cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, dist[nx.e]));
				}
			}
		}
		return dist;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		T = kb.nextInt();
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int t=0; t<T; t++) {//테스트케이스별 실행 
			N= kb.nextInt();
			M = kb.nextInt();
			
			graph = new ArrayList<>();
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<>());
			}
			
			//데이터 입력
			for(int i=0; i<M; i++) {
				int a = kb.nextInt();
				int b = kb.nextInt();
				int s = kb.nextInt();
				//양방향 
				graph.get(a).add(new Edge(b, s));
				graph.get(b).add(new Edge(a, s));
			}
			//K가 고정이 아닌데 도대체 어떻게 ? 하지 ???? 
			
			int K =kb.nextInt();//친구 명수 
			//2차원 배열을 만들자/
			int[][] result = new int[K][N+1];//각 시작점 k에 대한 배열 되도록
			
			for(int i=0; i<K; i++) {
				//각각의 친구가 시작값이 되어야 하는데.
				int st = kb.nextInt();
				//임시 배열 
				int[] dist = dijkstra(st);
				
				for(int j=1; j<= N; j++) {//결과를 각 i행에 대한 j열의 배열로 담기 
					result[i][j] = dist[j];//연달아 담아두고.
				}
			}
			int min = Integer.MAX_VALUE;//최대값으로 세팅해두고 
			//답 세팅해야 하잖아
			
			for(int i=1; i<=N; i++) { //각각의 열에 대한 
				int sum = 0;//각 행별 합
				for(int k=0; k<K; k++) {//행 끼리 합
					sum += result[k][i]; //행끼리 누적 
				}
				min = Math.min(min, sum);//가장 작은 합을가진 애가 min 값이다. 
			}
		
			//최종은 가장 작은 값을 가진 애 인덱스 나타나자 마자 세팅하는거임
			for(int i=1; i<=N; i++) {
				int sum = 0;
				for(int k=0; k<K; k++) {
					sum += result[k][i];
				}
				if(sum == min) { //sum 이 min되는 최초의 경우에 
					answer.add(i);//그 정점을 담고 
					break;
				}
			}
		}
		//정답 출력
		for(int x : answer) {
			System.out.println(x);
		}
	}
}