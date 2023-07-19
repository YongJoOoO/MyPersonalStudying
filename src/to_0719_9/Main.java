package to_0719_9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//위상정렬 수행과정 
public class Main {
	
	//실행 메인  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		int[] input = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//a -> b를 향해 가는 거야 
			graph.get(a).add(b);
			///b가 진입 대상이므로 진입차수 세팅 
			input[b]++;//값 ++처리 
		}	
		//위상 정렬 -> 진입차수 0인 애들 큐에 넣어준다.
		Queue<Integer> Q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(input[i] == 0) { //진입차수 0인애들은 
				Q.add(i);
			}
		}
		//이제 bfs같음
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			//여기서 경로 짜줌 
			System.out.print(cur+ " ");
			for(int nx : graph.get(cur)) {
				//다음 정점 -- 처리 
				input[nx]--;//빼주고 
				if(input[nx] == 0) {
					Q.add(nx);//0된 진입차수는 다시 담음 
				}
			}
		}		
	}
}