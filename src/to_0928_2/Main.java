package to_0928_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int e, val;

    Edge(int e, int val) {
        this.e = e;
        this.val = val;
    }

    @Override
    public int compareTo(Edge o) {
        return this.val - o.val; // 최소비용 우선
    }
}

public class Main {
    static int TC;
    static int N, M;
    static int[] distance;
    static int[] parent;
    static ArrayList<ArrayList<Edge>> graph;

    static void dijkstra() {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        distance = new int[M];
        parent = new int[M];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        pQ.offer(new Edge(0, 0));

        while (!pQ.isEmpty()) {
            Edge cur = pQ.poll();
            if (distance[cur.e] < cur.val) continue;
            if (cur.e == M - 1) break;

            for (Edge nx : graph.get(cur.e)) {
                if (distance[nx.e] > distance[cur.e] + nx.val) {
                    distance[nx.e] = distance[cur.e] + nx.val;
                    parent[nx.e] = cur.e;
                    pQ.offer(new Edge(nx.e, distance[nx.e]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Edge(b, val));
                graph.get(b).add(new Edge(a, val));
            }

            dijkstra();
            System.out.print("Case #" + (t + 1) + ": ");

            if (distance[M - 1] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                Stack<Integer> stack = new Stack<>();
                int idx = M - 1;
                while (idx != 0) {
                    stack.push(idx);
                    idx = parent[idx];
                }

                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
                System.out.println(M - 1);
            }
        }
    }
}