package back_0301_1;

import java.util.Scanner;

/* 백준 2566번. 최댓값 
[입력]
첫째 줄부터 아홉 번째 줄까지 한 줄에 아홉 개씩 수가 주어진다. 
주어지는 수는 100보다 작은 자연수 또는 0이다.
[출력]
첫째 줄에 최댓값을 출력하고, 
둘째 줄에 최댓값이 위치한 행 번호와 열 번호를 빈칸을 사이에 두고 차례로 출력한다. 
최댓값이 두 개 이상인 경우 그 중 한 곳의 위치를 출력한다.
 * */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int[][] arr = new int[10][10];
		
		int max = 0;
		int x = 0, y = 0;
		
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				arr[i][j] = kb.nextInt();
				if(max < arr[i][j] ){
					max = arr[i][j];
					x = i;
					y = j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println((x+1) + " " + (y+1));
	}
}