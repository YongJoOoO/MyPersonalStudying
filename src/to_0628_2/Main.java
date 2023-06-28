package to_0628_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*위상 정렬ㄴ*/
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();
		int M = kb.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		//진입 차수 저장용 D
		int[] D = new int[N+1];
		
		//진입 그래프 정리 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
			D[b]++;//여기서 더해줘 그러면 진입차수++
		}
		
		//위상 정렬 
		Queue<Integer> Q = new LinkedList<>();
		//정답 세팅용 
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i=1; i<N+1; i++) {
			if(D[i] == 0) {
				Q.add(i);
			}
		}
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			answer.add(cur);//하나씩 뽑은 애가 정답 되는 거니까 
			for(int x : graph.get(cur)) {
				D[x]--;
				if(D[x]==0) {//이후 0이 됐다면 add처리 
					Q.add(x);	
				}
			}
		}
		for(int x : answer) {
			System.out.print(x+" ");
		}
	}
}