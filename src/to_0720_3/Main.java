package to_0720_3;

import java.util.Scanner;

//플로이드 
class Node{
	int s;
	int e;
	int val;
	Node(int s, int e, int val){
		this.s = s;
		this.e = e;
		this.val =val;
	}
}
public class Main {
	static int N, M;
	static int[][] distance;//인접 행렬로 풀기 
	static final int INF = 10000001;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		distance= new int[N+1][N+1];
		
		//인접행렬 초기화
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) {
					distance[i][j] = 0;
				}else {
					distance[i][j]= INF;//초기화 
				}
			}
		}
		
		//간선 개수만큼 입력받기 
		for(int i=0; i<M; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			int val = kb.nextInt();
			if(distance[s][e]> val) { //기존 값보다 더 작은 가중치 입력된 경우 
				distance[s][e] = val;//갇중치 담기 
			}
		}
		
		//플로이드 수행 
		for(int k=1; k<=N; k++) { //차례로 경유지 
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(distance[i][j] > distance[i][k]+distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j]; //얻ㅂ데이트 
					}
				}
			}
		}
		
		//정답 출력 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(distance[i][j] == INF) {
					System.out.print("0");
				}else {
					System.out.print(distance[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		
	}

}
