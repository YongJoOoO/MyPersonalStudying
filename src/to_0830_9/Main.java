package to_0830_9;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*백준 - 다익스트라 (파티) 문풀 RE */
class Edge implements Comparable<Edge>{
	int e;
	int val;
	Edge(int e, int val){
		this.e = e;
		this.val =val;
	}
	public int compareTo(Edge o) {
		return this.val - o.val;//가중치 적은 거 우선 
	};
}
public class Main {
	static int N, M, X;
	static final int INF = 987654321;
	static ArrayList<ArrayList<Edge >> graph;
	static ArrayList<ArrayList<Edge>> reverse;
	//다익스트라
	static int[] dijkstra(ArrayList<ArrayList<Edge>> A) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		int[] dist = new int[N+1];
		boolean[] check = new boolean[N + 1];
		//무한대로 초기화
		Arrays.fill(dist, INF);
		//시작정점 처리 
		dist[X]= 0;
		pQ.offer(new Edge(X, 0));//담기 
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			int cur_e = cur.e;
			
			if(!check[cur_e]) {
				check[cur_e] = true;
				
				for(Edge nx : A.get(cur_e)) {
					if(!check[nx.e] && dist[nx.e] > dist[cur_e] + nx.val) {
						dist[nx.e] = dist[cur_e] + nx.val;
						pQ.offer(new Edge(nx.e, dist[nx.e]));
					}
				}
			}
		}
		return dist;
	}
	
	//실행 메인 
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
	
		graph = new ArrayList<>();
		reverse = new ArrayList<>();
		
		for(int i=0;i <=N; i++) {
			graph.add(new ArrayList<>());
			reverse.add(new ArrayList<>());
		}
		
		//데이터 입력하기 
		for(int i=0; i<8; i++) {
			st = new StringTokenizer(br.readLine());
			int a=  Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			//정방향 
			graph.get(a).add(new Edge(b, c));
			//역방향
			reverse.get(b).add(new Edge(a, c));
		}
		
		int[] distance = dijkstra(graph);
		int[] redistance = dijkstra(reverse);
		
		int max = -1;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, distance[i] + redistance[i]);
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}