package to_0302;

import java.util.ArrayList;
import java.util.Scanner;

/* 3-1. 두 배열 합치기
[설명] 효율성 
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
*/
public class Main1 {
	//솔루션 함수 
	public ArrayList<Integer> solution(int n, int m, int[]a, int[]b) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		int p1 =0, p2 = 0; //두 개의 포인터 선언
		
		//각각 지칭할 배열 크기 안에서만 돌도록 조건 넣고 
		while(p1 < n && p2 <m) {
			if(a[p1] < b[p2]) {
				answer.add(a[p1++]); //먼저 a[p1] 넣고 p1++ 된다.
			}else{
				answer.add(b[p2++]);
			}
		}
		//어떤 지칭 p가 나왔으면. 이제 남은 애들 answer에 누적시키기 위해
		//각각의 남은 경우 대비해서 add 처리 
		while(p1<n) answer.add(a[p1++]);
		while(p2<m) answer.add(b[p2++]);
		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		
		//입력
		int n = kb.nextInt();
		int[] a = new int[n];
		for(int i = 0; i<n; i++) {
			a[i] = kb.nextInt();
		}
		
		int m = kb.nextInt();
		int[] b = new int[m];
		for(int i = 0; i<m; i++) {
			b[i] = kb.nextInt();
		}
		//출력 
		for(int x : T.solution(n, m, a, b)) {
			System.out.print(x + " ");
		}
	}
}