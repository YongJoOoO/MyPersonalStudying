package to_0825_C;
import java.util.*;

class Edge {
    int s, e, val;

    Edge(int s, int e, int val) {
        this.s = s;
        this.e = e;
        this.val = val;
    }
}

public class Main {
    static int n, m;
    static int[] distance;
    static ArrayList<Edge>[] edges;

    // bellmanFord
    static boolean bellmanFord() {
        Arrays.fill(distance, Integer.MIN_VALUE);
        distance[1] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                for (Edge ed : edges[j]) {
                    if (distance[ed.s] != Integer.MIN_VALUE && distance[ed.e] < distance[ed.s] + ed.val) {
                        distance[ed.e] = distance[ed.s] + ed.val;
                    }
                }
            }
        }

        for (int j = 1; j <= n; j++) {
            for (Edge ed : edges[j]) {
                if (distance[ed.e] < distance[ed.s] + ed.val) {
                    return true; // 음수 사이클
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        distance = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int u = kb.nextInt();
            int v = kb.nextInt();
            int val = kb.nextInt();
            edges[v].add(new Edge(u, v, val)); // v로 들어오는 간선을 저장
        }

        boolean flag = bellmanFord();

        if (flag) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= n; i++) {
                if (distance[i] == Integer.MIN_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(i);
                }
            }
        }
    }
}