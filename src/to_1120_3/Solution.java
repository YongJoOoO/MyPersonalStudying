package to_1120_3;

import java.util.*;

class Solution{
	
	static int N, P;
	static int[] arr1;
	static int[] arr2;
	
	static int[] visited;//방문에 대한 값
	
	static int[] number;
	static int max = Integer.MAX_VALUE;
	//DFS
	static void DFS(int lv, int st, int sum) {
		if(lv == N) {
			
		}else {
			for(int i=0; i<N; i++) {
				//1번 비료
				if(lv >= 1 && visited[lv-1] == 1) {
					sum -= P;
				}
				for(int j = st; j<=N; j++) {
					
				}
				
				
				//2번 비료 
			}
		}
		
	}

	//실행 메인 
	public static void main(String args[]) throws Exception{

		Scanner kb = new Scanner(System.in);

		int T = kb.nextInt();
		for (int test_case = 1; test_case <= T; test_case++){
			
			N = kb.nextInt();
			P = kb.nextInt();
			
			arr1 = new int[N];
			arr2 = new int[N];
			
			for(int i=0; i<N; i++) {
				arr1[i] = kb.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				arr2[i] = kb.nextInt();
			}
			
			
			// 표준출력(화면)으로 답안을 출력합니다.
			System.out.println("#" + test_case + " "+ max);
		}

		kb.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}
}
