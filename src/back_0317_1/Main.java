package back_0317_1;

import java.util.Arrays;
import java.util.Scanner;

/*  1920번. 수 찾기 | 이분 탐색
*/
public class Main {
	public static int binarySearch(int[] arr, int num) {
		int lt = 0;
		int rt = arr.length-1;
		int mid = 0;
		while(lt<=rt){
			mid = (lt+rt)/2;
			if(arr[mid] == num) return 1;
			else if(arr[mid]>num) rt = mid-1;
			else if(arr[mid]<num) lt = mid+1;
		}
		return 0;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr1 = new int[n];
		Arrays.sort(arr1);
		
		for(int i=0;i<n; i++) arr1[i] = kb.nextInt();

		int m = kb.nextInt();
		int[] arr2 = new int[m];
		for(int i =0; i<m; i++) arr2[i] = kb.nextInt();
		
		for(int i =0; i<m; i++) {
			System.out.println(binarySearch(arr1, arr2[i]));
		}
	}
}