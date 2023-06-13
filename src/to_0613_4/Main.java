package to_0613_4;

import java.util.*;

/* 1920번. 이분 탐색 - 수찾기 문제 
 * */
public class Main {	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int N = kb.nextInt();
		
		int[] arr1 = new int[N];
		//입력 받기 
		for(int i=0; i<N; i++) arr1[i] = kb.nextInt();
		
		int M = kb.nextInt();
		int[] arr2 = new int[M];
		//입력 받기 
		for(int i=0; i<M; i++) arr2[i] = kb.nextInt();
		
		//1) 일단 대상 데이터 셋 정렬
		Arrays.sort(arr1);
		
		for(int i=0; i<M; i++) {
			int target = arr2[i];
			
			boolean find = false;
			
			//이진탐색 시작 
			int st = 0;
			int ed = arr1.length -1;
			
			while(st<=ed) {
				int mid = (st+ed) / 2;
				int mVal = arr1[mid];
				
				if(mVal < target) {
					st = mid+1;
				}else if(mVal > target) {
					ed = mid -1;
				}else {
					//둘이 만난 경우
					find = true;
					break;
				}
			}
			
			//이번 arr2[i] 값에 대한 타겟 발견 시 
			if(find) System.out.println(1);
			else System.out.println(0);
			
		}
	}

}
