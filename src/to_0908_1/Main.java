package to_0908_1;

import java.util.Scanner;

/*백준2156번 포도주 시식 DP 풀이*/
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int[] arr = new int[N+1];
		int[] dy = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = kb.nextInt();
		}
		
		//dy 시작할 건데 
		dy[1] = arr[1];
		if(N>1) {
			dy[2] = arr[1] + arr[2];
		}
		
		//3부터는 연속 3가지가 합칠 수는 없다고 했다.
		//dy[i]는 i번째 잔까지 고려했을 때 연속3 합 아닌 최대 포도주 양을 담을 거임
		
		for(int i=3; i<=N; i++) {
			//3번쨰 위치부터는 연속 세가지 합이 안되도록 하는 크게 선택지가 3개 주어진다.
			//1) 직전값을 그대로 가져옴 (단, 현재값은 합치지 않음) - 연속3합 되니까
			//2) 앞앞 값을 가져와서 + arr[i] 현재값 더함 
			//3) 앞앞앞 값 + arr[i-1] + arr[i] 값 
			//-> 이들 중 가장 큰 값으로 dy[i]를 세팅한다.
			dy[i] = Math.max(dy[i-1],  Math.max(dy[i-2] + arr[i], dy[i-3] + arr[i-1] + arr[i]));
		}
		
		System.out.println(dy[N]);
	}
}