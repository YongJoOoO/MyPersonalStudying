package to_0803_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//위상 정렬 섹션 - 백준 2252번. 줄 세우기 
public class Main {
	
	//실행메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		
		int n = kb.nextInt();//노드 개수
		int m = kb.nextInt();//간선 개수 
		
		int[] indegree = new int[n+1];//진입차수 저장용 
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());//공간 생성 
		}
		
		//데이터 입력 받기 
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();//a 가 
			int b = kb.nextInt();//b에 진입함
			
			graph.get(a).add(b);//방향 a->b를 향함 
			indegree[b]++;//진입당하는 애는 ++ 처리 
		}
		
		//이제 위상정렬 알고리즘 
		Queue<Integer> Q = new LinkedList<>();//큐 생성 
		
		for(int i=1; i<=n; i++) { //정점 차례로 순회하면서 일단 진입차수 0인 애들 다 담음
			if(indegree[i] == 0) {
				Q.add(i);
			}
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			//여기서 경로 뽑기 
			answer.add(cur);
			for(int nx : graph.get(cur)) { //뽑은 정점의 인접 정점들의 진입차수 --
				indegree[nx]--;
				if(indegree[nx]==0) Q.add(nx);//0인 애는 또 담기 
			}
		}
		
		//정답 출력 
		for(int x : answer)System.out.print(x+ " ");
	}
}