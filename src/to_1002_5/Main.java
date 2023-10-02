package to_1002_5;
import java.io.*;
import java.util.*;
/*백준 17270번. */
public class Main {
	static int V, M, j, s;
	static ArrayList<Edge>[] adj;
	static int [] distJ, distS;
	static final int INF = Integer.MAX_VALUE;
	static class Edge implements Comparable<Edge> {
		int end;
		int cost;
  public Edge(int end, int cost) {
   super();
   this.end = end;
   this.cost = cost;
  }
  @Override
  public int compareTo(Edge o) {
   if(this.cost < o.cost) return -1;
   else if(this.cost == o.cost) { 
    if(this.end < o.end) return -1;
    else if (this.end == o.end) return 0;
    else return 1;
   } else {
    return 1;
   }
  }
 }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[V+1];
		distJ = new int[V+1];
		distS = new int[V+1];
		for(int i=1; i<=V; i++) {
			adj[i] = new ArrayList<>();
			distJ[i] = INF;
			distS[i] = INF;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(b, c));
			adj[b].add(new Edge(a, c));
		}
		st = new StringTokenizer(br.readLine());
		j = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		int nextTime = INF;
		dijkstra(j, distJ);
		dijkstra(s, distS);
		
		for(int i=1; i<=V; i++) {
			if(i==s || i==j) continue;
			else if(nextTime > distJ[i]+distS[i])
				nextTime = distJ[i]+distS[i];
		}
		
		PriorityQueue<Edge> ans = new PriorityQueue<>();
		for(int i=1; i<=V; i++) {
			if(i==s || i==j) continue;
            if(distJ[i]+distS[i]==nextTime) {
					if(distJ[i]<=distS[i])
						ans.add(new Edge(i, distJ[i]));
			}		
		}
		if(ans.isEmpty()) bw.write("-1");
		else bw.write(ans.poll().end+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void dijkstra(int x, int[] dist) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[x] = 0;
		pq.add(new Edge(x, dist[x]));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(dist[cur.end] < cur.cost) continue;
			for(Edge next : adj[cur.end]) {
				if(dist[next.end] > dist[cur.end] + next.cost) {
					dist[next.end] = dist[cur.end] + next.cost;
					
					pq.add(new Edge(next.end, dist[next.end]));
				}
			}
		}
	}
}
