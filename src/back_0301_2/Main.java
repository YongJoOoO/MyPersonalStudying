package back_0301_2;

import java.util.Scanner;

/* 백준 11021번.
[입력]
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
[출력]
각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.
*/
public class Main {

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		int[] arr = new int[t+1];
		
		for(int i = 1; i<=t; i++) {
			arr[i] = kb.nextInt()+kb.nextInt();
		}
		
		for(int i = 1; i<=t; i++) {
			System.out.println("Case #"+i+": " + arr[i]);
		}
	}
}