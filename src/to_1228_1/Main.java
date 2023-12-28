package to_1228_1;

import java.util.Scanner;

/**
 * 9466번. 텀 프로젝트 - DFS 풀이
 * @author MYLG
 *
 */
public class Main {
	static int TC;
	static int N;
	static int[] arr;
	static boolean[] visited;
	static boolean[] isDone;
	static int count;
	//DFS
	static void DFS(int now) {
		if(visited[now]) return;
		
		visited[now] = true;
		int nx = arr[now];//다음 방문할 정점
		
		if(!visited[nx]) {
			//다음 정점이 이미 방문한 정점 아닌 경우면 더 깊이 탐색한다.
			DFS(nx);
		}else {
			//이미 방문한 정점이라면 사이클을 확인해야 한다.
			if(!isDone[nx]) {
				//만약 아직 끝정점은 아니라면
				count++; //1++
				for(int i=nx; i!=now; i=arr[i]) {
					//사이클을 이루는 정점을 계속해서 따라가며 사이클의 길이를 측정합니다. 
					// 시작 정점까지 돌아오면서 count를 증가시킵니다.
					count++;
					//이 코드의 목적은 주어진 그래프에서 사이클의 길이를 찾는 것입니다.
				}
			}
		}
		
		//모든 작업 끝나면 더 이상 사용 X
		isDone[now] = true;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		TC = kb.nextInt();
		for(int t= 0; t<TC; t++) {
			N = kb.nextInt();
			arr = new int[N+1];
			visited = new boolean[N+1];
			isDone = new boolean[N+1];
			count=0;
			
			for(int i=1; i<=N; i++) arr[i]= kb.nextInt();
			
			for(int i=1; i<=N; i++) {
				if(!visited[i]) {
					DFS(i);
				}
			}
			
			System.out.println(N-count);
		}
	}
}