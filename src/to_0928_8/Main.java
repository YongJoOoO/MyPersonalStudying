package to_0928_8;

import java.util.ArrayList;
import java.util.Scanner;

/*1613번. 역사 - 플로이드 문풀 */
public class Main {	
	static boolean[][] map; //방문 가능한지 담을 거고
	static int n, K, s;
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);	
		
		n = kb.nextInt();
		K = kb.nextInt();
		
		map = new boolean[n+1][n+1];
		
		for(int i=0; i<K; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			map[a][b] = true;
		}
		
		//플로이드 워샬 
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					//k를 거쳐서 연결되기만 하면 true 처리 
					if(map[i][k] && map[k][j]) {
						map[i][j] = true;
					}
				}
			}
		}
		
		s = kb.nextInt();//쌍의 수 
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<s; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			if(map[a][b] == true) { //a가 먼저 b 나중이면 
				arr.add(-1);
			}else {
				if(map[b][a] == true) {//b먼저 a 다음이면 
					arr.add(1);
				}else {
					//그것도 아니면 아예 연결이 안된 것이므로 
					arr.add(0);
				}
			}
		}		
		//정답 출력 
		for(int x : arr) {
			System.out.println(x);
		}
	}
}