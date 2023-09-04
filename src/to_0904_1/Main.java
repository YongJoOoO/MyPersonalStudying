package to_0904_1;

import java.util.*;

/*5944번. 애플 딜리버리 - 다익스트라 문풀 */
public class Main {
	//10만 20만 이러니까
	static int C, P, PB, PA1, PA2;//간선, 정점, 출발, 경유, 목적지 
	static ArrayList<ArrayList<int[]>> graph;
	
	//다익스트라 
	static long dijkstra(int st, int ed) {
		long[] distance= new long[(P+1)];
		boolean[] visited = new boolean[P+1];
		Arrays.fill(distance, Long.MAX_VALUE);
		PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		
		//시작점 처리 
		distance[st] = 0;
		// e, val 순으로 담을 거임 
		pQ.offer(new int[] {st, 0});
		
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			if(visited[cur[0]]) continue;
			if(cur[0] == ed) return distance[ed];//끝점 찾으면 여기서 리턴
			
			for(int[] nx : graph.get(cur[0])) {
				if(!visited[nx[0]] && distance[nx[0]] > distance[cur[0]] + nx[1]) {
					distance[nx[0]] = distance[cur[0]] + nx[1];
					pQ.offer(new int[] {nx[0], (int) distance[nx[0]]});
				}
			}
		}
		
		return distance[ed];
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		C = kb.nextInt();
		P = kb.nextInt();
		PB = kb.nextInt();
		PA1 = kb.nextInt();
		PA2 = kb.nextInt();
		
		graph = new ArrayList<>();
		for(int i=0; i<=P; i++) {
			graph.add(new ArrayList<>());
		}
		
		//데이터 입력 
		for(int i=0; i<C; i++) {
			int a= kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			//양방향 
			graph.get(a).add(new int[] {b, c});
			graph.get(b).add(new int[] {a, c});
		}
		
	
		//호출 
		long min = Long.MIN_VALUE;//최단 거리 구해야 하니까 
		//1) PB -> PA1 -> PA2
		long a = dijkstra(PB, PA1) + dijkstra(PA1, PA2);
		
		//2) PB -> PA2 -> PA1 
		long b = dijkstra(PB, PA2) + dijkstra(PA2, PA1);
		
		min = Math.min(a, b);//더 작은 값으로 세팅 
		
		System.out.println(min);
	}

}