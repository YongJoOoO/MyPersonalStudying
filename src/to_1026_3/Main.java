package to_1026_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 17471번. 게리맨더링 - DFS, BFS 문풀
 * @author MYLG
 *
 */
public class Main {
	static int N;
	static int[] people;//구역별 인구수
	static ArrayList<ArrayList<Integer>> graph;
	static boolean selected[];//분리용 
	static int res;//답
	
	//1) 구역 나누기 
	static void divide(int idx) {
		if(idx == N+1) {
			//나뉜 상태에서 각 선거구에 포함된 구역은 모두 연결된 상태인지 체크
			if(check()) {
				//모두 연결된 경우에 한해서
				int sumA = 0, sumB = 0;
				for(int i=1; i<=N; i++) {
					if(selected[i]) sumA += people[i];
					else sumB += people[i];
				}
				res = Math.min(res, Math.abs(sumA - sumB));
			}
		}
		
		//idx구역을 A구역으로 선택 
		selected[idx] = true;
		divide(idx+1);
		
		//idx구역을 A구역으로 미선택
		selected[idx] =false;
		divide(idx+1);
	}
	//2) 해당 구역 연결된 건지 확인
	static boolean check() {
		boolean[] visited = new boolean[N+1];
		
		int areaA = -1;
		//A선거구에 포함된 시작점 찾기
		for(int i=1; i<=N; i++) {
			if(selected[i]) {
				areaA = i;
				break;
			}
		}
		int areaB = -1;
		//B선거구에 포함된 구역 시작점 찾기 
		for(int i=1; i<=N; i++) {
			if(!selected[i]) {
				areaB = i;
				break;
			}
		}
		
		//각 선거구에 포함된 구역이 없ㄷ아면 false
		if(areaA == -1 || areaB == -1 )return false;
		
		//BFS탐색
		Queue<Integer> Q = new LinkedList<>();
		//A구역 모두 연결된 건지 확인
		Q.offer(areaA);//시작점
		visited[areaA] = true;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int nx: graph.get(cur)) {
				if(visited[nx])continue;
				if(!selected[nx]) continue;
				
				visited[nx] = true;
				Q.offer(nx);
			}
		}
		
		//B구역 모두 연결된지 확인
		 Q.offer(areaB);
		 visited[areaB] = true;
		 while(!Q.isEmpty()) {
			 int cur = Q.poll();
			 for(int nx : graph.get(cur)) {
				 if(visited[nx]) continue;
				 if(selected[nx]) continue;
				 
				 visited[nx] = true;
				 Q.offer(nx);
			 }
		 }
		 
		 //한곳이라도 연결 안된 점 있다면 false 리턴
		 for(int i=1; i<=N; i++) {
			 if(!visited[i]) {
				 return false;
			 }
		 }
		 return true;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		res = Integer.MAX_VALUE;//구역 차이 최솟값 저장될 용도임
		
		people = new int[N+1];
		selected = new boolean[N+1];
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		
		//각 구역별 인구수 입력받기 
		for(int i=1; i<=N; i++) people[i] = kb.nextInt();
		
		//인접한 구역 수, 인접영역 받기 
		for(int i=1; i<=N; i++) {
			//개수
			int cnt = kb.nextInt();
			for(int j=0; j<cnt; j++) {//개수만큼 입력받음
				int num = kb.nextInt();
				graph.get(i).add(num);//이렇게 연결시켜두기 
			}
		}
		
		divide(1);//1부터 시작 분리 
		
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}

}
