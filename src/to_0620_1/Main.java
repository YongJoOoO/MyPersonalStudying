package to_0620_1;

import java.util.Scanner;

// 1929번. 소수 구하기 
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int M = kb.nextInt();
		int N = kb.nextInt();
		
		int[] arr = new int[N+1];//N+1까지의 범위까지 소수 세팅 판별 용
		
		for(int i=2; i<=N; i++) {
			arr[i] = i;
		}
		
		//소수 판별
		for(int i=2; i<=Math.sqrt(N); i++) {
			if(arr[i] == 0) continue;
			
			for(int j= i+i; j<=N; j= j+i) { // 현재 i의 배수부터 N 전까지
				arr[j] = 0;//현재 i의 배수들은 모조리 제거 
			}
		}
		
		//이제 0인 값 제외하고 출력하면 소수 출력
		for(int i=M; i<=N; i++) {
			if(arr[i] != 0) {
				System.out.println(arr[i]);
			}
		}
	}
}