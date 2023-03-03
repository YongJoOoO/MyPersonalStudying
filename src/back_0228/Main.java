package back_0228;

import java.util.Scanner;

/* 백준. 5597번. 과제 안 내신 분?
 * [입력] 입력은 총 28줄로 각 제출자(학생)의 출석번호 n(1 ≤ n ≤ 30)가 한 줄에 하나씩 주어진다
 * [출력] 출력은 2줄이다. 
 * 	1번째 줄엔 제출하지 않은 학생의 출석번호 중 가장 작은 것을 출력하고,
 *  2번째 줄에선 그 다음 출석번호를 출력한다.
 * */
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		// i 인덱스에 출석번호 체크용 배열 1번 ~ 30번 생성 
		int[] student = new int[31]; //전체 1번 ~ 30번 자리만 생성해두고
		
		//입력 시, 제출 학생 체크시킴 (입력 받는 건 28명이니까 29까지 돌고) 
		for(int i = 1; i<29; i++) {
			int ok = kb.nextInt();
			student[ok] = 1; //입력된 값과 같은 i 인덱스 배열에 체크용 1 담고 
		}
		
		//출력 시, 체크 안된 애 순서대로 출력 
		//반드시 길이는 student.length 로 줘야 한다. 
		//전체 30명에 대해서 체크 안된 애만 골라나와야 하므로
		for(int i =1 ; i<student.length; i++) {
			if(student[i] != 1) {
				System.out.println(i);
			}
		}
	}
}