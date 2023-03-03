package to_0227;

import java.util.Scanner;

/*  2-1. 보이는 학생 
 *  [설명]
	선생님이 N명의 학생을 일렬로 세웠습니다. 
	일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 
	맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. 
	(앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)

 * */
public class Main2 {
	
	//솔루션 함수 
	public int solution(int n, int[] arr) {
		int answer = 1;
		
		int M = arr[0]; //첫 학생 무조건 초기화
		for(int i =0; i<n; i++) {
			if(arr[i] > M) {
				answer+=1;
				M = arr[i];
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		
		//입력
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		
		for(int i =0 ; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		//출력
		System.out.println(T.solution(n, arr));		
	}
}