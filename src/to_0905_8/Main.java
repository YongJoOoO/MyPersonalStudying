package to_0905_8;

import java.util.*;

/*1058번. 친구 - 플롤이드 워샬 문풀 */
public class Main {

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String s = kb.next();
			for(int j=0; j<N; j++) {
				if(i==j) map[i][j] = 0;
				else {
					if(s.charAt(j) == 'Y') map[i][j] = 1;
					else if(s.charAt(j) == 'N') map[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		//플로이드 
		for(int k=0; k<N; k++) {
			//각각의 경유지 k를 거쳐서 
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			int cnt = 0;//행별로 카운팅 
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(map[i][j] <= 2) cnt++;
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
		
	}
}