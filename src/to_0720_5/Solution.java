package to_0720_5;
import java.util.*;
//프로그래머스 - 섬 연결하기 - 최소비용 신장트리 문제이다.

class Edge implements Comparable<Edge> {
    int s, e, val;
    Edge(int s, int e, int val){
        this.s = s;
        this.e = e;
        this.val = val;
    }
    @Override
    public int compareTo(Edge o){
        return this.val - o.val;//적은 가중치 우선 정렬 
    }
}
class Solution {
    static int[] parent;//부모 
    static PriorityQueue<Edge> pQ= new PriorityQueue<>();//기준 자동 정렬되도록 
    //find - 사이클 확인용 
    static int find(int a){
        if(a == parent[a]) return a;
        else{
            return parent[a] = find(parent[a]);
        }
    }
    //union - 결합용 
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;//결합
        }
    }
    //솔루션 함수 
    public int solution(int n, int[][] costs) {
        
        parent = new int[n+1];//노드+1개수 
        for(int i=1; i<=n; i++){
            parent[i] = i;//자기 자신 초기화 
        }
        //데이터 입력받아서 가중치 적은 애 우선 정렬되게 큐에 담음 
        for(int i=0; i<costs.length; i++){
            int s= costs[i][0]; //시작점
            int e = costs[i][1];//끝점 
            int v = costs[i][2];//가중치 
            
            pQ.add(new Edge(s, e, v));
        }
        //여기서부터 최소스패닝트리 알고리즘
        int useEdge = 0;
        int answer = 0; //최소비용 누적용 
        while(useEdge < n-1){ //사용 엣지 개수 n-1개 되면 탈출 
            Edge cur = pQ.poll();//가장 가중치 작은 애 뽑기 
            if(find(cur.s) != find(cur.e)){ //두 정점 이어도 사이클 형성 안되면       
                union(cur.s, cur.e);//결합
                answer += cur.val; //가중치 누적 
                useEdge++;
            }
        }
        return answer;
    }
}