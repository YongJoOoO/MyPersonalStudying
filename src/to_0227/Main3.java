package to_0227;

import java.util.Scanner;

/* 2-3. 가위바위보
 *  설명 : A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
	가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
	두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 * */

public class Main3 {

	//솔루션 함수 
	public String solution (int n, int[] a, int[] b) {
		String answer = "";
		
		for(int i = 0; i<n; i++) {
			//비김
			if(a[i] == b[i]) answer += "D"; 
			//이김
			else if(a[i] == 1 && b[i] == 3) answer += "A";
			else if(a[i] == 2 && b[i] == 1) answer += "A";
			else if(a[i] == 3 && b[i] == 2) answer += "A";
			//짐
			else answer += "B";
		}
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		//입력 
		int n = kb.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		for(int i =0 ;i<n; i++) {
			arr1[i] = kb.nextInt();
		}
		for(int i = 0; i<n; i++) {
			arr2[i] = kb.nextInt();
		}
		
		//출력
		for(char x: T.solution(n, arr1, arr2).toCharArray() ) {
			System.out.println(x);
		}
	}
}