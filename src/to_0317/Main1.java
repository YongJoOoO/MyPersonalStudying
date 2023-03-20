package to_0317;

import java.util.Arrays;
import java.util.Scanner;

/* 6-8. 이분 검색
[입력]
첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
[출력]
첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.*/
public class Main1 {
	//솔루션 함수 
	public int solution(int n, int m, int[]arr) {
		int answer= 0;
		//1)오름차순 정렬시켜놓고
		Arrays.sort(arr);
		
		int lt = 0, rt = n-1; //0인덱스부터 시작했으니 끝은 n-1
		
		while(lt<=rt) {
			int mid = (lt+rt) / 2;
			//중앙값 = m 이면 정답
			if(arr[mid] == m) {
				answer = mid+1;
				break;//답 찾았으니 탈출 
			}
			// 중앙값 > m : 왼쪽에서 탐색해야 함 
			if(arr[mid] > m) {
				rt = mid - 1;
			}
			// 중앙값 < m : 오른쪽에서 탐색해야 함 
			else {
				lt = mid+1;
			}
		} 
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		
		System.out.println(T.solution(n, m, arr));
	}
}