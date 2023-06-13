package to_0613_6;

import java.util.Scanner;

/*2343번. 기타 레슨 - 이분 탐색 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();//총 레슨 수 
		int m = kb.nextInt();//최대 블루레이 개수 
		int st=0, ed =0;
		
		int[]arr = new int[n];
		for(int i =0; i<n; i++) {
			arr[i] = kb.nextInt();
			st = Math.max(st, arr[i]);
			ed += arr[i];
		}
		
		//이분 탐색 시도할 st = 최대값, ed = 총합
		while(st<=ed) {
			int mid = (st+ed)/2;
			int sum = 0;
			int cnt = 0;//카운팅용
			
			for(int i=0; i<n; i++) {
				//만약 현재 sum이 mid초과시
				if(sum + arr[i] > mid) {
					cnt++;//카운팅 ++
					sum = 0; //sum=0 하고 다음 블루레이 담을 수 있는 값으로 갈 것 
				}
				sum += arr[i]; 
			}
			
			//탈출 후
			if(sum != 0) cnt++;//남은 애 있으면 일단 담을 cnt++처리
			
			//카운팅한 블루레이 개수가 조건보다 작으면 (모두 다 담을 수 있는 경우) 
			if(cnt <= m) {
				ed = mid-1;
			}else if(cnt >m ) { //모두 다 담을 수 없는 경우 
				st = mid+1;
			}
			
		}
		//최종 st에 담긴 값이 최솟값이 됨
		System.out.println(st);
		
	}

}
