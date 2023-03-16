package to_0316;

import java.util.Scanner;

/*6-3. 삽입 정렬| 복습*/
public class Main1 {

	public int[] solution(int n, int[] arr) {

		for(int i = 1; i<n; i++) {
			int tmp = arr[i];
			int j;
			for(j = i-1; j>=0; j--) {
				if(arr[j] > tmp) {
					//S집합 값을 U집합 쪽으로 밀기
					arr[j+1] = arr[j];
				}else break; //삽입 지점 찾았으면 break
			}
			//멈춘 지점에서 tmp 값도 세팅
			arr[j+1] = tmp;
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) arr[i] = kb.nextInt();
		
		for(int x : T.solution(n, arr)) System.out.print(x + " ");
	}
}