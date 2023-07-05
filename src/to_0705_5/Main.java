package to_0705_5;

import java.util.Arrays;
import java.util.Scanner;

/*벨만 포드 정복하기 */
class Edge{
	int st, ed, val;
	Edge(int st, int ed, int val){
		this.st= st;
		this.ed =ed;
		this.val =val;
	}
}
public class Main {
	static int N, M;
	static long distance[];
	static Edge edges[];
	static final int INF = Integer.MAX_VALUE;
	
	static boolean bellmanFord(int start) {
		distance[start] = 0;
		for(int i=0; i<N-1; i++) {//N-1번 반복 수행 
			for(int j=0; j<M; j++) {
				Edge cur = edges[j];
				if(distance[cur.st] != INF && distance[cur.ed]>distance[cur.st]+cur.val) {
					distance[cur.ed] = distance[cur.st]+cur.val; //여기서 갱신처리 
				}
			}
		}
		
		//1번 더 M개의 간선에 대하여 사이클 수행하며 업데이트 여부 확인 
		for(int i=0; i<M; i++) {
			Edge cur = edges[i];
			if(distance[cur.st] != INF && distance[cur.ed]>distance[cur.st]+cur.val) {
				//갱신되는 값이 존재할 경우
				return true;
			}
		}		
		return false;//발견안됐으면 false
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb=new Scanner(System.in);
		N= kb.nextInt();
		M= kb.nextInt();
		
		distance = new long[N+1];
		edges =new Edge[M+1];
		
		Arrays.fill(distance, INF);
		//입력받기 
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int c= kb.nextInt();
			edges[i] = new Edge(a, b, c);
		}
		//벨만포드 호출
		boolean flag = bellmanFord(1);
		
		if(!flag) {
			for(int i=2; i<=N; i++) {
				if(distance[i]==INF) {
					System.out.println("-1");
				}else {
					System.out.println(distance[i]);
				}
			}
		}else {//사이클 발견되어서 true리턴시
			System.out.println("-1");
		}
	}
}