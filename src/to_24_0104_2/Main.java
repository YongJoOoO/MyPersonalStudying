package to_24_0104_2;

import java.util.Scanner;

/**
 * 9663번. N-Queen 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int N;
	static int[] arr;
	static int count=0;
	
	//DFS
	static void DFS(int row) {
		if(row == N) {
			count++;//N행에 대해 N개 둔 거다.
			return;
		}
		//현재 row에 대한 적절한 열 col을 찾기 
		for(int col=0; col<N; col++) {
			arr[row] = col;
			if(isPossible(row, col)) {
				DFS(row+1);
			}
		}
	}
	//isPossible
	static boolean isPossible(int row, int col) {
		for(int i=0; i<row; i++) {
			if(arr[i] == arr[row] || arr[i] ==  col) {
				return false;
			}
		}
		
		for(int i=0; i<row; i++) {
			if(Math.abs(i-row) == Math.abs(arr[i]- arr[row])) return false;
		}
		
		return true;
	}
	
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		N = kb.nextInt();
		arr = new int[N];
		
		DFS(0);
		System.out.println(count);
	}
}