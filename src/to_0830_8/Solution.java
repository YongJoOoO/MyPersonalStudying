package to_0830_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	static int N, X;
	  // 다익스트라 알고리즘
    public static int[] dijkstra1(ArrayList<ArrayList<Edge>> a) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(X, 0));
        
        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;
 
        while (!pq.isEmpty()) {
            Edge curTown = pq.poll();
            int cur = curTown.e;
 
            if (!check[cur]) {
                check[cur] = true;
 
                for (Edge town : a.get(cur)) {
                    if (!check[town.e] && dist[town.e] > dist[cur] + town.val) {
                        dist[town.e] = dist[cur] + town.val;
                        pq.add(new Edge(town.e, dist[town.e]));
                    }
                }
            }
        }
        return dist;
    }
 
}
