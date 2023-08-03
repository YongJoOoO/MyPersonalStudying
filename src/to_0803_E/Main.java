package to_0803_E;
import java.util.Scanner;

//플로이드 - 문제풀이 
public class Main {
	static int[][] distance;//s->e로 가는 최단경로 저장용
	static final int INF = 10000001;//최대 100 X100000 
	//실행메인	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();//노드 개수 = 도시
		int m = kb.nextInt();//간선 개수 = 노선
		
		//distance 초기화
		distance = new int[n+1][n+1];//도시가 1번~n번까지 존재하므로
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) distance[i][j] = 0;//자기자신 0 세팅 
				else {
					distance[i][j] = INF;//제일 큰 값으로 초기확 
				}
			}
		}
		
		//입력 데이터 얻기
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			int val = kb.nextInt();
			if(distance[a][b] > val) {
				distance[a][b]= val;
			}
		}
		
		//플로이드 알고리즘 시작 
		for(int k=1; k<=n; k++) { //경유지 하나씩 설정해보는 거임 
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(distance[i][j]> distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];//경로 갱신 최단 거리로
					}
				}
			}
		}
		
		//출력
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(distance[i][j] == INF) {
					System.out.print("0 ");
				}else {
					System.out.print(distance[i][j]+" ");
				}
			}
			System.out.println();//출력
		}
	}

}