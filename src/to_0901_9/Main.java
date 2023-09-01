package to_0901_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*23793번. 두 단계 최단 경로 1 - 다익스트라 */
class Edge implements Comparable<Edge> {
	long e; 
	int val;

	Edge(long e, int val) {
		this.e = e;
		this.val = val;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}
}

public class Main {
	static long N, M;
	static long X, Y, Z;
	static ArrayList<ArrayList<Edge>> graph;

	// 다익스트라
	static long dijkstra(long st, long ed, long dont) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		long[] distance = new long[(int) N + 1];
		Arrays.fill(distance, Long.MAX_VALUE);
		distance[(int)st] = 0;
		pQ.offer(new Edge(st, 0));

		while (!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			// 발견하면 그냥 리턴
			if (cur.e == ed)
				return distance[(int)ed];

			for (Edge nx : graph.get((int)cur.e)) {
				if (nx.e == dont)
					continue;// 거치면 안되는 지점이면 넘어가고
				if (distance[(int)nx.e] > distance[(int)cur.e] + nx.val) {
					distance[(int)nx.e] = distance[(int)cur.e] + nx.val;
					pQ.offer(new Edge(nx.e, nx.val));
				}
			}
		}
		return distance[(int)ed];
	}

	// 실행 메인
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextLong();
		M = kb.nextLong();

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		// 데이터 입력
		for (int i = 0; i < M; i++) {
			int a = kb.nextInt();
			long b = kb.nextLong();
			int c = kb.nextInt();
			graph.get(a).add(new Edge(b, c));
		}

		X = kb.nextInt();
		Y = kb.nextInt();
		Z = kb.nextInt();

		long len1 = dijkstra(X, Y, 0);
		long len2 = dijkstra(Y, Z, 0);
		long len3 = dijkstra(X, Z, Y);

		long answer1 = len1 + len2;
		long answer2 = len3;
		if (len1 == Long.MAX_VALUE || len2 == Long.MAX_VALUE) {
			answer1 = -1;
		} else if (len3 == Long.MAX_VALUE) {
			answer2 = -1;
		}
		System.out.println(answer1 + " " + answer2);
	}
}