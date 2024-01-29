package to_24_0129_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int TC;
    static int N;
    static int[] rank;
    static int[] indegree;
    static int M;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        TC = kb.nextInt();
        for (int t = 0; t < TC; t++) {
            N = kb.nextInt();
            indegree = new int[N + 1];
            List<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

            rank = new int[N + 1];
            for (int i = 1; i <= N; i++) rank[i] = kb.nextInt();

            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    graph.get(rank[i]).add(rank[j]);
                    indegree[rank[j]]++;
                }
            }

            M = kb.nextInt();

            for (int i = 0; i < M; i++) {
                int a = kb.nextInt();
                int b = kb.nextInt();

                if (graph.get(a).contains(b)) {
                    graph.get(a).remove((Integer) b);
                    graph.get(b).add(a);
                    indegree[a]++;
                    indegree[b]--;
                    continue;
                } else if (graph.get(b).contains(a)) {
                    graph.get(b).remove((Integer) a);
                    graph.get(a).add(b);
                    indegree[b]++;
                    indegree[a]--;
                    continue;
                }
            }

            Queue<Integer> Q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) Q.offer(i);
            }
            List<Integer> answer = new ArrayList<>();
            while (!Q.isEmpty()) {
                if (Q.size() > 1) { //명확히 순서를 가릴 수 없는 경우다. 
                    System.out.println("?");
                    break;
                }

                int cur = Q.poll();
                answer.add(cur);
                for (int nx : graph.get(cur)) {
                    indegree[nx]--;
                    if (indegree[nx] == 0) Q.offer(nx);
                }
            }

            if (answer.size() != N) {//사이클이 존재한다 
                System.out.println("IMPOSSIBLE");
            } else {
                for (int x : answer) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }
}