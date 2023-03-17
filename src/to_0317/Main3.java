package to_0317;

import java.util.*;

/* 6-10. 마구간 정하기 (결정 알고리즘) 
[입력]
첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.
[출력]
첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.
*/
public class Main3 {
	//유효 여부 
	public int count(int[]arr, int dist) {
		int cnt=1;
		int ep =arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i]-ep >= dist) {
				cnt++;
				ep=arr[i];
			}
		}
		return cnt;
	}
	
	//솔루션 함수
	public int solution(int n, int c, int[]arr ) {
		int answer= 0;
		
		//정렬
		Arrays.sort(arr);
		int lt = 1;
		int rt = arr[n-1];
		
		while(lt<=rt) {
			int mid = (lt+rt)/2;
			if(count(arr, mid) >= c) {
				answer=mid;
				lt = mid+1;
			}else rt = mid-1;
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int c = kb.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();		
	
		System.out.println(T.solution(n, c, arr));
	}
}