package to_0613_5;

import java.util.Arrays;
import java.util.Scanner;

/* 1920번. 원하는 정수 찾기 - 이분 탐색 
 * */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int n= kb.nextInt();
		int[] arr1 = new int[n];
		
		for(int i=0; i<n; i++) arr1[i]= kb.nextInt();
		
		int m =kb.nextInt();
		int[] arr2 = new int[m];
		for(int i=0; i<m; i++) arr2[i] = kb.nextInt();
		
		Arrays.sort(arr1);
		
		for(int i=0; i<m; i++) {
			int target = arr2[i];
			int st = 0;
			int ed = arr1.length - 1;
			
			boolean find = false;
			
			while(st<=ed) {
				int mid= (st+ed)/2;
				int mVal = arr1[mid];
				
				if(mVal < target) {
					st = mid+1;
				}else if(mVal > target) {
					ed = mid-1;
				}else {
					find = true;
					break;
				}
			}
			
			if(find) System.out.println(1);
			else System.out.println(0);
		}
		
	}

}
