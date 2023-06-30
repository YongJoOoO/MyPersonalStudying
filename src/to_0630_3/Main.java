package to_0630_3;

import java.util.Arrays;
import java.util.Scanner;

/*1253번. 좋은 수 */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		
		Arrays.sort(arr);

		int answer=0; //카운팅 세팅용 
		
		for(int k=0; k<n; k++) {
			int cur = arr[k]; //현재 찍은 k값에 대하여  
			int i = 0, j = n-1;//양쪽 끝에 두고 
			while(i < j) { // 두 포인터 만나기 전까지 반복하면서 
				if(arr[i] + arr[j] == cur) {//두 수의 합이 cur과 같다면
					if(i != k && j != k) {// 두 수 모두가 k번째도 아니라면 
						answer++;
						break;//현재의 turn은 종료 다음 turn으로 이동 
					}else if(i == k) { //현재 i가 k번쨰 수이면 
						i++;//i이동
 					}else if(j == k) { //현재 j가 k번째 수이면 
 						j--;//j이동 
 					}
				}else if(arr[i]+arr[j] < cur) { //cur보다 작다면 
					i++; 			
				}else if(arr[i]+arr[j] > cur) {
					j--;
				}
			}
		}
		//출력
		
		System.out.println(answer);
		
	}

}

