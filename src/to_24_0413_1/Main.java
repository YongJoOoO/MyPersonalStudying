package to_24_0413_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int e, val;
    Edge(int e, int val){
        this.e =e;
        this.val = val;
    }
    @Override
    public int compareTo(Edge o) {
        return this.val- o.val;//가중치 오름차순
    }
}

public class Main {
    static List<List<Edge>> graph;
    static int N, M;
    static int[] distance;
    static int[] routine;
    //간선 연결 정보를 현재 정점-다음 정점 순으로 담아야 되나 ?

    //dijkstra
    static void dijkstra(int st){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        distance[st] = 0;
        pQ.offer(new Edge(st, 0));
        
        while(!pQ.isEmpty()) {
            Edge cur = pQ.poll();
            if (cur.val > distance[cur.e])
                continue;
            for (Edge nx : graph.get(cur.e)) {
                if (distance[nx.e] > distance[cur.e] + nx.val) {
                    distance[nx.e] = distance[cur.e] + nx.val;
                    pQ.offer(new Edge(nx.e, distance[nx.e]));
                    routine[nx.e] = cur.e;
                }
            }
        }
    }

    //실행 메인
    public static void main(String[] args) {
        Scanner kb=  new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        //데이터 입력
        for(int i=0; i<M; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int v = kb.nextInt();
            //양바향 간선
            graph.get(a).add(new Edge(b, v));
            graph.get(b).add(new Edge(a, v));
        }
        
        routine = new int[N+1];
        
        dijkstra(1);
        
        StringBuilder sb = new StringBuilder();
        
        int cnt = 0;
        for(int i=2; i<=N; i++) {
        	if(routine[i]==0) continue;
        	cnt++;
        	sb.append(i+ " " + routine[i] + "\n");
        }
        
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}