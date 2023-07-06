package to_0706_2;

import java.util.Scanner;

/*11403번. 경로찾기 */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int [][] distance= new int [N+1][N+1];
		//인접 행렬 입력 데이터 저장
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				distance[i][j]= kb.nextInt();
			}
		}
		
		//플로이드 워샬 -> K 경로 경유해서 S->E 갈 수 있는지 확인 후 세팅 
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(distance[i][k] == 1 && distance[k][j] ==1) {
						distance[i][j] = 1;
					}
				}
			}
		}	
		//그 결과 그대로 출력 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(distance[i][j]+" ");
			}
			System.out.println();
		}
	}
}