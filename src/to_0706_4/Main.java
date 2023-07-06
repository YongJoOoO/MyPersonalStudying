package to_0706_4;

import java.util.ArrayList;
import java.util.Scanner;

/* 2660번. 회장 뽑기 문제 
 * */
public class Main {
	//static
	static int N;
	static int[][] distance;
	static final int INF = 100;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		distance = new int[N+1][N+1];
		
		//초기화 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j ) distance[i][j]= 0;
				else {
					distance[i][j]= INF;
				}
			}
		}
		
		//입력 데이터 저장 
		while(true) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			if(a == -1 && b == -1) {
				break;
			}
			//친구 사이 = 양방향 
			distance[a][b] = 1;
			distance[b][a] = 1;
		}
		
		//플로이드 워샬 
		for(int k=1; k<=N; k++) {
			for(int i = 1; i<=N; i++) {
				for(int j =1; j<=N; j++) {
					if(distance[i][j] > distance[i][k]+ distance[k][j]) {
						distance[i][j]= distance[i][k]+distance[k][j];
					}
				}
			}
		}
		
		int readerScore = INF;
		//각 i에 대한 최대 다리걸친 수가 답이 되는데 
		int [] person = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			int score=0;
			for(int j=1; j<=N; j++) {
				if(distance[i][j] != INF) {
					score = Math.max(score, distance[i][j]);
				}
			}
			//각 i에 대한 점수는 최댓값 
			person[i] = score;
			//그 중 후보자 점수값은 그 중 최솟값으로 세팅 
			readerScore= Math.min(readerScore, score);
		}
		
		ArrayList<Integer> answer = new ArrayList<>();

		for(int i=1; i<=N; i++) {
			if(readerScore == person[i]) {
				answer.add(i);
			}
		}
		//점수 출력 
		System.out.println(readerScore+" "+answer.size());
		for(int x : answer) {
			System.out.print(x+ " ");
		}
	}
}