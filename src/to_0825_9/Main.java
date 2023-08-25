package to_0825_9;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Edge {
    int s, e, val;
    Edge(int s, int e, int val) {
        this.s = s;
        this.e = e;
        this.val = val;
    }
}

public class Main {
    static int T, N, M, W;
    static int[] distance;
    static ArrayList<Edge> edges;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        T = kb.nextInt();
        ArrayList<String> answer = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            N = kb.nextInt();
            M = kb.nextInt();
            W = kb.nextInt();

            distance = new int[N + 1];
            edges = new ArrayList<>();

            Arrays.fill(distance, Integer.MAX_VALUE);

            for (int i = 0; i < M; i++) {
                int s = kb.nextInt();
                int e = kb.nextInt();
                int val = kb.nextInt();
                edges.add(new Edge(s, e, val));
                edges.add(new Edge(e, s, val));
            }

            for (int i = 0; i < W; i++) {
                int s = kb.nextInt();
                int e = kb.nextInt();
                int val = kb.nextInt();
                edges.add(new Edge(s, e, -val));
            }

            distance[1] = 0;
            boolean updated = false;

            for (int i = 1; i <= N; i++) {
                for (Edge ed : edges) {
                    if (distance[ed.e] > distance[ed.s] + ed.val) {
                        distance[ed.e] = distance[ed.s] + ed.val;
                        updated = true;
                    }
                }
                if (!updated) break;
            }

            if (updated) {
                answer.add("YES");
            } else {
                answer.add("NO");
            }
        }

        for (String x : answer) {
            System.out.println(x);
        }
    }
}