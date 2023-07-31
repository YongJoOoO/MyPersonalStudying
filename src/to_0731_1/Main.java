package to_0731_1;

import java.util.Scanner;

//최대부분 증가 수열 
public class Main {
	static int[] dy;
	
	static int solution(int n, int[] arr) {
		int answer = 0;
		dy = new int[n];
		dy[0] = 1;//길이 1 초기화
		
		for(int i=1; i<n; i++) {
			int max = 0;
			//j로 i앞을 순회하면서 현재 i로 찍은 값보다 작은 arr[j] 이면서 dy[j]의 최대값에 +1처리 해줄 거임
			for(int j=i-1; j>=0; j--) {
				if(arr[i] > arr[j] && dy[j] > max) {
					max = dy[j];
				}
			}
			dy[i] = max+ 1;//가장 큰 값 +1 처리 
			answer = Math.max(answer, dy[i]); 
		}	
		return answer ;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) arr[i] = kb.nextInt();
		
		System.out.println(solution(N, arr));
	}
}