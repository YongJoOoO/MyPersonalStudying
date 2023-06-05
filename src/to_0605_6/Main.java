package to_0605_6;

import java.util.*;

/* 2750번. 수 정렬 하기 1 - 버블 정렬 사용 
 * */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j = 0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	
		for(int i=0; i<n; i++) System.out.println(arr[i]);
	}
}
