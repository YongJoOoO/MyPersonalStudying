package to_0614_1;

import java.util.Scanner;

/* 11047번. 동저 개수 최솟값 - 그리디 알고리즘 
 * */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb =new Scanner(System.in);
		
		int N = kb.nextInt();//동전 개수
		int K = kb.nextInt(); //목표 금액 
		
		int arr[] = new int[N];//동전 묶음
		//입력 받기 
		for(int i=0; i<N; i++) arr[i] = kb.nextInt();
		
		int answer = 0;//최소 동전 개수 저장용 
		//그리디 알고리즘 
		//일단 최소 동전 쓰려면 역순 큰 값부터 대조
		for(int i=N-1; i>=0; i--) {
			if(arr[i] <= K) { // 각 동전값이 K보다 작거나 같다 == 만들 수 있다이므로 
				answer += K/arr[i];//그 나눈 몫은 동전 개수로 누적
				K = K%arr[i];//나머지는 K값으로 갱신 처리 
			}
		}
		//정답 출력 
		System.out.println(answer);
	}
}