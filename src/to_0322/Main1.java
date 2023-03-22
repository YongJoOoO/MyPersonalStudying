package to_0322;

import java.util.Scanner;

/* 7-12. 경로 탐색 (인접행렬) */
class Main1 {
	static int n, m, answer = 0; //입출력 변수 
	static int[][] graph; //그래프 표시 (인접행렬)
	static int[] ch; //방문 체크용 
	
	//DFS() 함수
	public void DFS(int v) {
		//들어온 정점v가 목적지n 도달시 카운팅++
		if(v==n) answer++;
		else {
			//각 정점 v에 대하여 가능한 정점i들 탐색하여 뻗어나감
			for(int i=1; i<=n; i++) {
				//각 정점v에 대해 가능한 i 탐색 동시에 방문전인 정점에 대하여 뻗어나감
				if(graph[v][i] == 1 && ch[i] == 0) {
					ch[i] = 1;//방문 체크
					DFS(i); //해당 i정점에 대하여 다시 뻗어나감 
					//여기부터는 DFS(i) 재귀 복귀주소라 다시 Back 작업
					ch[i] = 0; //체크 해제 (다른 정점에 대하여 다시 시도해야 하므로)
				}
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		//n, m 입력받고
		n= kb.nextInt();
		m= kb.nextInt();
		
		//n+1 해주는 이유는 1~ 사용할 것이므로 
		graph = new int[n+1][n+1];
		
		ch = new int[n+1] ; //체크용 동적 배열 생성시 0 초기화
		//가선의 수 만큼 돌면서 간선 정보 임력받음
		for(int i=0; i<m; i++) {
			int a= kb.nextInt();
			int b= kb.nextInt();
			graph[a][b] = 1; //입력받은 각 정점의 정점 정보에 1 세팅 
		}
		//일단 1은 무조건 '출발점'이므로 1체크
		ch[1] = 1;
		//1부터 보내서 DFS() 호출 
		T.DFS(1);
		//정답 출력
		System.out.println(answer);
	}
}