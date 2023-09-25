package to_0925_2;
import java.util.*;
import java.io.*;

public class Main {
	//메모리 초과로 입출력을 바꿔야 한다.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer,int[]> graph = new HashMap<Integer,int[]>();
		int[] inDegree = new int[N+1];
		boolean[] v = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			inDegree[a]++;
			inDegree[b]++;
			graph.put(i, new int[] {a,b});
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i = 1; i <= N; i++) {
			if(inDegree[i] < 2) {
				pq.add(i);
			}
		}		
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			if(v[now]) continue;
			v[now] = true;
			for (int targetVal : graph.get(now)) {
				inDegree[targetVal]--;
				if(inDegree[targetVal] < 2) { 
					pq.add(targetVal);
				}
			}
		}		

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(inDegree[i] == 2) {
				cnt++;
				sb.append(i+" ");
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());

	}

}