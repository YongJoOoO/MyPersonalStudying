package to_0615_A;

import java.util.Scanner;

/*백준 1929번. 소수 구하기*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int M = kb.nextInt();
		int N = kb.nextInt();
		int[] arr = new int[N+1];
		
		for(int i=2; i<=N; i++) { //배열을 인덱스값으로 채움
			arr[i]=i;
		}
		
		for(int i=2; i<=Math.sqrt(N); i++) {
			if(arr[i]==0) continue;//건너뜀
			
			for(int j= i+i; j<=N; j=j+i) { //배수 지우기 
				arr[j] =0;
			}
		}		
		//이제 0 제외 차례로 출력
		for(int i=M; i<=N; i++) {
			if(arr[i] != 0) {
				System.out.println(arr[i]);
			}
			
		}
	}
}