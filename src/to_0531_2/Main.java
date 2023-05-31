package to_0531_2;

import java.util.Arrays;
import java.util.Scanner;

/* 1940번. 주몽 
 * */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(); //재료 개수
		int m = kb.nextInt(); //합
		int[] arr= new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		//정렬
		Arrays.sort(arr);
		
		int st = 0, ed = n-1;//양끝단에 각각 두기 
		int count = 0;
		int sum = 0;
		while(st < ed) {
			sum = arr[st] + arr[ed];
			if(sum == m) {
				count++;
				st++;
				ed--;
			}else if(sum > m) {
				ed--;
			}else if(sum < m) {
				st++;
			}
		}

		System.out.println(count);
	}
}