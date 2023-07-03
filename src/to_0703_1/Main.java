package to_0703_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*1516번. 게임 개발 문제 */
public class Main {

	
	//실행 메인 
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<Integer>());
		
		//진입차수 전용 
		int[] indegree = new int[N+1];
		//selfBuild 전용
		int[] selfBuild = new int[N+1];
		//정답용
		int[] result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			selfBuild[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int preTemp = Integer.parseInt(st.nextToken());
				if(preTemp == -1) {
					break;
				}
				graph.get(preTemp).add(i);//진입 차수 
				indegree[i]++; //진입차수 배열 초기화
			}
		}
		
		//위상정렬
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				Q.offer(i);
			}
		}
		
		while(!Q.isEmpty()) {
			int now = Q.poll();
			for(int nx : graph.get(now)) {
				indegree[nx]--;
				result[nx] = Math.max(result[nx], result[now]+selfBuild[now]);
				if(indegree[nx]==0) {
					Q.offer(nx);
				}
			}
		}		
		//자기 자신 더하기
		for(int i=1; i<=N; i++) {
			System.out.println(result[i]+selfBuild[i]);
		}
	}
}