package to_0228;

import java.util.ArrayList;
import java.util.Scanner;

/* 2-6. 뒤집은 소수
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
   예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 
   그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
   첫 자리부터의 연속된 0은 무시한다.
*/
public class Main2 {
	//소수 판별 함수 
	public boolean isPrime(int num) {
		if(num == 1) return false;
		for(int i = 2; i<num; i++) {
			//1제외 i=2~num 전 까지 약수가 존재하면 false
			if(num % i == 0) return false;
		}
		//아니면 소수 맞음
		return true;
	}
	//솔루션 함수 
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		//1) 숫자 뒤집기
		for(int i =0; i<n; i++) {
			//초기화
			int tmp = arr[i]; //원본 
			int res = 0; //뒤집은 애
			
			//뒤집기 
			while(tmp > 0) {
				int t = tmp % 10;
				res = res * 10 + t;
				tmp = tmp/10;
			}
			//2) 뒤집은 숫자의 소수 판별 -> 답에 add()
			if(isPrime(res)) answer.add(res);
		}		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		//출력
		for(int x : T.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}
}