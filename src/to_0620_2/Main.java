package to_0620_2;

import java.util.Scanner;

/* 1747번. 소수 팰린드롬 수 중에서 최솟값 찾기 */
public class Main {
	//수 판별 함수 
	static boolean isPalindrome(int target) { //투 포인터로 각 값 찍으면서 비교
		boolean answer = true;
		
		char[] tmp = String.valueOf(target).toCharArray();//문자형 배열로 변환시켜놓고
		int s=0, e=tmp.length-1;
		
		while(s < e) {
			if(tmp[s] != tmp[e]) { //양 끝에서 하나씩 찍어서 값 비교 시 하나라도 다르면 X
				answer = false;
			}
			s++;
			e--;
		}
		
		return answer;
	}
	
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
	
		int N = kb.nextInt();
		int[] A = new int[10000001];//범위까지 
		for(int i=2; i<A.length; i++) {
			A[i] = i;
		}
		
		for(int i =2; i< Math.sqrt(A.length); i++) { //배수 지우기 
			if(A[i] == 0) continue;
			for(int j=i+i; j<A.length; j= j+i) {
				A[j] = 0;
			}
		}
		//팰린드롬 수 판별 
		int i = N; //N보다 크거나 같은 숫자들 중에서 
		while(true) {
			if(A[i] != 0) {//즉, 소수인 수들 중에서 
				int target = A[i];
				if(isPalindrome(target)) {//팰린드롬 숫자인 경우 
					System.out.println(target);
					break;
				}
			}
			i++;// 하나씩 증가시키면서 ㄴ
		}
	}
}