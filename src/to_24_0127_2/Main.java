package to_24_0127_2;
/**
 * 2252번. RE
 * @author MYLG
 *
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 2252번. 줄 세우기 - 위상정렬 문풀
 * @author MYLG
 *
 */
public class Main {
	static int N, M;
	static int[] indegree;
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		List<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i<=N; i++ ) graph.add(new ArrayList<>());
		
		indegree = new int[N+1];
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//a -> b : 즉, a 먼저 스고, b 가 뒤에 슨다.
			graph.get(a).add(b);
			indegree[b]++;//진입차수++
		}
		
		/**
		 *	위상 정렬 시작 
		 */
		
		Queue<Integer> Q = new LinkedList<>();
		//진입차수 0 인 정점 모조리 담는다.
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) Q.offer(i);
		}
		List<Integer> answer =new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int cur = Q.poll();
			answer.add(cur);
			for(int nx : graph.get(cur)) {
				indegree[nx]--;
				if(indegree[nx]==0) Q.offer(nx);
			}
		}
		//정답 출력
		for(int x : answer) System.out.print(x + " ");
	}
}