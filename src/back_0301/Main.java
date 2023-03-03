package back_0301;

import java.util.Scanner;

/* 백준. 2738번. 행렬 덧셈
 * 문제
	N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.
 * */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		int[][] arr1 = new int[N][M];
		int[][] arr2 = new int[N][M];
		//입력 
		for(int i =0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				arr1[i][j] = kb.nextInt();
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j< M; j++) {
				arr2[i][j] = kb.nextInt();
			}
		}
		
		//솔루션
		for(int i =0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				System.out.print(arr1[i][j] + arr2[i][j] + " ");
			}
			System.out.println();
		}
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	}                                                          
}