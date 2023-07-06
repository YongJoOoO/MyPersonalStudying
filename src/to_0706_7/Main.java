package to_0706_7;

import java.util.Scanner;

/*플로이드 - 11403번. 경로 찾기 문풀
 * 모든 경로에 대하여 갈 수 있는지 없는지만 따지면 됨 
 *  */
public class Main {
	static int n;
	static int[][] distance;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		n = kb.nextInt();
		distance = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int a= kb.nextInt();
				distance[i][j] = a;
			}
		}
		//연결이 되는지만 파악하면 돼
		for(int k=1; k<=n; k++) {//경유지 k에 대하여 
			//각각의 인접행렬 
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(distance[i][k] == 1 && distance[k][j]==1) {//k껴서 갈 수 있다면 
						distance[i][j] = 1;//얘도 가는 경로가 존재함
					}
				}
			}
		}
		
		//출력 시 없으면 0출력 
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(distance[i][j]+ " ");
			}
			System.out.println();
		}
	}
}