package to_0605_8;

import java.util.Arrays;
import java.util.Scanner;

/*11399번. ATM 인출 시간 계산하기 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int n= kb.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		
		Arrays.sort(arr);
		
		//구간합 합배열
		int[] s = new int[n];
		s[0] = arr[0];
		for(int i=1; i<n; i++) {
			s[i] = s[i-1] + arr[i];//직전 합에 현재값 더함 
		}
		
		int sum = 0;
		for(int x : s) {
			sum+=x;
		}
		
		//최솟값 출력
		System.out.println(sum);
	}

}
