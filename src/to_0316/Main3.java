package to_0316;

import java.util.Arrays;
import java.util.Scanner;

/*6-5. 중복 확인 
[입력]
첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.
두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.
[출력]
첫 번째 줄에 D 또는 U를 출력한다.
*/
public class Main3 {
	//솔루션 함수 
	public String solution(int n, int[] arr ) {
		String answer = "U";
		Arrays.sort(arr); //정렬
		for(int i = 0; i<n-1; i++) {
			//이웃한 두 수 같을 경우 중복
			if(arr[i] == arr[i+1]) {
				return "D";
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n;i++) arr[i] = kb.nextInt();
		
		System.out.println(T.solution(n, arr));
	}

}