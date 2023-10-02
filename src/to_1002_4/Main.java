package to_1002_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] visitS = new int[V + 1];
		int[] visitJ = new int[V + 1];
		graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<Node>();
			visitS[i] = Integer.MAX_VALUE;
			visitJ[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));

		}

		st = new StringTokenizer(br.readLine());
		int J = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		findPos(J, visitJ);
		findPos(S, visitS);
		
		
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		int minJ = Integer.MAX_VALUE;
		
		for (int i = 1; i <= V; i++) {
			if(i == S || i == J) continue; //1
			int val = visitS[i] + visitJ[i];
			if(val > min) continue; //2
			min = val;
		}
		
		for(int i = 1 ; i<=V;i++) {		
			if(i == S || i == J) continue; //1
			if(min == visitS[i] + visitJ[i]) {

				if(visitS[i] < visitJ[i]) continue; //3
				
				if(minJ <= visitJ[i]) {
					continue;
				}

				minIdx = i;
				minJ = visitJ[i];
			}

		}
		System.out.println(minIdx);
		
	}

	static ArrayList<Node>[] graph;

	static class Node implements Comparable<Node> {
		int idx, w;

		public Node(int idx, int w) {
			super();
			this.idx = idx;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {

			return this.w - o.w;
		}

	}

	static void findPos(int start, int[] visit) {

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(start, 0));
		visit[start] = 0;
		
		while (!pq.isEmpty()) {
			Node p = pq.poll();

			for (Node node : graph[p.idx]) {

				if (visit[node.idx] > node.w + p.w) {

					pq.add(new Node(node.idx, node.w + p.w));
					visit[node.idx] = node.w + p.w;

				}
			}
		}

	}

}