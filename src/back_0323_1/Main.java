package back_0323_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 24481번. 깊이 우선 탐색3  => 왜 틀렸지 ? 
 * */
public class Main {
	static int n, m, r, cnt=0;
	static int[] ch; //체크 배열
	static int[] lv; //깊이 레벨 배열
	static ArrayList<ArrayList<Integer>> graph;
	//DFS
	public void DFS(int v) {
		ch[v]= 1;
		lv[v] = cnt++;
		for(int nv: graph.get(v)) {
			if(ch[nv] == 0) {
				ch[nv]= 1;
				DFS(nv);
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		r = kb.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		//공간 생성 
		for(int i =0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		ch = new int[n+1];
		lv = new int[n+1];
		
		//입력받기
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			//무방향
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		//오름차순 정렬
		for(int i =1; i<=n; i++) {
			Collections.sort(graph.get(i));
		}
		//우선 lv 값은 기본 -1로 전체 초기화 해둠 
		//그래야 방문 안한 애는 -1로 출력함
		Arrays.fill(lv, -1);
		
		//호출
		T.DFS(r);
		//출력
		for(int i=1; i<=n; i++) {
			System.out.println(lv[i]);
		}
	}
}