package back_0507_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int e, val;
    Edge(int e, int val){
        this.e = e;
        this.val =val;
    }

    @Override
    public int compareTo(Edge o) {
        return this.val - o.val;
    }

}
public class Main {
    static int N, M;
    static int[] distance;//거리 배열
    static List<List<Edge>> graph;//그래프 - 양방향

    static List<Integer> visitEdge;//방문 순서대로 세팅하기
    //다익스트라 함수 - 시작 정점에서 최단 경로를 잇는 거 찾아야 함
    public static void dijkstra(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[v] = 0;
        pQ.offer(new Edge(v, 0));

        while(!pQ.isEmpty()){
            Edge cur = pQ.poll();
            if(cur.val > distance[cur.e]) continue;
            System.out.println(cur.val);

            for(Edge nx : graph.get(cur.e)){
                if(distance[nx.e] > distance[cur.e] + nx.val) {
                    distance[nx.e] = distance[cur.e] + nx.val;
                    pQ.offer(new Edge(nx.e, distance[nx.e]));
                }
            }
        }


    }

    //실행 메인
    public static void main(String[] args) {
        Scanner kb= new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        distance = new int[N+1];
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        //입력받기
        for(int i=0; i<M; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int v = kb.nextInt();
            //양방향
            graph.get(a).add(new Edge(b, v));
            graph.get(b).add(new Edge(a, v));
        }

        dijkstra(1);


    }
}
