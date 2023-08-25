package to_0825_6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Wormhole {
    int start;
    int end;
    int time;

    public Wormhole(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            Wormhole[] wormholes = new Wormhole[2 * M + W];
            for (int i = 0; i < 2 * M; i += 2) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                wormholes[i] = new Wormhole(S, E, T);
                wormholes[i + 1] = new Wormhole(E, S, T);
            }
            for (int i = 2 * M; i < 2 * M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = -Integer.parseInt(st.nextToken());
                wormholes[i] = new Wormhole(S, E, T);
            }

            int[] dist = new int[N + 1];
            Arrays.fill(dist, INF);
            dist[1] = 0;

            boolean updated = false;
            for (int i = 1; i <= N; i++) {
                updated = false;
                for (Wormhole wormhole : wormholes) {
                    if (dist[wormhole.end] > dist[wormhole.start] + wormhole.time) {
                        dist[wormhole.end] = dist[wormhole.start] + wormhole.time;
                        updated = true;
                    }
                }
                if (!updated)
                    break;
            }

            if (updated) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}