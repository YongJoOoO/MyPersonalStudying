package to_0825_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*1865번 웜홀 - 벨만 포드 */
class Edge {
	int s, e, val;
	Edge(int s, int e, int val){
		this.s=  s;
		this.e =e;
		this.val= val;
	}
}
public class Main {
	static int T, N, M, W;
	static int[] distance;//거리
	static ArrayList<Edge> edges;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		T = kb.nextInt();
		ArrayList<String> answer = new ArrayList<>();
		
		for(int t=0; t<T; t++) {
			
			N = kb.nextInt();
			M = kb.nextInt();
			W = kb.nextInt();
			
			//초기화
			distance= new int[N+1];
			edges = new ArrayList<>();
			
			Arrays.fill(distance, Integer.MAX_VALUE);
			
			//데이터 입력받기 - 도로
			for(int i=0; i<M; i++) {
				int s = kb.nextInt();
				int e = kb.nextInt();
				int val = kb.nextInt();
				//도로 양방향이니까 
				edges.add(new Edge(s, e, val));
				edges.add(new Edge(e, s, val));
			}
			//웜홀 입력
			for(int i=0; i<W; i++) {
				int s = kb.nextInt();
				int e = kb.nextInt();
				int val = kb.nextInt();
				//음수로 단방향 담기 
				edges.add(new Edge(s, e, -val));
			}
			
			//벨만포드
			distance[1] = 0;
			
			for(int i=1; i<N; i++) {
				for(int j=0; j<edges.size(); j++) {
					Edge ed = edges.get(j);
					
					if(distance[ed.e] > distance[ed.s] + ed.val) {
						distance[ed.e] = distance[ed.s] + ed.val;
					}
				}
			}
			//1번 더 
			boolean flag =false;
			for(int i=0; i<edges.size(); i++) {
				Edge ed = edges.get(i);
				if(distance[ed.e] > distance[ed.s] + ed.val) {
					flag = true;
				}
			}
			
			//답 세팅 
			if(flag) answer.add("YES");
			else answer.add("NO");
		}
		
		//출력
		for(String x : answer) System.out.println(x);
		
	}
}