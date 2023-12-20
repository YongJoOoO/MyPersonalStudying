package to_1218_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 위상정렬 2637번. 장난감 조립 - 위상정렬, DFS? 
 * @author MYLG
 *
 */
class Node{
	int e, val;
	Node(int e, int val){
		this.e = e;
		this.val = val;
	}
}
public class Main {
	static int N, M;
	static int[] indegree;
	static ArrayList<ArrayList<Node>> graph;
	static int answer;
	//
	public static int[] topologySort(int n) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 1));
        int[] counter = new int[n + 1];
        counter[n] = 1;
 
        while(!q.isEmpty()) {
            Node cur = q.poll();
 
            for(int i = 0; i < graph.get(cur.val).size(); i++) {
                Node nx = graph.get(cur.val).get(i);
                counter[nx.e] += counter[nx.e] * nx.val;
                
                indegree[nx.e]--;
                if(indegree[nx.e] == 0) q.offer(new Node(nx.e, counter[nx.e]));
            }
        }
        return counter;
    }
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		graph = new ArrayList<>();
		N = kb.nextInt();
		M = kb.nextInt();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		indegree = new int[N+1];
		int[] indegree_x = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			int k = kb.nextInt();
			graph.get(s).add(new Node(e, k));
			indegree[e]++;//진입차수 처리 
			indegree_x[e]++;
		}
		
		int[] result = topologySort(N);
		
		for(int i=1; i<=N; i++) {
			if(indegree_x[i] == 0) {
				System.out.println(i+ " " + result[i]);
			}
		}
	}
}
