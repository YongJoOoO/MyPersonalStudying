package to_0322;

import java.util.ArrayList;
import java.util.Scanner;

/* 7-13. 경로탐색 (인접리스트, ArrayList)
 * */
class Main2 {
	static int n, m, answer =0 ;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch; //체크 배열 
	//DFS 함수 
	public void DFS(int v) {
		if(v==n) answer++;
		else {
			//그래프 속 v번 정점에 연결된 nv 정점들 하나씩 가져옴
			for(int nv : graph.get(v)) {
				//방문 전인 정점에 대하여 
				if(ch[nv] == 0) {
					ch[nv] = 1; //방문체크
					DFS(nv);//해당 정점에 대해 다시 찾음
					//복귀 후 back
					ch[nv] = 0; //백 처리
				}
			}	
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		
		//전체 크래프에 담을 각 정점 ArrayList 객체 생성 
		for(int i=0; i<=n; i++) {
			//각 정점i들을 담을 ArrayList 생성 
			graph.add(new ArrayList<Integer>());
		}
		//체크용 배열 생성 
		ch=new int[n+1];
		for(int i=0; i<m; i++) {
			int a =kb.nextInt();
			int b =kb.nextInt();
			//각각의 정점 a 가져와서, 다시 add 연결정점 b담음
			graph.get(a).add(b);
		}
		//최초 출발점 정점1 방문 세팅
		ch[1] = 1;
		T.DFS(1);
		//출력
		System.out.println(answer);
	}	
}