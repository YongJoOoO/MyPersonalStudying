package to_0825_9;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*1865번. 웜홀- 벨만포드 : 드디어 맞았따 !!!!!!!!!*/
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
    static final int INF = 987654321;
    //벨만포드
    static boolean bellmanFord() {
    	Arrays.fill(distance, INF);
        distance[1] = 0; //시작점 처리 
        boolean updated = false;
        
        for(int i =1; i<N; i++) { //1) N-1번 반복함
        	for(int j=0; j<edges.size(); j++) {
        		Edge ed = edges.get(j);
        		//N-1번까지 최단 거리 세팅한다. 
        		if(distance[ed.e] > distance[ed.s] + ed.val) {
        			distance[ed.e] = distance[ed.s] + ed.val;
        		}
        	}
        }
        //이후 1번 더 반복했을 떄에도 업데이트 값이 존재할 경우 "음수 사이클이 존재"
        for(int i=0; i<edges.size(); i++) {
        	Edge ed = edges.get(i);
        	if(distance[ed.e] > distance[ed.s] + ed.val) {
        		return true;//이때에도 갱신값이 존재할 경우 ?
        	}
        }
        return false;
    }
    
    //실행 메인 
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
            
            if(bellmanFord()) { //결과 true이면 
            	answer.add("YES"); //음수가중치 존재
            }else {
            	answer.add("NO");//음수 가중치없다.
            }
        }
        for (String x : answer) {
            System.out.println(x);
        }
    }
}