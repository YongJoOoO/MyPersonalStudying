package to_0615_9;

import java.util.Arrays;
import java.util.Scanner;

/* 1449번. 수리공 항승 
 * */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int L = kb.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		Arrays.sort(arr);
		
		int cnt = 1;
		double st = arr[0] - 0.5;
		
		for(int i=1; i<n; i++) {
			if(st + L < arr[i]) { //커버 X 더 필요한 거니까 
				cnt++; 
				st = arr[i] - 0.5; //거기를 시작점으로 다시 
			}
		}
		System.out.println(cnt);
	}
}