package to_0907_B;

import java.util.Scanner;

/*최대 부분 증가수열 - DP*/
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int[] arr =new int[N];//그냥 데이터 받을 용
		for(int i=0; i<N; i++) arr[i]=  kb.nextInt();
		
		//dy[i] : i앞에서 i보다 작으면서 max 값 갖는 애 +1 처리
		int[] dy = new int[N];
		dy[0]=1;//무조건 고정 
		
		//1) 자신보다 앞에있는 애들 중 arr값이 작은 애들 중에 가장 큰 dy값 갖는 애 찾아서 +1처리 
		for(int i=1; i<N; i++) {
			int max = 0;
			for(int j=i-1; j>=0; j--) { //얘네로 앞을 순회하며 조건에 맞는 값 찾기 
				if(arr[i] > arr[j] && max < dy[j]) {
					max = dy[j];//얘가 가장 큰 값으로 갱신될거고 
				}
			}
			dy[i] = max +1;//가장 큰 값 + 1 처리 
		}
		
		//dy에 있는 값들 중 가장 큰 값 
		int answer = 0;
		for(int i=0; i<N; i++) {
			answer = Math.max(answer, dy[i]);
		}
		System.out.println(answer);
	}

}
