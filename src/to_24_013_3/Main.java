package to_24_013_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 9663번. N-Queen 문제 - 백트래킹 문풀
 * @author MYLG
 */
public class Main {
	static int[] arr;
	static int N;
	static int count = 0;
	
	//DFS - 깊이는 행을 의미한다. 
	public static void DFS(int depth) {
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			arr[depth] = i;
			if(possible(depth)) {
				DFS(depth+1);
			}
		}	
	}
	//다음 깊이 탐색 가능 조건 확인용 
	public static boolean possible(int col) {
		for(int i = 0 ; i < col ; i++) {
		//행에 일치하는게 있는지 판별
			if(arr[i]==arr[col]) {
				return false;
			}
			//대각선에 일치하는게 있는지 판별
			else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
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