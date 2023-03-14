package to_0314;

import java.util.Scanner;

/* 6-3. 삽입 정렬 
 * */
public class Main3 {
	//솔루션 함수 
	public int[] solution(int n, int[] arr) {
		
		for(int i = 1; i<n; i++) {
			int tmp = arr[i], j;
			for(j = i-1; j>=0; j--) {
				//tmp를 삽입할 위치 찾은 경우.
				if(arr[j] > tmp) {
					//뒤로 밀려야 됨
					arr[j+1] = arr[j];
				}
				else break;
			}
			//j가 멈춘 지점이 됨
			arr[j+1] = tmp;
		}
		
		return arr;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) arr[i] = kb.nextInt();
		
		//출력
		for(int x : T.solution(n, arr)) System.out.print(x + " ");
	}
}