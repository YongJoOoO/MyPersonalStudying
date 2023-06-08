package to_0608_6;

import java.util.*;

/* 백준 친구 관계 파악하기 RE 풀이 */
public class Main {
	//정적 변수 
	static ArrayList<Integer> [] A;
	static boolean visited[];
	static boolean arrive;// 5까지 깊이 탐색한 애 존재하는지 확인용 
	//DFS 함수
	static void DFS(int v, int lv) {
		if(lv == 5 || arrive) {
			arrive = true; //처리후 
			return; //그냥 리턴 
		}
		visited[v] = true; //방문처리
		for(int x : A[v]) {
			if(!visited[x]) {
				DFS(x, lv+1);//다음 레벨로 호출 
			}
		}
		
		//만약 DFS로 깊이 있게 갔고 돌아왔는데 arrive는 false라면 
		//다음 정점에 대한 깊이 있게 순회해야 하므로 
		visited[v]= false;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		visited = new boolean[n];
		A = new ArrayList[n];
		//ArrayList 공간 먼저 생성 
		for(int i=0; i<n; i++) {
			A[i]=new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			int a =kb.nextInt();
			int b = kb.nextInt();
			
			//쌍방 친구이니 양방향으로 
			A[a].add(b);
			A[b].add(a);
		}
		
		//모든 정점 순회하면서 
		for(int i=0; i<n; i++) {
			DFS(i, 1);//i부터 1레벨 순회 
			
			if(arrive == true) break; //DFS 복귀 시 하나라도 arrive 등장하면 그냥 break;
		}
		
		if(arrive) System.out.println("1");
		else System.out.println("0");
	}
}