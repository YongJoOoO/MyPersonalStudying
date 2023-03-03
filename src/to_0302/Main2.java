package to_0302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 3-2 공통원소 구하기 (교집합-> 오름차순)
 A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
*/
public class Main2 {
	//솔루션 함수 
	public ArrayList<Integer> solution(int n, int m, int[]a, int[]b){
		ArrayList<Integer> answer = new ArrayList<>();
		int p1 = 0, p2 = 0;
		
		//1) 먼저 두 배열 오름차순 정렬 시킬 것 
		Arrays.sort(a);
		Arrays.sort(b);
		
		//2) 공통원소 담기 (한 배열 끝나면 끝. 교집합만 구하는 거기 때문)
		while(p1 < n && p2 <m) {
			if(a[p1] == b[p2]) {
				answer.add(a[p1++]); //같은 애 둘 중 하나만 담음 
				p2++;
			}else if(a[p1] < b[p2]) {
				p1++; //더 작은 애의 포인터만++
			}else {
				p2++; //더 작은 애의 포인터만++
			}
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
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