package to_24_013_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 9663번. N-Queen 문제 - 백트래킹 문풀
 */
public class Main {
	static int[] arr;
	static int N;
	static int count = 0;
	
	//DFS - 깊이는 행을 의미한다. 
	public static void DFS(int row) { //행으로 깊이 탐색을 시도 
		if(row == N) {
			count++;
			return;
		}
		
		for(int j = 0 ; j < N; j++) {
			arr[row] = j; //현재 row 행의 j 에 퀸을 위치시킴 
			if(possible(row)) {
				DFS(row+1); //다음 행으로 더 깊이 탐색 
			}
		}	
	}
	
	/**
	 * arr[i] = j는 i 행의 j 열에 퀸이 위치한다는 것을 의미합니다. 
	 * 이 코드에서 arr[] 배열은 각 행마다 퀸이 위치한 열을 나타냅니다.
	 */
	public static boolean possible(int row) {
		//직전의 row에 대해서 다음에 둘 수 있는 열의 위치 i로 탐색하고자 함 
		for(int i = 0 ; i < row ; i++) {
			//모든 행을 탐색하면서 행에 담긴 열의 값이 들어온 행에 대한 열의 값과 같은지 판단합니다. 
			if(arr[i]==arr[row]) {
				return false;
			}
			//대각선에 공격 가능 (직전 행 - 현재 행) (직전 열 - 현재 열) 두 차이의 절댓값 값이 같다는 건 동일 대각선 상에 있다는 뜻입니다. 
			else if(Math.abs(row-i) == Math.abs(arr[row]-arr[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	//실행 메인 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		N = Integer.parseInt(str);
		arr = new int[N];
		
		DFS(0);
		System.out.println(count);
	}
}