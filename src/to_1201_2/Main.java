package to_1201_2;
import java.io.*;
import java.util.*;


public class Main {
    //터널 정보 클래스
    static class Tunnel{
        //다음값, 거리
        int to, cost;
        Tunnel(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    //다익스트라를 위한 클래스
    static class Info implements Comparable<Info>{
        //idx : 현재, cost : 이동한 거리, max : 최장 통로 거리
        int idx, cost, max;
        Info(int idx, int cost, int max){
            this.idx = idx;
            this.cost = cost;
            this.max = max;
        }
        //이동한 거리 기준 오름차순 정렬
        @Override
        public int compareTo(Info o) {
            return this.cost - o.cost;
        }
    }
    //터널 정보 저장 리스트
    static List<List<Tunnel>> tunnels = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //입력값 저장
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        //터널 리스트 초기화
        for(int i=0;i<=N;i++){
            tunnels.add(new ArrayList<>());
        }
        //터널 정보 저장
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //양방향 터널
            tunnels.get(from).add(new Tunnel(to,cost));
            tunnels.get(to).add(new Tunnel(from,cost));
        }
        //다익스트라를 통한 최단거리 구하기
        int result = search(S, E, N);
        //최단거리 BufferedWriter 저장
        bw.write(String.valueOf(result));
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //다익스트라를 통해 최단 거리를 구합니다.
    static int search(int start, int end, int N){
        //다익스트라를 위한 우선순위 큐
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(start,0,0));
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        //다익스트라 진행
        while(!pq.isEmpty()){
            Info cur = pq.poll();
            //가장 먼저 도착 드론에 왔을 때
            if(cur.idx == end){
                //이동한 거리 - 통로 최장 거리
                return cur.cost - cur.max;
            }
            //주변 통로 탐색
            for(Tunnel tunnel : tunnels.get(cur.idx)){
                if(!visited[tunnel.to]){
                    visited[tunnel.to] = true;
                    pq.add(new Info(tunnel.to, cur.cost + tunnel.cost, Math.max(cur.max, tunnel.cost)));
                }
            }
        }
        return 0;
    }
}