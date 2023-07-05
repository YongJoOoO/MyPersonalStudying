package to_0705_2;

import java.util.Arrays;
import java.util.Scanner;

/*벨만-포드 : 타임머신 문제 */
class Edge {
	int st;
	int ed;
	int val;
	Edge(int st, int ed, int val){
		this.st = st;
		this.ed = ed;
		this.val = val;
	}
}
public class Main {
	static int N, M;
	static long distance[];
	static Edge edges[];
	static final int INF = Integer.MAX_VALUE;
	
	//벨만포드 함수
	static boolean bellmanFord(int start) {
		//시작점 초기화 
		distance[start] = 0;
		//N-1번 반복
		for(int i=0; i<N-1; i++) {
			//전체 간선에 대하여 
			for(int j=0; j<M; j++) {
				Edge cur = edges[j];
				//끝점 > 시작점 + val 인 경우에 업데이트
				if(distance[cur.st] != INF && distance[cur.ed] > distance[cur.st]+ cur.val) {
					distance[cur.ed] = distance[cur.st] + cur.val;
				}
			}
		}
		
		//===> 여기서 음수 사이클 존재 여부 판별 
		boolean myCycle = false;
		for(int i=0; i<M; i++) {
			Edge cur = edges[i];
			if(distance[cur.st] != INF && distance[cur.ed]> distance[cur.st]+ cur.val) {
				//즉, 업데이트 되는 값이 발견되면 
				myCycle = true;
			}
		}
		return myCycle;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N= kb.nextInt();
		int M= kb.nextInt();
		
		distance = new long[N+1];
		edges = new Edge[M+1];//엣지 개수 +1
		
		Arrays.fill(distance, INF);

		//입력받기
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c  = kb.nextInt();
			
			edges[i] = new Edge(a, b, c);
		}
		
		//리턴값이 false == 즉, 사이클 없다면 
		if(!bellmanFord(1)) {
			//시작점1 제외한 2~N까지의 값을 출력할 건데 
			for(int i=2; i<=N; i++) {
				if(distance[i] == INF) {
					System.out.println(-1); //경로 없음 
				}else {
					System.out.println(distance[i]);
				}
			}
		}else if(bellmanFord(1) == true) {//만약 true리턴되어서 사이클 존재한다면 
			System.out.println(-1);
		}
	}
}