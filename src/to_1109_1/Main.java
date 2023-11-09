package to_1109_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] dy;// dy[i] : 직원 i가 직속상사에게 누적받은 칭찬값
	
	static void DFS(int idx) { //1로 시작
		for(int nx : graph.get(idx)) {
			dy[nx] += dy[idx];
			DFS(nx);//다음 깊이로 가라 
		}
	}

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
	
		N = kb.nextInt();
		M = kb.nextInt();
		
		graph = new ArrayList<>();
		dy = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//이제 직속 상사에 대한 값 저장
		//방향 그래프로서 저장.
		
		for(int i=1; i<=N; i++) {
			int val = kb.nextInt();
			if(val != -1) {
				graph.get(val).add(i);//val -> i(상사 val -> 직원 i)
			}
		}
		
		for(int i=0; i<M; i++) {
			//쿼리
			int a = kb.nextInt();//칭찬 받은 직원
			int v = kb.nextInt();//칭찬 값 
			
			dy[a] += v; //우선 기본값으로 칭찬값은 초기화 해두고 
		}
		
		DFS(1);
		for(int i=1; i<=N; i++) {
			System.out.print(dy[i] + " ");
		}
	}
}