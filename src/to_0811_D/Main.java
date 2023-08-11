package to_0811_D;

import java.io.*;
import java.util.*;

/*15651번. N과 M (3) */
public class Main {
	static int N, M;
	static int[] answer;
	static boolean[] visited;
	//방문체크 배열은 그냥 X
	static StringBuilder sb = new StringBuilder();
	//DFS
	static void DFS(int lv) {
		if(lv == M) {
			for(int x : answer) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i< N; i++) {
			visited[i] = true;
			answer[lv] = i+1;
			DFS(lv+1);
			visited[i] = false;
		}
	}
	
	//실행 메인 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer = new int[M];
		visited = new boolean[N];
		
		DFS(0);
		System.out.println(sb);
	}
}